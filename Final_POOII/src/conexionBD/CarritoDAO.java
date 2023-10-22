package conexionBD;

import clases.CarritoCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CarritoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<CarritoCompras> lista = new ArrayList<>();
        String query = "SELECT * FROM carritocompras";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                CarritoCompras c = new CarritoCompras();
                c.setIdCarrito(rs.getInt(1));
                c.setIdCliente(rs.getInt(2));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "INSERT INTO carritocompras(idCliente)values(?)";
        con = cn.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            
            result = ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM carritocompras WHERE idCarrito =?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Carrito eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    /*public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Clientes SET nombre=?, correo=?, contraseña=?, dni=? WHERE idCliente=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        return r;
    }*/
}
