/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.command;

import clases.Cliente;
import clases.Producto;
import clases.observer.TiendaSubject;
import conexionBD.ClienteDAO;
import conexionBD.ProductoDAO;
import gui.panels.MenuAdminPanel;
import gui.panels.AgregarProductoPanel;
import gui.panels.RegistroProductosPanel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henry
 */
public class AgregarCommand implements Command{
    ProductoDAO productoDAO = new ProductoDAO();
    AgregarProductoPanel reg;

    public AgregarCommand(AgregarProductoPanel fab) {
        this.reg = fab;
    }
    
    
    
    @Override
    public void execute() {
        agregarProducto();
    }
    
    public void agregarProducto(){
        boolean confirm = agregarProductoBD();
        if (confirm) {
            Constantes.limpiarPanel(reg.updatePanel);
            // Obtener la lista de clientes, añadir y notificarlos OBserver
            ClienteDAO clienteDAO = new ClienteDAO();
            TiendaSubject tienda = TiendaSubject.getInstancia();
            List<Cliente> clientes = clienteDAO.listar();
            for (Cliente cliente : clientes) {
                tienda.añadir(cliente);
            }
            JOptionPane.showMessageDialog(null, "Espere a que los correos se envien");
            tienda.notificar();
            System.out.println("Mensajes Enviados");
            JOptionPane.showMessageDialog(null, "Mesajes enviados");
        }
    }
    
    private boolean agregarProductoBD() {
        Object[] o = new Object[7];
        String marca = reg.marcaTxt.getText();
        String modelo = reg.modeloTxt.getText();
        String precio = reg.precioTxt.getText();
        String stock = reg.stockTxt.getText();
        String categoria = (String)reg.catCombo.getSelectedItem();
        String tipo = reg.tipoTxt.getText();
        String rutaImagen = reg.imagenTxt.getText();
        
        
        //String direccion = direccionTxt.getText();
        try {
           
            o[0] = marca;
            o[1] = modelo;
            o[2] = Double.parseDouble(precio);
            o[3] = Integer.parseInt(stock);
            o[4] = categoria;
            o[5] = tipo;
            o[6] = rutaImagen;

            productoDAO.agregar(o);

            return true;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            return false;
        }
    }
    
    
}
