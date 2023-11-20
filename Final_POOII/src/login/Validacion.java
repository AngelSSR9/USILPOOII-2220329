
package login;

import clases.Cliente;
import conexionBD.ClienteDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase interna para manejar la validación de los datos de registro.
*/
public class Validacion {
    
    
    /**
     * Valida los campos de registro y muestra mensajes de error si es necesario.
     * @param usuario El nombre de usuario.
     * @param correo La dirección de correo electrónico.
     * @param contraseña La contraseña.
     * @param dni El número de identificación.
     * @return true si la validación es exitosa, false en caso contrario.
    */
    public boolean validarRegistro(String usuario, String correo, String contraseña, String dni){
        // Validación de campos
        if ((usuario.trim().isEmpty()||usuario.trim().equals("Ingrese su usuario")) || (correo.trim().isEmpty()||correo.trim().equals("Ingrese su correo")) || (contraseña.trim().isEmpty()||contraseña.trim().equals("********"))  || (dni.trim().isEmpty()||dni.trim().equals("Ingrese su dni")) ) {
            Verificador.mostrarMensajeError("Por favor, complete todos los campos.");
            return false;
        }

        // Validación de formato
        if (!Verificador.esUsuarioValido(usuario)) {
            Verificador.mostrarMensajeError("El usuario no es válido.");
            return false;
        }

        if (!Verificador.esCorreoValido(correo)) {
            Verificador.mostrarMensajeError("Por favor, ingrese una dirección de correo electrónico válida.");
            return false;
        }

        if (!Verificador.esContraseñaValida(contraseña)) {
            Verificador.mostrarMensajeError("La contraseña debe tener 8 digitos, una mayúscula, una mínuscula y un número.");
            return false;
        }

        if (!Verificador.esDNIValido(dni)) {
            Verificador.mostrarMensajeError("El DNI debe tener 8 dígitos.");
            return false;
        }
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        List<Cliente> clientes = clienteDAO.listar();
        for(Cliente cliente : clientes){
            if(correo.equals(cliente.getCorreo())){
                JOptionPane.showMessageDialog(null, "Este correo ya esta registrado");
                return false;
            }
            if(dni.equals(String.valueOf(cliente.getDni()))){
                JOptionPane.showMessageDialog(null, "Este dni ya esta registrado");
                return false;
            }
        }
        // Si llega hasta aquí, la validación fue exitosa
        return true;
    }
    
    public boolean validarIngreso(String dni, String password){
        if ((dni.trim().equals("Ingrese su dni") || dni.trim().isEmpty()) ||  (password.trim().isEmpty()||password.trim().equals("********"))) {
            Verificador.mostrarMensajeError("Por favor, complete todos los campos.");
            return false;
        }
        if (!Verificador.esContraseñaValida(password)) {
            Verificador.mostrarMensajeError("La contraseña debe tener 8 digitos, una mayúscula, una mínuscula y un número.");
            return false;
        }

        if (!Verificador.esDNIValido(dni)) {
            Verificador.mostrarMensajeError("El DNI debe tener 8 dígitos.");
            return false;
        }
        return true;
    }
        
}
