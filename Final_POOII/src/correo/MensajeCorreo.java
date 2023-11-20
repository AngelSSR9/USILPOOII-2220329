
package correo;

import clases.observer.ElementoObservado;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Clase encargada de enviar mensajes de correo electrónico.
 */
public class MensajeCorreo {
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String SMTP_AUTH = "true";
    private static final String SMTP_STARTTLS_ENABLE = "true";
    private static final String FROM_ADDRESS = "pruebamonitor7@gmail.com";
    private static final String PASSWORD = "togj fhkc imxh wldz";
    private static final String HTML_TEMPLATE_PATH = "/correo/correohtml.html";
    private static final String LOGO_IMAGE_PATH = "/correo/images/imagenTienda-removebg-preview.png";
    private static final String IMAGE_CID_LOGO = "<imagen321>";
    private static final String IMAGE_CID_PRODUCTO = "<imagen123>";

    /**
     * Envía un mensaje de correo electrónico con información sobre un nuevo producto.
     *
     * @param elementoObservado El objeto observado del cual se enviará la notificación.
     * @param correoCliente     La dirección de correo electrónico del cliente a la que se envía el correo.
     */
    public void enviarMensaje(ElementoObservado elementoObservado, String correoCliente) {
        try {
             // Configuración de propiedades para el servidor SMTP
            Properties properties = new Properties();
            properties.put("mail.smtp.host", SMTP_HOST);
            properties.put("mail.smtp.port", SMTP_PORT);
            properties.put("mail.smtp.auth", SMTP_AUTH);
            properties.put("mail.smtp.starttls.enable", SMTP_STARTTLS_ENABLE);

            // Creación de una sesión de correo
            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);

            // Configuración del mensaje
            message.setFrom(new InternetAddress(FROM_ADDRESS));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(correoCliente));
            message.setSubject("Nuevo Producto");
            message.setText("Se ha subido un nuevo producto", "ISO-8859-1", "html");

            // Cargar el contenido HTML
            InputStream htmlStream = getClass().getResourceAsStream(HTML_TEMPLATE_PATH);
            String htmlContent = convertInputStreamToString(htmlStream);
            htmlContent = replacePlaceholders(htmlContent, elementoObservado);

            // Crear el cuerpo multipart para incluir texto HTML y la imagen
            MimeMultipart multipart = createMultipart(htmlContent, elementoObservado);

            // Establecer el contenido del mensaje
            message.setContent(multipart);

            // Enviar el mensaje
            Transport mTransport = session.getTransport("smtp");
            mTransport.connect(FROM_ADDRESS, PASSWORD);
            mTransport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convierte un flujo de entrada en una cadena.
     *
     * @param inputStream El flujo de entrada a convertir.
     * @return La cadena resultante.
     * @throws IOException Si hay un error al leer el flujo de entrada.
     */
    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    /**
     * Reemplaza los marcadores de posición en el contenido HTML con los valores del objeto observado.
     *
     * @param htmlContent        El contenido HTML con marcadores de posición.
     * @param elementoObservado El objeto observado que proporciona los valores para reemplazar.
     * @return El contenido HTML con los marcadores de posición reemplazados.
     */
    private String replacePlaceholders(String htmlContent, ElementoObservado elementoObservado) {
        htmlContent = htmlContent.replace("{PRODUCTO_NOMBRE}", elementoObservado.cargarNombre());
        htmlContent = htmlContent.replace("{PRODUCTO_STOCK}", Integer.toString(elementoObservado.cargarStock()));
        htmlContent = htmlContent.replace("{PRODUCTO_PRECIO}", Double.toString(elementoObservado.cargarPrecio()));
        htmlContent = htmlContent.replace("{PRODUCTO_DESCRIPCION}", elementoObservado.cargarDescripcion());
        return htmlContent;
    }

    /**
     * Crea la parte multipart del mensaje que incluye texto HTML y la imagen del producto.
     *
     * @param htmlContent        El contenido HTML del mensaje.
     * @param elementoObservado El objeto observado que proporciona la imagen del producto o pc.
     * @return La parte multipart del mensaje.
     * @throws MessagingException Si hay un error al construir la parte multipart.
     * @throws IOException       Si hay un error al leer la imagen del producto o pc.
     */
    private MimeMultipart createMultipart(String htmlContent, ElementoObservado elementoObservado) throws MessagingException, IOException {
        MimeMultipart multipart = new MimeMultipart("related");

        // Parte HTML
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(htmlContent, "text/html");
        multipart.addBodyPart(htmlPart);

        // Parte de la imagen del producto o pc
        MimeBodyPart imagePart = new MimeBodyPart();
        Image imagenProducto = elementoObservado.cargarImagen();
        InputStream imgStream = ImageUtils.convertImageToInputStream(imagenProducto, "png");
        byte[] imageBytes = convertInputStreamToBytes(imgStream);
        imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(imageBytes, "image/png")));
        imagePart.setHeader("Content-ID", IMAGE_CID_PRODUCTO);
        multipart.addBodyPart(imagePart);

        // Parte de la imagen del logo
        MimeBodyPart logoPart = new MimeBodyPart();
        InputStream imgLogo = getClass().getResourceAsStream(LOGO_IMAGE_PATH);
        byte[] logoBytes = convertInputStreamToBytes(imgLogo);
        logoPart.setDataHandler(new DataHandler(new ByteArrayDataSource(logoBytes, "image/png")));
        logoPart.setHeader("Content-ID", IMAGE_CID_LOGO);
        multipart.addBodyPart(logoPart);

        return multipart;
    }

    /**
     * Convierte un flujo de entrada en un array de bytes.
     *
     * @param inputStream El flujo de entrada a convertir.
     * @return El array de bytes resultante.
     * @throws IOException Si hay un error al leer el flujo de entrada.
     */
    private byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
