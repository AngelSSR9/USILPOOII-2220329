/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import clases.Producto;
import conexionBD.ProductoDAO;
import gui.panels.RegistroProductosPanel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henry
 */
public class EliminarProductoCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    RegistroProductosPanel reg;

    public EliminarProductoCommand(RegistroProductosPanel reg) {
        this.reg = reg;
    }
    
    
    @Override
    public void execute() {
        int fila = reg.tablaProductos.getSelectedRow();
        int ids = Integer.parseInt(reg.tablaProductos.getValueAt(fila, 0).toString());
        if (fila == -1) {
            JOptionPane.showMessageDialog(reg, "Debe seleccionar una fila");
        } else {
            productoDAO.eliminar(ids);
        }
        Constantes.limpiarComponentes(reg);
            Constantes.limpiarTabla(reg);
            Constantes.listarProductos(reg);
    }
    
    
}
