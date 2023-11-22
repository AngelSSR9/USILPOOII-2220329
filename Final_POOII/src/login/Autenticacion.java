
package login;

import clases.CarritoCompras;
import clases.Cliente;
import conexionBD.CarritoDAO;
import conexionBD.ClienteDAO;
import javax.swing.JOptionPane;


/**
 * La clase Autenticacion se encarga de autenticar a un cliente utilizando el DNI y la contraseña.
 * Si las credenciales son válidas, se realiza la autenticación y se crea un carrito de compras
 * para el cliente si aún no tiene uno.
 */
public class Autenticacion {
    
    /**
     * Autentica a un cliente utilizando el DNI y la contraseña proporcionados.
     *
     * @param dni       El número de identificación del cliente.
     * @param password  La contraseña del cliente.
     * @param cliente   El objeto Cliente que se va a autenticar.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    public boolean autenticarCliente(int dni, String password, Cliente cliente) {
        // Devuelve true si las credenciales son válidas y false en caso contrario.
        if(cliente!=null){
            if (cliente.getContraseña().equals(password)) {   
                CarritoDAO carritoDAO = new CarritoDAO();
                CarritoCompras carrito = carritoDAO.obtenerCarritoPorIdCliente(cliente.getId());
                if(carrito == null){
                    //Asignar carrito a cliente
                    carritoDAO.agregar(cliente.getId());
                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Comtraseña Incorrecta. Por favor, inténtelo de nuevo.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Cuenta inexistente. Por favor, inténtelo de nuevo.");
        }
        return false;
    }
}
