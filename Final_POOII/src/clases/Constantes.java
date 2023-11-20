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

/**
 *
 * @author david
 */
public class Constantes {
    private static ProductoDAO productoDAO = new ProductoDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();

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

}
