package dashboard;

import clases.CarritoCompras;
import clases.DetalleCarrito;
import clases.PC;
import clases.Producto;
import conexionBD.DetalleCarritoDAO;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrameDetalleProducto extends javax.swing.JFrame {

    PC pc;
    Producto producto;
    CarritoCompras carrito;
    DetalleCarritoDAO detalleCarritoDAO = new DetalleCarritoDAO();

    public FrameDetalleProducto(Producto producto, CarritoCompras carrito) {
        initComponents();
        setLocationRelativeTo(null);
        this.producto = producto;
        this.carrito = carrito;
        configurarComponentes();
        establecerInformacion();
    }

    public FrameDetalleProducto(PC pc, CarritoCompras carrito) {
        initComponents();
        setLocationRelativeTo(null);
        this.pc = pc;
        this.carrito = carrito;
        configurarComponentes();
        establecerInformacion();
    }

    private void configurarComponentes() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Agrega el JLabel al JPanel usando GridBagConstraints
        panelCantidad.add(lblCantidad, gbc);
        panelSuma.add(jLabel8, gbc);
        panelResta.add(jLabel6, gbc);

    }

    private void establecerInformacion() {
        if (producto != null) {
            lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(346,
                    316, Image.SCALE_SMOOTH)));
            lblMarca.setText(producto.getMarca());
            lblStock.setText(String.valueOf(producto.getStock()));
            lblNombre.setText(producto.getMarca() + " " + producto.getModelo());
            lblPrecio.setText("s/." + String.valueOf(producto.getPrecio()));
            lblDescripcion.setText(convertirHtml(producto.getDescripcion()));
        } else {
            lblImagen.setIcon(new ImageIcon(pc.getImagen().getScaledInstance(346,
                    316, Image.SCALE_SMOOTH)));
            lblDescripcion.setText(convertirHtml(pc.getPartes().stream()
                .map(producto -> producto.getTipo() + " " + producto.getMarca() + " " + producto.getModelo()+"\n")
                .collect(Collectors.joining("-"))));
            lblMarca.setText("");
            lblNombre.setText(pc.getNombre());
            lblStock.setText(String.valueOf(pc.getStock()));
            lblPrecio.setText("s/." + String.valueOf(pc.getPartes().stream()
                    .map(p -> p.getPrecio())
                    .reduce(0.0, (a, b) -> a + b)));
        }

    }

    public static String convertirHtml(String input) {
        StringBuilder htmlBuilder = new StringBuilder("<html>");

        // Reemplaza los saltos de línea por la etiqueta <br>
        String[] lines = input.split("\\n");
        for (String line : lines) {
            htmlBuilder.append(line).append("<br>");
        }

        // Elimina la última etiqueta <br>
        htmlBuilder.delete(htmlBuilder.length() - "<br>".length(), htmlBuilder.length());

        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
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
        jLabel1 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImagen.setText("jLabel1");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNombre.setText("jLabel2");

        lblMarca.setText("jLabel1");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Stock:");

        lblStock.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblStock.setText("jLabel3");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        panelContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelResta.setBackground(new java.awt.Color(0, 153, 153));
        panelResta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelResta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        panelSuma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        addToCart.setText("Agregar carrito");
        addToCart.setBorder(null);
        addToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Precio:");

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblDescripcion.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37)
                        .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(lblStock))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
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
        
        

        if (stock < cantidad) {
            JOptionPane.showMessageDialog(null, "No hay suficiente stock!");
        } else {
            List<DetalleCarrito> detalleCarritos = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());
            if(producto != null){
                List<DetalleCarrito> detallesProductos = detalleCarritos.stream().filter(d -> d.getIdProducto() != 0).toList();
                for(DetalleCarrito detalle : detallesProductos){
                    if(detalle.getIdProducto() == producto.getId()){
                        detalleCarritoDAO.actualizarCantidadProducto(detalle.getCantidad()+cantidad, carrito.getIdCarrito(), producto.getId(), 1);
                        JOptionPane.showMessageDialog(null, "Producto agregado al carrito!");
                        return;
                    }
                }
            }
            else{
                List<DetalleCarrito> detallesPcs = detalleCarritos.stream().filter(d -> d.getIdPC() != 0).toList();
                for(DetalleCarrito detalle : detallesPcs){
                    if(detalle.getIdProducto() == producto.getId()){
                        detalleCarritoDAO.actualizarCantidadProducto(detalle.getCantidad()+cantidad, carrito.getIdCarrito(), pc.getId(), 0);
                        JOptionPane.showMessageDialog(null, "Pc agregada al carrito!");
                        return;
                    }
                }
            }

            Object o[] = new Object[4];
            if (producto != null) {
                o[0] = carrito.getIdCarrito();
                o[1] = producto.getId();
                o[2] = cantidad;
                o[3] = 1;
                detalleCarritoDAO.agregar(o);
                JOptionPane.showMessageDialog(null, "Producto añadido al carrito!");
            }
            else if(pc!=null){
                o[0] = carrito.getIdCarrito();
                o[1] = pc.getId();
                o[2] = cantidad;
                o[3] = 0;
                detalleCarritoDAO.agregar(o);
                JOptionPane.showMessageDialog(null, "Pc añadida al carrito!");
            }

            
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripcion;
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
