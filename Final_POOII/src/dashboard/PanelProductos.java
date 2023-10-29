package dashboard;

import clases.CarritoCompras;
import clases.Cliente;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.ProductoDAO;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JPanel;

public class PanelProductos extends javax.swing.JPanel {

    //Cliente cliente;
    ProductoDAO productoDAO = new ProductoDAO();
    CarritoDAO c = new CarritoDAO();
    CarritoCompras carrito;
    
    public PanelProductos(){
        this.carrito = c.obtenerCarritoPorIdCliente(1);
        initComponents();
        iniciar();
    }
    
    public PanelProductos(Cliente cliente) {
        initComponents();
        this.carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        iniciar();
    }

    private void iniciar() {
        scrollPanePrincipal.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 4);
        layout.setHgap(5);
        layout.setVgap(5);
        panelPrincipal.setLayout(layout);
    }

    public void establecerItems() throws IOException, SQLException {
        panelPrincipal.removeAll();
        List<Producto> productos = productoDAO.listar();
        
        for (Producto p : productos) {
            PanelItem panel = new PanelItem(p, carrito);
            panel.setInformacion();
            System.out.println(p.toString());
            panelPrincipal.add(panel);
        }

        // Agregamos paneles ficticios vacíos para completar una fila
        int totalPaneles = productos.size();
        int panelesFaltantes = 5 - totalPaneles;
        if (panelesFaltantes > 0) {
            for (int i = 0; i < panelesFaltantes; i++) {
                panelPrincipal.add(new JPanel());
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                System.out.println(i);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanePrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        scrollPanePrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        panelPrincipal.setLayout(new java.awt.GridLayout(1, 0));
        scrollPanePrincipal.setViewportView(panelPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(scrollPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
