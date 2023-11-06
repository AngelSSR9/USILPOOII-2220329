package clases;


import clases.observer.Observer;
import clases.observer.Subject;
import clases.observer.TiendaSubject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
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
import javax.swing.JOptionPane;


public class Cliente extends Persona implements Observer{
    private CarritoCompras carritoCompras;
    private ArrayList<Pedido> pedidos;
    private String nombre;
    private int id;
    private String correo;
    private String contraseña;

    public Cliente(String nombre, int dni,String correo, String contraseña) {
        super(nombre, dni);
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Cliente(){}


    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void actualizar() {
        enviarMensaje();
    }
    public void enviarMensaje(){
        /*
        //String verificationToken = UUID.randomUUID().toString();
        //Se crea la clase propiedades para luego configurarlo
        Properties properties = new Properties();
        
        // Configuración del servidor de correo
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        // Autenticación
        */
        /*
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pruebamonitor7@gmail.com", "togj fhkc imxh wldz");
            }
        };
        */
        /*
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
            
            // Crear el contenido HTML como un String
            String htmlContent = "<html><body>";
            htmlContent += "<p>Se ha subido un nuevo producto</p>";
            htmlContent += "<img src='cid:imagen123'>"; // La imagen se referencia por CID
            htmlContent += "</body></html>";
            
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
            
            // Carga la imagen desde el paquete "img"
            InputStream imgStream = getClass().getResourceAsStream("/img/imgNewProduct.png");
            
            //Convertir a bytes la imagen
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = imgStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            
            //se crea un datahandler, que sirva para gstionar el contenido de la imagen, esta imagen debe de estar en bytes, luego se coloca en la imagen
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(imageBytes, "image/png")));
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
*/
        
    }

    
    
    
}
