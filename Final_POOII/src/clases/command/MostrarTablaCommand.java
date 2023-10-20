/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import conexionBD.ProductoDAO;
import gui.panels.RegistroProductos;
import javax.swing.JOptionPane;

/**
 *
 * @author henry
 */
public class MostrarTablaCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    RegistroProductos reg;

    public MostrarTablaCommand(RegistroProductos reg) {
        this.reg = reg;
    }
    
    @Override
    public void execute() {
        
        int fila = reg.tablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(reg, "Debe seleccionar una fila");
        } else {
            reg.id = Integer.parseInt(reg.tablaProductos.getValueAt(fila, 0).toString());
            String marca = reg.tablaProductos.getValueAt(fila, 1).toString();
            String modelo = reg.tablaProductos.getValueAt(fila, 2).toString();
            String precio = reg.tablaProductos.getValueAt(fila, 3).toString();
            String stock = reg.tablaProductos.getValueAt(fila, 4).toString();
            
            
            reg.idTxt.setText(String.valueOf(reg.id));
            reg.marcaTxt.setText(marca);
            reg.modeloTxt.setText(modelo);
            reg.precioTxt.setText(precio);
            reg.stockTxt.setText(stock);
        }
        
    }
    
    
    
}
