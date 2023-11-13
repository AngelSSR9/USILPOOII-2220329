/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import clases.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author henry
 */
public class DetallesPcDAO {
    Connection con;
    Conexion cn = Conexion.obtenerInstancia();
    PreparedStatement ps;
    ResultSet rs;
    
    public int agregar(Object[] o) throws IOException {
        int result = 0;
        String query = "INSERT INTO detallespc(idPc,idProducto)values(?,?)";
        con = cn.obtenerConexion();
        try {
            ps = con.prepareStatement(query);
            
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
             JOptionPane.showMessageDialog(null, "Productos agregados correctamente.");
            result = ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            System.out.println(e);
        }
        
        
        return result;
    }
    
    public List<Producto> obtenerDetallesPorId(int idPc){
        String query = "SELECT * FROM detallespc WHERE idPc = ?";
        List<String> lst = new ArrayList<String>();
        ProductoDAO pDAO = new ProductoDAO();
            List<Producto> productos = new ArrayList<Producto>();
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(query);
            
            // Establece el valor del parámetro idPc
            ps.setInt(1, idPc);
            
            rs = ps.executeQuery();
            while(rs.next()){
                lst.add(rs.getString(2));
            }
            
            for(String id : lst){
                productos.add(pDAO.obtenerProductoPorId(Integer.parseInt(id)));
            }
            
        } catch (Exception e) {
            System.out.println("holaaaa");
            JOptionPane.showMessageDialog(null, "Error obteniendo p x id: " + e.toString());
            System.out.println(e);
        }
        
        return productos;
    }
    
    public void eliminarDetallesPc(int idPc){
        String sql = "DELETE FROM detallespc WHERE idPc =?";
        
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, idPc);
            ps.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar detalles: " + e.toString());
        }
    }
    
    
}
