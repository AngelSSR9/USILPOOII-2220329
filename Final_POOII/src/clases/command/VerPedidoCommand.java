/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import conexionBD.ProductoDAO;
import gui.panels.RegistroProductos;

/**
 *
 * @author henry
 */
public class VerPedidoCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    RegistroProductos reg;

    public VerPedidoCommand(RegistroProductos reg) {
        this.reg = reg;
    }
    
    @Override
    public void execute() {
        
    }
    
    public void ver(){
        int fila = reg.tablaProductos.getSelectedRow();
        int idPed = Integer.parseInt(reg.tablaProductos.getValueAt(fila, 0).toString());
        
        
    }
    
    
    
}
