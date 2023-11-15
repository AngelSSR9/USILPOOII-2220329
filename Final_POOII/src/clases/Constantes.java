package clases;


import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import clases.Cliente;
import clases.Producto;
import conexionBD.ClienteDAO;
import conexionBD.ProductoDAO;
import gui.panels.AgregarPc;
import gui.panels.RegistroProductosPanel;
import gui.panels.VerPedidosPanel;
import gui.panels.VerClientesPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Constantes {
    private static ProductoDAO productoDAO = new ProductoDAO();
        private static ClienteDAO clienteDAO = new ClienteDAO();
    
    
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


        public static void limpiarComponentes(RegistroProductosPanel reg) {
        reg.marcaTxt.setText("");
        reg.modeloTxt.setText("");
        reg.idTxt.setText("");
        reg.precioTxt.setText("");
        reg.stockTxt.setText("");
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
            }
        }
    }
    
    public static void limpiarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    
    public static void listarClientes(VerClientesPanel vnts){
        List<Cliente> lista = clienteDAO.listar();
        System.out.println(lista.size());
        vnts.modelo = (DefaultTableModel) vnts.tablaClientes.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getCorreo();
            ob[3] = lista.get(i).getDni();

            vnts.modelo.addRow(ob);
        }
        
        vnts.tablaClientes.setModel(vnts.modelo);
    }
}
