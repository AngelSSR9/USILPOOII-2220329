
package clases.command;
import clases.Producto;
import conexionBD.ProductoDAO;
import gui.panels.RegistroProductos;
import gui.panels.VentasDelDiaPanel;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Constantes {
        private static ProductoDAO productoDAO = new ProductoDAO();
    
    public static void limpiarComponentes(RegistroProductos reg) {
        reg.marcaTxt.setText("");
        reg.modeloTxt.setText("");
        reg.idTxt.setText("");
        reg.precioTxt.setText("");
        reg.stockTxt.setText("");
    }
    
    public static void limpiarTabla(RegistroProductos reg) {
        for (int i = 0; i < reg.modelo.getRowCount(); i++) {
            reg.modelo.removeRow(i);
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
    
    public static void listarProductos(RegistroProductos reg) {
        List<Producto> lista = productoDAO.listar();
        reg.modelo = (DefaultTableModel) reg.tablaProductos.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getMarca();
            ob[2] = lista.get(i).getModelo();
            ob[3] = lista.get(i).getPrecio();
            ob[4] = lista.get(i).getStock();

            reg.modelo.addRow(ob);
        }
        
        reg.tablaProductos.setModel(reg.modelo);
    }
    
    
}
