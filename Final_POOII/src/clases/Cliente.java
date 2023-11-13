package clases;

import clases.observer.Observer;
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
import correo.ImageUtils;
import java.awt.Image;

public class Cliente  implements Observer{
    private String nombre;
    private int dni;
    private int id;
    private String correo;
    private String contraseña;

    public Cliente(String nombre, int dni,String correo, String contraseña) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Cliente(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void actualizar(Producto producto) {
        enviarMensaje(producto);
    }
    public void enviarMensaje(Producto producto){
        //Se crea la clase propiedades para luego configurarlo
        Properties properties = new Properties();
        
        // Configuración del servidor de correo
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        //Se crea una session en la que se pasan las propiedades configuradas
        Session session = Session.getDefaultInstance(properties);
        // Creación y envío del correo
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pruebamonitor7@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(getCorreo()));
            System.out.println("se sta enviando correo a: " + getCorreo());
            message.setSubject("Nuevo Producto ");
            message.setText("Se ha subido un nuevo producto","ISO-8859-1","html");
            
            InputStream htmlStream = getClass().getResourceAsStream("/correo/correohtml.html");
            
            // Crear el contenido HTML como un String
            String htmlContent = convertInputStreamToString(htmlStream);
            // Reemplazar los marcadores de posición con valores reales del producto
            htmlContent = htmlContent.replace("{PRODUCTO_NOMBRE}", producto.getTipo()+" "+producto.getMarca()+" "+producto.getModelo());
            htmlContent = htmlContent.replace("{PRODUCTO_STOCK}", Integer.toString(producto.getStock()));
            htmlContent = htmlContent.replace("{PRODUCTO_PRECIO}", Double.toString(producto.getPrecio()));
            
            // Creamos un cuerpo multipart para incluir texto HTML y la imagen
            MimeMultipart multipart = new MimeMultipart("related");
            //Es una de las partes del multipart
            MimeBodyPart htmlPart = new MimeBodyPart();
            //Se coloca el contenido del correo
            htmlPart.setContent(htmlContent,"text/html" );
            //se agrega al multipart
            multipart.addBodyPart(htmlPart);
            
            // Creamos la parte de la imagen
            MimeBodyPart imagePart = new MimeBodyPart();
            
            Image imagenProducto = producto.getImagen();
            InputStream imgStream = ImageUtils.convertImageToInputStream(imagenProducto, "png");
            
            //se crea un datahandler, que sirva para gstionar el contenido de la imagen, esta imagen debe de estar en bytes, luego se coloca en la imagen
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(imgStream, "image/png")));
            imagePart.setHeader("Content-ID", "<imagen123>"); // Coincide con el CID en el contenido HTML
            
            //se agrega otra parte al multipart
            multipart.addBodyPart(imagePart);
            
            // se Establece el contenido del mensaje
            message.setContent(multipart);

            
            //logica para enviar mensaje
            Transport mTransport = session.getTransport("smtp");
            mTransport.connect("pruebamonitor7@gmail.com", "togj fhkc imxh wldz");
            mTransport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    // Método para convertir InputStream a String
    public String convertInputStreamToString(InputStream inputStream) throws IOException {
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
                
    }
}
