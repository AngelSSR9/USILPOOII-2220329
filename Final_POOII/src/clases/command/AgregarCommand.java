/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import clases.Producto;
import conexionBD.ProductoDAO;
import gui.panels.FabricacionPanel;
import gui.panels.RegistroProductos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henry
 */
public class AgregarCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    RegistroProductos reg;

    public AgregarCommand(RegistroProductos fab) {
        this.reg = fab;
    }
    
    
    
    @Override
    public void execute() {
        agregarProducto();
    }
    
    public void agregarProducto(){
        boolean confirm = agregarProductoBD();
        if (confirm) {
            Constantes.limpiarComponentes(reg);
            Constantes.limpiarTabla(reg);
            Constantes.listarProductos(reg);
        }
    }
    
    private boolean agregarProductoBD() {
        Object[] o = new Object[4];
        String marca = reg.marcaTxt.getText();
        String modelo = reg.modeloTxt.getText();
        String precio = reg.precioTxt.getText();
        String stock = reg.stockTxt.getText();
        //String direccion = direccionTxt.getText();
        try {
           
            o[0] = marca;
            o[1] = modelo;
            o[2] = Double.parseDouble(precio);
            o[3] = Integer.parseInt(stock);

            productoDAO.agregar(o);

            return true;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            return false;
        }

    }
    
    
}
