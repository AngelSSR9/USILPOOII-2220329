package clases;


import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Constantes {
    
    static final String MENU = "-----------BIENVENIDO------------\n"
            + "[1] Ingresar como empleado.\n"
            + "[2] Ingresar como gerente.\n"
            + "[3] Salir del sistema.\n";
    static final String MENU_EMPLEADO_LOGGIN = "---------------------------\n"
            + "[1] Iniciar Sesion(DNI).\n"
            + "[2] Registrarse.\n"
            + "[3] Salir.\n"
            + "------------------------------\n";

    static final String MENU_EMPLEADO = "------------MENU--------------\n"
            + "[1] Registrar nuevo producto.\n"
            + "[2] Registrar una nueva venta.\n"
            + "[3] Realizar una nueva fabricacion.\n"
            + "[4] Salir.\n";
    static final String MENU_GERENTE = "----------------MENU----------------\n"
            + "[1] Agregar un producto nuevo\n"
            + "[2] Eliminar un producto registrado.\n"
            + "[3] Eliminar un empleado registrado.\n"
            + "[4] Mostrar los empleados registrados.\n"
            + "[5] Mostrar los productos registrados y el stock disponible.\n"
            + "[6] Mostrar las ventas del dia.\n"
            + "[7] SALIR\n";

    public static final boolean esNumeroInt(String text) {
        try {
            Integer integer = Integer.valueOf(text);
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor valido.");
            return false;
        }
    }

    public static final boolean esNumeroInt(JTextField texto, String mensajeError) {
        try {
            Integer integer = Integer.valueOf(texto.getText());
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, mensajeError);
            return false;
        }
    }
    
    public static final boolean esNumeroFloat(String texto){
        try {
            Float f  = Float.valueOf(texto);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static final boolean esDniValido(JTextField texto) {
        try {
            Integer integer = Integer.valueOf(texto.getText());
            //SIRVE PARA VERIFICAR SI EL DNI TIENE 8 CIFRAS 
            /*String cifras = integer.toString();
            if(cifras.length() != 8){
                return false;
            }
            else{
                return true;
            }*/
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static final boolean esTelefonoValido(JTextField numero) {
        try {
            Integer integer = Integer.valueOf(numero.getText());
            //SIRVE PARA VERIFICAR SI EL NUMERO TIENE 9 CIFRAS 
            /*String cifras = integer.toString();
            if(cifras.length() != 8){
                return false;   
            }
            else{
                return true;
            }*/
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static final String generateDots(int length) {
        StringBuilder dots = new StringBuilder();
        for (int i = 0; i < length; i++) {
            dots.append(" ");
        }
        return dots.toString();
    }

    public static final void limpiarPanel(Container container) {
    for (Component component : container.getComponents()) {
        if (component instanceof JTextField) {
            JTextField textField = (JTextField) component;
            textField.setText("");  // Vaciar el contenido del JTextField
        } else if (component instanceof JComboBox) {
            JComboBox comboBox = (JComboBox) component;
            comboBox.setSelectedIndex(0);  // Establecer el índice seleccionado a 0 (primer elemento)
        } else if (component instanceof JCheckBox) {
            JCheckBox checkBox = (JCheckBox) component;
            checkBox.setSelected(false);  // Desmarcar el JCheckBox
        } else if (component instanceof Container) {
            limpiarPanel((Container) component);  // Llamar recursivamente a limpiarPanel para subpaneles
        }
        // Agrega cualquier otra lógica específica para otros tipos de componentes que desees restablecer
    }
}
}
