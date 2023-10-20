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
public class ActualizarCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    RegistroProductos reg;

    public ActualizarCommand(RegistroProductos reg) {
        this.reg = reg;
    }
    
    
    @Override
    public void execute() {
        int fila = reg.tablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(reg, "Debe seleccionar una fila");

        } else {
            String DNI = reg.idTxt.getText();
            String nombre = reg.marcaTxt.getText();
            String telefono = reg.precioTxt.getText();
            //String direccion = direccionTxt.getText();
            Object[] obj = new Object[5];
            obj[0] = DNI;
            obj[1] = nombre;
            obj[2] = telefono;
            //obj[3] = direccion;
            obj[4] = reg.id;

            //productoDAO.actualizar(obj);
        }
    }
    
    
}
