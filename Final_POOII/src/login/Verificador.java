
package login;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;

/**
 * La clase Verificador proporciona métodos para validar diferentes tipos de datos,
 * como usuario, correo electrónico, contraseña y número de identificación (DNI).
 */
public class Verificador {
    /**
     * Expresiones regular para validar los datos de usuario.
    */
    private static String regexUsuario = "^[a-zA-Z0-9]+(?:[ _-][a-zA-Z0-9]+)*$";
    private static String regexCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static String regexContraseña = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
    private static String regexDNI = "^[0-9]{8}$";

    /**
     * Verifica si el nombre de usuario cumple con el formato establecido.
     * @param usuario El nombre de usuario a validar.
     * @return true si el nombre de usuario es válido, false en caso contrario.
     */
    public static boolean esUsuarioValido(String usuario) {
        return usuario.matches(regexUsuario);
    }

    /**
     * Verifica si la dirección de correo electrónico cumple con el formato establecido.
     * @param correo La dirección de correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean esCorreoValido(String correo) {
        return correo.matches(regexCorreo);
    }

    /**
     * Verifica si la contraseña cumple con el formato establecido.
     * La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número.
     * @param contraseña La contraseña a validar.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    public static boolean esContraseñaValida(String contraseña) {
        return contraseña.matches(regexContraseña);
    }

    /**
     * Verifica si el número de identificación (DNI) cumple con el formato establecido.
     * El DNI debe tener exactamente 8 dígitos.
     * @param dni El número de identificación a validar.
     * @return true si el DNI es válido, false en caso contrario.
     */
    public static boolean esDNIValido(String dni) {
        return dni.matches(regexDNI);
    }
    
    /**
     * Muestra un mensaje de error en una ventana de diálogo.
     * @param mensaje El mensaje de error a mostrar.
     */
    public static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
