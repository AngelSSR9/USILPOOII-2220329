
package clases.command;
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

public class Constantes {
        private static ProductoDAO productoDAO = new ProductoDAO();
        private static ClienteDAO clienteDAO = new ClienteDAO();
    
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
