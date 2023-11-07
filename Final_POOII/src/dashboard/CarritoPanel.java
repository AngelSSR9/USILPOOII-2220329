package dashboard;

import clases.CarritoCompras;
import clases.Cliente;
import clases.DetalleCarrito;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.DetalleCarritoDAO;
import conexionBD.ProductoDAO;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarritoPanel extends javax.swing.JPanel {

    CarritoDAO c = new CarritoDAO();
    DetalleCarritoDAO d = new DetalleCarritoDAO();
    Cliente cliente;
    double total;

    public CarritoPanel(Cliente cliente) {
        initComponents();
        iniciar();
        this.cliente = cliente;
    }

    public void iniciar() {
        productosScrollPanel.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 1);
        layout.setHgap(5);
        layout.setVgap(5);
        panelProductos.setLayout(layout);
        panelProductos.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
    }

    public void establecerComponentes() {
        productosScrollPanel.getVerticalScrollBar().setValue(0);
        panelProductos.removeAll();

        CarritoCompras carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        List<DetalleCarrito> listaDetalles = d.obtenerDetallesPorId(carrito.getIdCarrito());
        if (listaDetalles.isEmpty()) {
            buttonProcesarCompra.setEnabled(false);
        } else {
            buttonProcesarCompra.setEnabled(true);
        }

        total = 0;
        for (DetalleCarrito detalle : listaDetalles) {
            ProductoDAO p = new ProductoDAO();
            Producto producto = p.obtenerProductoPorId(detalle.getIdProducto());
            total += producto.getPrecio() * detalle.getCantidad();
            ProductoCarritoPanel productoPanel = new ProductoCarritoPanel(producto, detalle.getCantidad(), carrito);
            productoPanel.lblEliminar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    d.eliminar(carrito.getIdCarrito(), producto.getId());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CarritoPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    establecerComponentes();
                }
            });
            
            productoPanel.spinnerCantidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Realizar acciones cuando se produce un cambio en el JSpinner
                //System.out.println(productoPanel.spinnerCantidad.getValue());
                if((int)productoPanel.spinnerCantidad.getValue() <= producto.getStock()){
                    d.actualizarCantidadProducto((int) productoPanel.spinnerCantidad.getValue(), carrito.getIdCarrito(), producto.getId());
                    calcularTotal();
                }
            }
        });
            //System.out.println(detalle.getCantidad());
            panelProductos.add(productoPanel);
            panelProductos.revalidate();
            panelProductos.repaint();
        }
        int cant = listaDetalles.size();
        if (cant == 1 || cant == 2) {
            while (cant < 3) {
                JPanel p = new JPanel();
                panelProductos.add(p);
                cant++;
            }
        }
        lblTotal.setText(String.valueOf(total));
    }

    public void calcularTotal() {
        CarritoCompras carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        List<DetalleCarrito> listaDetalles = d.obtenerDetallesPorId(carrito.getIdCarrito());
        if (listaDetalles.isEmpty()) {
            buttonProcesarCompra.setEnabled(false);
        } else {
            buttonProcesarCompra.setEnabled(true);
        }
        total = 0;
        for (DetalleCarrito detalle : listaDetalles) {
            
            ProductoDAO p = new ProductoDAO();
            Producto producto = p.obtenerProductoPorId(detalle.getIdProducto());
            total += producto.getPrecio() * detalle.getCantidad();
        }
        lblTotal.setText(String.valueOf(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productosScrollPanel = new javax.swing.JScrollPane();
        panelProductos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        buttonProcesarCompra = new javax.swing.JButton();

        productosScrollPanel.setBorder(null);

        panelProductos.setLayout(new java.awt.GridLayout(1, 0));
        productosScrollPanel.setViewportView(panelProductos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carro de compra");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Precio");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Producto");

        jLabel5.setText("Subtotal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Total");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        lblTotal.setText("total");

        buttonProcesarCompra.setText("Continuar");
        buttonProcesarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcesarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(buttonProcesarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(buttonProcesarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productosScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void buttonProcesarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcesarCompraActionPerformed

    }//GEN-LAST:event_buttonProcesarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonProcesarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JScrollPane productosScrollPanel;
    // End of variables declaration//GEN-END:variables
}
