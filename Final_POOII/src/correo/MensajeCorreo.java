
package correo;

import clases.Producto;
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
     * @param producto       El producto del cual se enviará la notificación.
     * @param correoCliente  La dirección de correo electrónico del cliente a la que se envia el correo.
     */
    public void enviarMensaje(Producto producto, String correoCliente) {
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
            htmlContent = replacePlaceholders(htmlContent, producto);

            // Crear el cuerpo multipart para incluir texto HTML y la imagen
            MimeMultipart multipart = createMultipart(htmlContent, producto);

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

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    private String replacePlaceholders(String htmlContent, Producto producto) {
        htmlContent = htmlContent.replace("{PRODUCTO_NOMBRE}", producto.getTipo() + " " + producto.getMarca() + " " + producto.getModelo());
        htmlContent = htmlContent.replace("{PRODUCTO_STOCK}", Integer.toString(producto.getStock()));
        htmlContent = htmlContent.replace("{PRODUCTO_PRECIO}", Double.toString(producto.getPrecio()));
        htmlContent = htmlContent.replace("{PRODUCTO_DESCRIPCION}", producto.getDescripcion());
        return htmlContent;
    }

    private MimeMultipart createMultipart(String htmlContent, Producto producto) throws MessagingException, IOException {
        MimeMultipart multipart = new MimeMultipart("related");

        // Parte HTML
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(htmlContent, "text/html");
        multipart.addBodyPart(htmlPart);

        // Parte de la imagen del producto
        MimeBodyPart imagePart = new MimeBodyPart();
        Image imagenProducto = producto.getImagen();
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
