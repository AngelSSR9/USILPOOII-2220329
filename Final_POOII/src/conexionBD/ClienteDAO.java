package conexionBD;

import clases.Cliente;
import conexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO  {
   
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                //c.setDireccion(rs.getString(5));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

        return lista;
    }

    public int agregar(Object[] o) {
        int result = 0;
        String sql = "INSERT INTO Clientes(DNI,nombre,telefono,direccion)values(?,?,?,?)";
        con = cn.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            result = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }

        return result;
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM Clientes WHERE id =?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }

    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE Clientes SET DNI=?, nombre=?, telefono=?, direccion=? WHERE idCliente=?";
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
    }

    public Cliente obtenerClientePorDNI(int dni) {
        String query = "SELECT * FROM Clientes WHERE DNI =" + dni;
        Cliente c = null;
        try {
            con = cn.conectar();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setTelefono(rs.getInt(4));
                //c.setDireccion(rs.getString(5));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
        
        return c;
    }

}
