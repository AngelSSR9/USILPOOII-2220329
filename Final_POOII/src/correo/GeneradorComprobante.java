package correo;

import clases.Cliente;
import clases.DetalleCarrito;
import clases.PC;
import clases.Producto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import conexionBD.DetallesPcDAO;
import conexionBD.PcDAO;
import conexionBD.ProductoDAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GeneradorComprobante {

    private Cliente cliente;
    private int idPedido;
    private DetallesPcDAO detallesPcDAO = new DetallesPcDAO();
    private ProductoDAO productoDAO = new ProductoDAO();
    private PcDAO pcDAO = new PcDAO();
    private List<DetalleCarrito> listaDetalles;

    public GeneradorComprobante(Cliente cliente, int pedido, List<DetalleCarrito> listaDetalles) {
        this.cliente = cliente;
        this.idPedido = pedido;
        this.listaDetalles = listaDetalles;
    }

    private void enviarPorCorreo(String archivoAdjunto, String destinatario) throws MessagingException {
        // Configuración para el servidor de correo (en este caso, Gmail)
        String remitente = "pruebamonitor7@gmail.com"; // Coloca tu dirección de correo
        String contraseña = "togj fhkc imxh wldz"; // Coloca tu contraseña
        String host = "smtp.gmail.com";
        int puerto = 587;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", puerto);

        // Crear sesión de correo
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });

        // Crear el mensaje
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Boleta Electrónica");

        // Adjuntar el archivo PDF
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new javax.activation.DataHandler(new javax.activation.FileDataSource(archivoAdjunto)));
        adjunto.setFileName("BoletaElectronica.pdf");

        // Crear el cuerpo del mensaje
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(adjunto);

        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
    }

    public String generarNumeroComprobante() {
        DecimalFormat formatoNumero = new DecimalFormat("000000");
        return formatoNumero.format(idPedido);
    }

    public String getFechaFormateada() {
        // Formatear la fecha según tus necesidades
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(new Date());
    }

    public void generarBoletaElectronicaConQR(){
        Document documento = new Document(PageSize.A6, 10, 10, 10, 10); // Tamaño A6 y márgenes reducidos

        try {
            String numeroComprobante = generarNumeroComprobante();
            String archivoPDF = "BoletaElectronica" + numeroComprobante + ".pdf";
            PdfWriter pdfWriter = PdfWriter.getInstance(documento, new FileOutputStream(archivoPDF));
            documento.open();

            Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Font fuenteNormal = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
            Font fuenteNumeroBoleta = FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);

            // Agregar contenido a la boleta electrónica
            agregarEncabezado(documento, fuenteTitulo);

            // Agregar número de comprobante con un tamaño de fuente diferente
            Paragraph numeroBoleta = new Paragraph("#" + generarNumeroComprobante() + "\n\n", fuenteNumeroBoleta);
            numeroBoleta.setAlignment(Element.ALIGN_CENTER);
            documento.add(numeroBoleta);
            documento.add(new LineSeparator());
            documento.add(new Chunk("\n"));

            // Crear un Paragraph para combinar la información del cliente y del comprobante
            Paragraph infoClienteComprobante = new Paragraph();
            infoClienteComprobante.add(new Chunk("Empresa Emisora: " + "TIENDA XDD" + "\n", fuenteNormal));
            infoClienteComprobante.add(new Chunk("Cliente: " + cliente.getNombre() + "                   ", fuenteNormal));
            infoClienteComprobante.add(new Chunk("DNI: " + cliente.getDni() + "\n", fuenteNormal));
            infoClienteComprobante.add(new Chunk("Fecha: " + getFechaFormateada() + "\n\n\n", fuenteNormal));
            //infoClienteComprobante.add(new Chunk("Número de Comprobante: " + comprobante.getNumeroComprobante(), fuenteNormal));

            documento.add(infoClienteComprobante);

            // Agregar contenido de los pedidos
            agregarDetalleCompra(documento, fuenteNormal, listaDetalles);

            documento.add(new Chunk("\n"));
            // Agregar código QR
            agregarQRCode(pdfWriter, documento);
            
            //Cerrar el documento
            documento.close();
            
            // Enviar el PDF por correo electrónico
            enviarPorCorreo(archivoPDF, cliente.getCorreo());

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(GeneradorComprobante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(GeneradorComprobante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    private static void agregarEncabezado(Document documento, Font fuenteTitulo) throws DocumentException {
        Paragraph titulo = new Paragraph("Boleta Electrónica\n", fuenteTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
    }

    private void agregarDetalleCompra(Document documento, Font fuenteNormal, List<DetalleCarrito> pedidos)
            throws DocumentException {
        PdfPTable tablaDetalle = new PdfPTable(4);
        tablaDetalle.setWidthPercentage(100);

        // Ajustar el ancho de la columna de nombre
        float[] columnWidths = {2f, 1f, 1f, 1f};
        tablaDetalle.setWidths(columnWidths);

        PdfPCell cellNombre = new PdfPCell(new Phrase("Nombre", fuenteNormal));
        cellNombre.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellNombre.setBorder(Rectangle.BOTTOM);
        tablaDetalle.addCell(cellNombre);

        PdfPCell cellCantidad = new PdfPCell(new Phrase("Cantidad", fuenteNormal));
        cellCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellCantidad.setBorder(Rectangle.BOTTOM);
        tablaDetalle.addCell(cellCantidad);

        PdfPCell cellPrecio = new PdfPCell(new Phrase("Precio", fuenteNormal));
        cellPrecio.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellPrecio.setBorder(Rectangle.BOTTOM);
        tablaDetalle.addCell(cellPrecio);

        PdfPCell cellTotal = new PdfPCell(new Phrase("Total", fuenteNormal));
        cellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTotal.setBorder(Rectangle.BOTTOM);
        tablaDetalle.addCell(cellTotal);

        for (DetalleCarrito detalle : pedidos) {
            if(detalle.getIdProducto() != 0){
                Producto producto = productoDAO.obtenerProductoPorId(detalle.getIdProducto());
                agregarFila(tablaDetalle, producto.getModelo(), String.valueOf(detalle.getCantidad()), "s/." + producto.getPrecio(), "s/." + String.valueOf(producto.getPrecio() * detalle.getCantidad()), fuenteNormal);
            }
            else{
                PC pc = pcDAO.obtenerPcPorId(detalle.getIdPC());
                pc.setPartes(detallesPcDAO.obtenerDetallesPorId(pc.getId()));
                double precio = pc.getPartes().stream().map(p -> p.getPrecio()).reduce(0.0, (a,b)->a+b);
                agregarFila(tablaDetalle, pc.getNombre(), String.valueOf(detalle.getCantidad()), "s/." + String.valueOf(precio), "s/." + String.valueOf(precio * detalle.getCantidad()), fuenteNormal);
            }
            
        }

        documento.add(tablaDetalle);
        documento.add(new Chunk("\n"));
    }

    private static void agregarFila(PdfPTable tabla, String nombre, String cantidad, String precio, String total, Font fuente) {
        PdfPCell cellNombre = new PdfPCell(new Phrase(nombre, fuente));
        cellNombre.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cellCantidad = new PdfPCell(new Phrase(cantidad, fuente));
        cellCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cellPrecio = new PdfPCell(new Phrase(precio, fuente));
        cellPrecio.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell cellTotal = new PdfPCell(new Phrase(total, fuente));
        cellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);

        tabla.addCell(cellNombre);
        tabla.addCell(cellCantidad);
        tabla.addCell(cellPrecio);
        tabla.addCell(cellTotal);
    }

    private static void agregarQRCode(PdfWriter pdfWriter, Document documento)
            throws IOException, DocumentException {
        String rutaImagenQR = "src/img/qr.png";
        Image image = Image.getInstance(rutaImagenQR);
        image.scaleAbsolute(80, 80);
        image.setAbsolutePosition(110, 20);  // Ajustar la posición de la imagen hacia abajo
        PdfContentByte contentByte = pdfWriter.getDirectContent();
        contentByte.addImage(image);
    }
}
