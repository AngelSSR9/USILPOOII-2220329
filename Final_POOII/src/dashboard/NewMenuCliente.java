
package dashboard;

import diseño.AnimateBTT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.Cliente;
import conexionBD.CarritoDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import login.LoginCliente;

public class NewMenuCliente extends javax.swing.JFrame {

    AnimateBTT cambioColor = new AnimateBTT();
    CarritoDAO c = new CarritoDAO();
    PanelProcesarCompra panelProcesarCompra;
    CarritoPanel carritoPanel;
    PanelProductos productosPanel;
    PanelArmarPcCliente panelArmarPc;
    PanelHistorialPedidos panelHistorialPedidos;
    OptionsClient optionsClient;
    Cliente cliente = new Cliente();
    
    public NewMenuCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false); //Evita que el usuario modifque el tamaño
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;

        carritoPanel = new CarritoPanel(cliente);
        productosPanel = new PanelProductos(cliente);
        panelProcesarCompra = new PanelProcesarCompra(cliente);
        panelArmarPc = new PanelArmarPcCliente(cliente);
        panelHistorialPedidos = new PanelHistorialPedidos(cliente);
        optionsClient = new OptionsClient(cliente);
      
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipalPanel = new javax.swing.JPanel();
        dashboardView = new javax.swing.JPanel();
        optionMenu = new keeptoo.KGradientPanel();
        btnCarritoCompras = new diseño.RoundedPanelGradient();
        txtCarrito = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnSalir = new diseño.RoundedPanelGradient();
        txtSali = new javax.swing.JLabel();
        btnProductos = new diseño.RoundedPanelGradient();
        txtProductos = new javax.swing.JLabel();
        btnArmarPc = new diseño.RoundedPanelGradient();
        txtArmarPC = new javax.swing.JLabel();
        btnHistorial = new diseño.RoundedPanelGradient();
        txtHistorial = new javax.swing.JLabel();
        btnAjustes = new diseño.RoundedPanelGradient();
        txtAjustes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1160, 530));

        menuPrincipalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardView.setBackground(new java.awt.Color(102, 102, 102));
        dashboardView.setLayout(new java.awt.BorderLayout());
        menuPrincipalPanel.add(dashboardView, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 960, 500));

        optionMenu.setBackground(new java.awt.Color(0, 0, 0));
        optionMenu.setkEndColor(new java.awt.Color(0, 0, 0));
        optionMenu.setkStartColor(new java.awt.Color(0, 0, 0));
        optionMenu.setMinimumSize(new java.awt.Dimension(220, 400));
        optionMenu.setPreferredSize(new java.awt.Dimension(220, 400));
        optionMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCarritoCompras.setBackground(new java.awt.Color(23, 27, 36));
        btnCarritoCompras.setColorGradient(new java.awt.Color(23, 27, 36));
        btnCarritoCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCarritoComprasMousePressed(evt);
            }
        });
        btnCarritoCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCarrito.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCarrito.setForeground(new java.awt.Color(255, 255, 255));
        txtCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/carro.png"))); // NOI18N
        txtCarrito.setText("   Carrito Productos");
        btnCarritoCompras.add(txtCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        optionMenu.add(btnCarritoCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 60));

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("TIENDA XXD");
        optionMenu.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        btnSalir.setRadius(10);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        btnSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSali.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSali.setForeground(new java.awt.Color(0, 0, 0));
        txtSali.setText("Salir");
        btnSalir.add(txtSali, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 3, 30, 20));

        optionMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 80, 30));

        btnProductos.setBackground(new java.awt.Color(23, 27, 36));
        btnProductos.setColorGradient(new java.awt.Color(23, 27, 36));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProductosMousePressed(evt);
            }
        });
        btnProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtProductos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtProductos.setForeground(new java.awt.Color(255, 255, 255));
        txtProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/producto.png"))); // NOI18N
        txtProductos.setText("  Productos");
        btnProductos.add(txtProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        optionMenu.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, 180, 60));

        btnArmarPc.setBackground(new java.awt.Color(23, 27, 36));
        btnArmarPc.setColorGradient(new java.awt.Color(23, 27, 36));
        btnArmarPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnArmarPcMousePressed(evt);
            }
        });
        btnArmarPc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtArmarPC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtArmarPC.setForeground(new java.awt.Color(255, 255, 255));
        txtArmarPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/armar.png"))); // NOI18N
        txtArmarPC.setText("  Armar PC");
        btnArmarPc.add(txtArmarPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        optionMenu.add(btnArmarPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 180, 60));

        btnHistorial.setBackground(new java.awt.Color(23, 27, 36));
        btnHistorial.setColorGradient(new java.awt.Color(23, 27, 36));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHistorialMousePressed(evt);
            }
        });
        btnHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHistorial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtHistorial.setForeground(new java.awt.Color(255, 255, 255));
        txtHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/historial.png"))); // NOI18N
        txtHistorial.setText("  Historial de Pedidos");
        btnHistorial.add(txtHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        optionMenu.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, 180, 60));

        btnAjustes.setBackground(new java.awt.Color(23, 27, 36));
        btnAjustes.setColorGradient(new java.awt.Color(23, 27, 36));
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAjustesMousePressed(evt);
            }
        });
        btnAjustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAjustes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAjustes.setForeground(new java.awt.Color(255, 255, 255));
        txtAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/ajuste.png"))); // NOI18N
        txtAjustes.setText("  Ajustes");
        btnAjustes.add(txtAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        optionMenu.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 180, 60));

        menuPrincipalPanel.add(optionMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPrincipalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarritoComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarritoComprasMousePressed
        cambioColor.AnimattCarrito();
        
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
    }//GEN-LAST:event_btnCarritoComprasMousePressed

    private void btnProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMousePressed
        cambioColor.AnimattProductos();
        
        if(productosPanel == null){
            productosPanel = new PanelProductos(cliente);
        }

        productosPanel.establecerItems();
        dashboardView.removeAll();
        dashboardView.add(productosPanel);
        dashboardView.revalidate();
        dashboardView.repaint();
    }//GEN-LAST:event_btnProductosMousePressed

    private void btnArmarPcMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArmarPcMousePressed
        cambioColor.AnimattArmarPC();
        if(panelArmarPc == null){
            panelArmarPc = new PanelArmarPcCliente(cliente);
        }
        panelArmarPc.establecerItems();
        dashboardView.removeAll();
        dashboardView.add(panelArmarPc);
        dashboardView.revalidate();
        dashboardView.repaint();
        
    }//GEN-LAST:event_btnArmarPcMousePressed

    private void btnHistorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMousePressed
        cambioColor.AnimattHistorial();
        panelHistorialPedidos= new PanelHistorialPedidos(cliente);
        dashboardView.removeAll();
        dashboardView.add(panelHistorialPedidos);
        dashboardView.revalidate();
        dashboardView.repaint();
    }//GEN-LAST:event_btnHistorialMousePressed

    private void btnAjustesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMousePressed
        cambioColor.AnimattAjustes();
        if( optionsClient== null){
            optionsClient= new OptionsClient(cliente);
        }
        optionsClient.verificarCheck(cliente);
        dashboardView.removeAll();
        dashboardView.add(optionsClient);
        dashboardView.revalidate();
        dashboardView.repaint();
    }//GEN-LAST:event_btnAjustesMousePressed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        LoginCliente logCli = new LoginCliente();
        logCli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                setVisible(true);
            }
        });
        logCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirMouseClicked

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
            java.util.logging.Logger.getLogger(NewMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static diseño.RoundedPanelGradient btnAjustes;
    public static diseño.RoundedPanelGradient btnArmarPc;
    public static diseño.RoundedPanelGradient btnCarritoCompras;
    public static diseño.RoundedPanelGradient btnHistorial;
    public static diseño.RoundedPanelGradient btnProductos;
    private diseño.RoundedPanelGradient btnSalir;
    private javax.swing.JPanel dashboardView;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel menuPrincipalPanel;
    public static keeptoo.KGradientPanel optionMenu;
    public static javax.swing.JLabel txtAjustes;
    public static javax.swing.JLabel txtArmarPC;
    public static javax.swing.JLabel txtCarrito;
    public static javax.swing.JLabel txtHistorial;
    public static javax.swing.JLabel txtProductos;
    private javax.swing.JLabel txtSali;
    // End of variables declaration//GEN-END:variables
}
