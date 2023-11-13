package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static Conexion instancia = null;
    private Connection conexion;

    String url = "jdbc:mysql://localhost:3306/poo2";
    String user = "root";
    String password = "2220425929070";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    public static Conexion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
            System.out.println("Nueva conexion");
        }
        return instancia;
    }   

    public Connection obtenerConexion() {
        return conexion;
    }

}
