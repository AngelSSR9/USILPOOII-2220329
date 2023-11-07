
package clases.command;
import clases.Cliente;
import clases.Producto;
import conexionBD.ClienteDAO;
import conexionBD.ProductoDAO;
import gui.panels.AgregarPc;
import gui.panels.RegistroProductosPanel;
import gui.panels.VentasDelDiaPanel;
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
    
    
    public static void agregarRetorno(AgregarPc aggPc){
    List<Producto> valoresEspecificos = productoDAO.obtenerProductosPorTipo("mouse");
    
    aggPc.cBoxMouse.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = aggPc.cBoxMouse.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < valoresEspecificos.size()) {
                String valorEspecifico = valoresEspecificos.get(selectedIndex).getTipo();
                System.out.println("Valor seleccionado: " + valorEspecifico);
            }
        }
    });
}
    
    public static void cargarComboBox(AgregarPc aggPc){
        
        List<Producto> listaMother =  productoDAO.obtenerProductosPorTipo("motherboard");
        for(Producto a : listaMother){
            aggPc.cBoMoBo.addItem(a.getTipo()+"marca "+a.getMarca());
        }
        List<Producto> listaRam =  productoDAO.obtenerProductosPorTipo("memoria ram");
        for(Producto a : listaRam){
            aggPc.cBoxMemRom.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        List<Producto> listaRom =  productoDAO.obtenerProductosPorTipo("memoria rom");
        for(Producto a : listaRom){
            aggPc.cBoxMemRom.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        List<Producto> listaMoBo =  productoDAO.obtenerProductosPorTipo("motherboard");
        for(Producto a : listaMoBo){
            aggPc.cBoMoBo.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        List<Producto> listaPro =  productoDAO.obtenerProductosPorTipo("procesador");
        for(Producto a : listaPro){
            aggPc.cBoxProce.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        List<Producto> listaRefr =  productoDAO.obtenerProductosPorTipo("refrigeracion");
        for(Producto a : listaRefr){
            aggPc.cBoxRefrig.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxRefrig.addItem("sin seleccionar");
        
        List<Producto> listaMouse =  productoDAO.obtenerProductosPorTipo("Mouse");
        for(Producto a : listaMouse){
            aggPc.cBoxMouse.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxMouse.addItem("sin seleccionar");
        
        List<Producto> listaTar =  productoDAO.obtenerProductosPorTipo("tarjeta grafica");
        for(Producto a : listaTar){
            aggPc.cBoxTarjGraf.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxTarjGraf.addItem("sin seleccionar");
        
        List<Producto> listaAud =  productoDAO.obtenerProductosPorTipo("audifonos");
        for(Producto a : listaAud){
            aggPc.cBoxAudif.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxAudif.addItem("sin seleccionar");
        
        List<Producto> listaTec =  productoDAO.obtenerProductosPorTipo("teclado");
        for(Producto a : listaTec){
            aggPc.cBoxTeclado.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxTeclado.addItem("sin seleccionar");
        
        List<Producto> listaMon =  productoDAO.obtenerProductosPorTipo("monitor");
        for(Producto a : listaMon){
            aggPc.cBoxMonitor.addItem(a.getTipo()+" marca "+a.getMarca());
        }
        aggPc.cBoxMonitor.addItem("sin seleccionar");
        
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
    
    public static void listarPedidos(VentasDelDiaPanel vnts){
        List<Producto> lista = productoDAO.listar();
        vnts.modelo = (DefaultTableModel) vnts.tablaPedidos.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getMarca();
            ob[2] = lista.get(i).getModelo();
            ob[3] = lista.get(i).getPrecio();

            vnts.modelo.addRow(ob);
        }
        
        vnts.tablaPedidos.setModel(vnts.modelo);
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
