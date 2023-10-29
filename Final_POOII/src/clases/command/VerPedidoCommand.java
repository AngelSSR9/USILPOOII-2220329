        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import conexionBD.ProductoDAO;
import gui.frames.FrameMostrarVentas;
import gui.panels.RegistroProductosPanel;
import gui.panels.VentasDelDiaPanel;

/**
 *
 * @author henry
 */
public class VerPedidoCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    VentasDelDiaPanel reg;

    public VerPedidoCommand(VentasDelDiaPanel reg) {
        this.reg = reg;
    }
    
    @Override
    public void execute() {
        ver();
    }
    
    public void ver(){
        int fila = reg.tablaPedidos.getSelectedRow();
        if(fila !=-1){
            int idPed = Integer.parseInt(reg.tablaPedidos.getValueAt(fila, 0).toString());
        }
        
        FrameMostrarVentas mostVen = new FrameMostrarVentas();
        mostVen.setVisible(true);
        
        
    }
    
    
    
}
