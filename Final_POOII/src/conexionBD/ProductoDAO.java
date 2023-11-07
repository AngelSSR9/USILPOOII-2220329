package conexionBD;

import clases.Producto;
import conexionBD.Conexion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class ProductoDAO  {
   
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String query = "SELECT * FROM Productos";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                byte[] imageData = rs.getBytes(8);
                if (imageData != null) {
                    p.setImagen(ImageIO.read(new ByteArrayInputStream(imageData)));
                } else {
                    // Asignar una imagen en blanco o realizar alguna otra acción adecuada para manejar imágenes nulas.
                    // Por ejemplo, podrías asignar una imagen por defecto.
                    p.setImagen(null);
                }


                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) throws IOException {
        int result = 0;
        String sql = "INSERT INTO Productos(marca,modelo,precio,stock, categoría, tipo, imagen)values(?,?,?,?,?,?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            
            //Convertir la imagen a un arreglo de bytes para ser alamcenada en la bd
            File imagenFile = new File((String) o[6]);
            byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());

            ps.setBlob(7, new SerialBlob(imagenBytes));
            result = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM Productos WHERE idProducto =?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Productos SET marca=?,modelo=?,precio=?,stock=?,categoría=?,tipo=?,imagen=? WHERE idProducto=?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            if(o[6].equals("")){
                Producto p = obtenerProductoPorId((int)o[7]);
                BufferedImage bufferedImage = new BufferedImage(p.getImagen().getWidth(null), p.getImagen().getHeight(null), BufferedImage.TYPE_INT_ARGB);
                bufferedImage.getGraphics().drawImage(p.getImagen(), 0, 0, null);
                System.out.println("a");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", outputStream);
                byte[] imagenBytes = outputStream.toByteArray();
                ps.setBlob(7, new SerialBlob(imagenBytes));
            }else{
                System.out.println("ab");
                File imagenFile = new File((String) o[6]);
                byte[] imagenBytes = Files.readAllBytes(imagenFile.toPath());
                ps.setBlob(7, new SerialBlob(imagenBytes));
            }
            
            ps.setObject(8, o[7]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            System.out.println(e.toString());
        }
        return r;   
    }
    
    public int actualizarStock(int idProducto, int stock){
        int r = 0;
        String sql = "UPDATE productos SET stock=? WHERE idProducto=?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setObject(1, stock);
            ps.setObject(2, idProducto);
            r = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Stock actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }
    
    public List<Producto> obtenerProductosPorTipo(String tipo){
        String query = "SELECT * FROM Productos WHERE tipo = ?";
        List<Producto> list = new ArrayList<Producto>();
         Producto p = null;
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(rs.getBytes(8))));
                
                list.add(p);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        return list;
    }
    
    public Producto obtenerProductoPorId(int id){
        String query = "SELECT * FROM Productos WHERE idProducto = ?";
        Producto p = null;
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt(1));
                p.setMarca(rs.getString(2));
                p.setModelo(rs.getString(3));
                p.setPrecio(rs.getDouble(4));
                p.setStock(rs.getInt(5));
                p.setCategoria(rs.getString(6));
                p.setTipo(rs.getString(7));
                p.setImagen(ImageIO.read(new ByteArrayInputStream(rs.getBytes(8))));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo p x id: " + e.toString());
        }

        return p;
    }
    
}
