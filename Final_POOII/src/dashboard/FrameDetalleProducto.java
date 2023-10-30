package dashboard;

import clases.CarritoCompras;
import clases.Producto;
import conexionBD.DetalleCarritoDAO;
import conexionBD.ProductoDAO;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrameDetalleProducto extends javax.swing.JFrame {

    Producto producto;
    CarritoCompras carrito;
    
    public FrameDetalleProducto(Producto producto, CarritoCompras carrito) {
        initComponents();
        setLocationRelativeTo(null);
        this.producto = producto;
        this.carrito = carrito;        
        configurarComponentes();
    }
    
    private void configurarComponentes(){
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Agrega el JLabel al JPanel usando GridBagConstraints
        panelCantidad.add(lblCantidad, gbc);
        panelSuma.add(jLabel8, gbc);
        panelResta.add(jLabel6, gbc);
        
        lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(346,
            316, Image.SCALE_SMOOTH)));
        lblMarca.setText(producto.getMarca());
        lblStock.setText(String.valueOf(producto.getStock()));
        lblNombre.setText(producto.getMarca() + " " + producto.getModelo());
        lblPrecio.setText(String.valueOf(producto.getPrecio()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblImagen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JPanel();
        panelResta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelCantidad = new javax.swing.JPanel();
        lblCantidad = new javax.swing.JLabel();
        panelSuma = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        addToCart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImagen.setText("jLabel1");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombre.setText("jLabel2");

        lblMarca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMarca.setText("jLabel1");

        lblPrecio.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Stock:");

        lblStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStock.setText("jLabel3");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        panelContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelResta.setBackground(new java.awt.Color(0, 153, 153));
        panelResta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelResta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRestaMouseClicked(evt);
            }
        });
        panelResta.setLayout(new java.awt.GridBagLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resta.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 15, 13);
        panelResta.add(jLabel6, gridBagConstraints);

        panelContenedor.add(panelResta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 50));

        panelCantidad.setBackground(new java.awt.Color(0, 204, 204));
        panelCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCantidad.setLayout(new java.awt.GridBagLayout());

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCantidad.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 5, 2);
        panelCantidad.add(lblCantidad, gridBagConstraints);

        panelContenedor.add(panelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 50));

        panelSuma.setBackground(new java.awt.Color(0, 153, 153));
        panelSuma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelSuma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSumaMouseClicked(evt);
            }
        });
        panelSuma.setLayout(new java.awt.GridBagLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suma.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 15, 13);
        panelSuma.add(jLabel8, gridBagConstraints);

        panelContenedor.add(panelSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 50));

        addToCart.setBackground(new java.awt.Color(0, 153, 153));
        addToCart.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        addToCart.setForeground(new java.awt.Color(255, 255, 255));
        addToCart.setText("Add to cart");
        addToCart.setBorder(null);
        addToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(48, 48, 48)
                        .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMarca)
                                .addGap(49, 49, 49)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lblStock))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelSumaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSumaMouseClicked
        int cantidad = Integer.parseInt(lblCantidad.getText());
        cantidad++;
        lblCantidad.setText(String.valueOf(cantidad));
    }//GEN-LAST:event_panelSumaMouseClicked

    private void panelRestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRestaMouseClicked
        int cantidad = Integer.parseInt(lblCantidad.getText());
        if (cantidad > 1) {
            cantidad--;
            lblCantidad.setText(String.valueOf(cantidad));
        }
    }//GEN-LAST:event_panelRestaMouseClicked

    private void addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartActionPerformed
        int stock = Integer.parseInt(this.lblStock.getText());
        int cantidad = Integer.parseInt(this.lblCantidad.getText());
        
        if(stock < cantidad){
            JOptionPane.showMessageDialog(null, "Not enough product in Stock!");
        }
        else{
            //DetalleCarrito d = new DetalleCarrito(carrito.getIdCarrito(), producto.getId(), cantidad);
            Object o[] = new Object[3];
            o[0] = carrito.getIdCarrito();
            o[1] = producto.getId();
            o[2] = cantidad;
            DetalleCarritoDAO d =  new DetalleCarritoDAO();
            d.agregar(o);

            int stockActualizado = stock - cantidad ;
            
            producto.setStock(stockActualizado);
            lblStock.setText(String.valueOf(stockActualizado));
            
            ProductoDAO p = new ProductoDAO();
            p.actualizarStock(producto.getId(), stockActualizado);
            
            JOptionPane.showMessageDialog(null, "Product added to cart!");
        }
    }//GEN-LAST:event_addToCartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDetalleProducto(new Producto(), new CarritoCompras()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelResta;
    private javax.swing.JPanel panelSuma;
    // End of variables declaration//GEN-END:variables
}
