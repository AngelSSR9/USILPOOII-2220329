package dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.Cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import conexionBD.CarritoDAO;


public class MenuCliente extends javax.swing.JFrame {
    CarritoDAO c = new CarritoDAO();
    PanelProcesarCompra panelProcesarCompra;
    CarritoPanel carritoPanel;
    PanelProductos productosPanel;
    PanelArmarPcCliente panelArmarPc;
    PanelHistorialPedidos panelHistorialPedidos;
    OptionsClient optionsClient;
    Cliente cliente = new Cliente();


    public MenuCliente() {
        initComponents();
        ubicarImagenes();
    }
  
    public void ubicarImagenes(){
        URL imgUrl = getClass().getResource("/dashboardimg/pclogoblanco.png");
        ImageIcon icon = new ImageIcon(imgUrl);
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        imgArmaPc.setIcon(new ImageIcon(image));
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;

        carritoPanel = new CarritoPanel(cliente);
        productosPanel = new PanelProductos(cliente);
        panelProcesarCompra = new PanelProcesarCompra(cliente);
        panelArmarPc = new PanelArmarPcCliente(cliente);
        panelHistorialPedidos = new PanelHistorialPedidos(cliente);
      
        carritoPanel.buttonProcesarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardView.removeAll();
                panelProcesarCompra.establecerProductos();
                dashboardView.add(panelProcesarCompra);
                dashboardView.revalidate();
                dashboardView.repaint();
            }

        });
      

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dashboardView = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        panelProducts = new javax.swing.JPanel();
        lblProducts = new javax.swing.JLabel();
        btnComprar1 = new javax.swing.JLabel();
        btnCarritoDeCompras = new javax.swing.JLabel();
        panelHistorial = new javax.swing.JPanel();
        lblHistorial = new javax.swing.JLabel();
        btnHistorialDeCompras = new javax.swing.JLabel();
        panelArmaPc = new javax.swing.JPanel();
        lblArmaPc = new javax.swing.JLabel();
        imgArmaPc = new javax.swing.JLabel();
        panelCarritoCompras = new javax.swing.JPanel();
        lblCarrito1 = new javax.swing.JLabel();
        btnCarritoDeCompras1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblCarrito2 = new javax.swing.JLabel();
        btnCarritoDeCompras2 = new javax.swing.JLabel();
        tittlePanel = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardView.setBackground(new java.awt.Color(102, 102, 102));
        dashboardView.setLayout(new java.awt.BorderLayout());
        jPanel1.add(dashboardView, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 960, 480));
        dashboardView.getAccessibleContext().setAccessibleDescription("");

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProducts.setOpaque(false);
        panelProducts.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelProductsMouseMoved(evt);
            }
        });
        panelProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProductsMouseEntered(evt);
            }
        });
        panelProducts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProducts.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblProducts.setForeground(new java.awt.Color(255, 255, 255));
        lblProducts.setText("Productos");
        panelProducts.add(lblProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        btnComprar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/9.png"))); // NOI18N
        btnComprar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprar1MouseClicked(evt);
            }
        });
        panelProducts.add(btnComprar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 220, -1));

        btnCarritoDeCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/9.png"))); // NOI18N
        panelProducts.add(btnCarritoDeCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        kGradientPanel1.add(panelProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 80));

        panelHistorial.setOpaque(false);
        panelHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHistorialMouseClicked(evt);
            }
        });
        panelHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHistorial.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHistorial.setForeground(new java.awt.Color(255, 255, 255));
        lblHistorial.setText("Historial de Pedidos");
        panelHistorial.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        btnHistorialDeCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/3.png"))); // NOI18N
        btnHistorialDeCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialDeComprasMouseClicked(evt);
            }
        });
        panelHistorial.add(btnHistorialDeCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 47, -1));

        kGradientPanel1.add(panelHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 80));

        panelArmaPc.setOpaque(false);
        panelArmaPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelArmaPcMouseClicked(evt);
            }
        });
        panelArmaPc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblArmaPc.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblArmaPc.setForeground(new java.awt.Color(255, 255, 255));
        lblArmaPc.setText("Arma tu PC");
        panelArmaPc.add(lblArmaPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        imgArmaPc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/3.png"))); // NOI18N
        imgArmaPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgArmaPcMouseClicked(evt);
            }
        });
        panelArmaPc.add(imgArmaPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 29, -1));

        kGradientPanel1.add(panelArmaPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 80));

        panelCarritoCompras.setOpaque(false);
        panelCarritoCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCarritoComprasMouseClicked(evt);
            }
        });
        panelCarritoCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarrito1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCarrito1.setForeground(new java.awt.Color(255, 255, 255));
        lblCarrito1.setText("Información personal");
        panelCarritoCompras.add(lblCarrito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        btnCarritoDeCompras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/9.png"))); // NOI18N
        panelCarritoCompras.add(btnCarritoDeCompras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        kGradientPanel1.add(panelCarritoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 220, 80));

        jPanel7.setOpaque(false);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarrito2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblCarrito2.setForeground(new java.awt.Color(255, 255, 255));
        lblCarrito2.setText("Carrito de compras");
        jPanel7.add(lblCarrito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnCarritoDeCompras2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/9.png"))); // NOI18N
        jPanel7.add(btnCarritoDeCompras2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        kGradientPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 80));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 410));

        tittlePanel.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(102, 102, 102));
        lblName.setText("TIENDA XXD");

        javax.swing.GroupLayout tittlePanelLayout = new javax.swing.GroupLayout(tittlePanel);
        tittlePanel.setLayout(tittlePanelLayout);
        tittlePanelLayout.setHorizontalGroup(
            tittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittlePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblName)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        tittlePanelLayout.setVerticalGroup(
            tittlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittlePanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lblName)
                .addGap(23, 23, 23))
        );

        jPanel1.add(tittlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1130, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelArmaPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelArmaPcMouseClicked
        if(panelArmarPc == null){
            panelArmarPc = new PanelArmarPcCliente(cliente);
        }
        dashboardView.removeAll();
        dashboardView.add(panelArmarPc);
        dashboardView.revalidate();
        dashboardView.repaint();
        
        System.out.println("Clcik");
    }//GEN-LAST:event_panelArmaPcMouseClicked

    private void imgArmaPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgArmaPcMouseClicked

    }//GEN-LAST:event_imgArmaPcMouseClicked

    private void btnHistorialDeComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialDeComprasMouseClicked

    }//GEN-LAST:event_btnHistorialDeComprasMouseClicked

    private void panelProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseEntered

    }//GEN-LAST:event_panelProductsMouseEntered

    private void panelProductsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseMoved

    }//GEN-LAST:event_panelProductsMouseMoved

    private void btnComprar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprar1MouseClicked

    }//GEN-LAST:event_btnComprar1MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        if(c.obtenerCarritoPorIdCliente(cliente.getId()) == null){
            c.agregar(cliente.getId());
        }
        
        if(panelProcesarCompra == null){
            panelProcesarCompra = new PanelProcesarCompra(cliente);
        }
        
        if(carritoPanel == null){
            carritoPanel = new CarritoPanel(cliente);
            carritoPanel.buttonProcesarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboardView.removeAll();
                panelProcesarCompra.establecerProductos();
                dashboardView.add(panelProcesarCompra);
                dashboardView.revalidate();
                dashboardView.repaint();
            }

        });
        }
        
        dashboardView.removeAll();
        carritoPanel.establecerComponentes();
        dashboardView.add(carritoPanel);
        dashboardView.revalidate();
        dashboardView.repaint();

    }//GEN-LAST:event_jPanel7MouseClicked

    private void panelProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseClicked
        
        if(c.obtenerCarritoPorIdCliente(cliente.getId()) == null){
            c.agregar(cliente.getId());
        }
        
        if(productosPanel == null){
            productosPanel = new PanelProductos(cliente);
        }

        productosPanel.establecerItems();
        dashboardView.removeAll();
        dashboardView.add(productosPanel);
        dashboardView.revalidate();
        dashboardView.repaint();
    }//GEN-LAST:event_panelProductsMouseClicked

    private void panelCarritoComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCarritoComprasMouseClicked
        
        dashboardView.removeAll();
        dashboardView.add(optionsClient);
        dashboardView.revalidate();
        dashboardView.repaint();
    }//GEN-LAST:event_panelCarritoComprasMouseClicked

    private void panelHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHistorialMouseClicked
        dashboardView.removeAll();
        dashboardView.add(panelHistorialPedidos);
        dashboardView.revalidate();
        dashboardView.repaint();

    }//GEN-LAST:event_panelHistorialMouseClicked

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCarritoDeCompras;
    private javax.swing.JLabel btnCarritoDeCompras1;
    private javax.swing.JLabel btnCarritoDeCompras2;
    private javax.swing.JLabel btnComprar1;
    private javax.swing.JLabel btnHistorialDeCompras;
    private javax.swing.JPanel dashboardView;
    private javax.swing.JLabel imgArmaPc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblArmaPc;
    private javax.swing.JLabel lblCarrito1;
    private javax.swing.JLabel lblCarrito2;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JPanel panelArmaPc;
    private javax.swing.JPanel panelCarritoCompras;
    private javax.swing.JPanel panelHistorial;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JPanel tittlePanel;
    // End of variables declaration//GEN-END:variables
}
