
package gui.panels;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class OpcionesAdminPanel extends javax.swing.JPanel {

    private JFrame mainFrame;
    public OpcionesAdminPanel(JFrame mainFrame) {
        initComponents();
        this.mainFrame= mainFrame;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVentasDelDia = new javax.swing.JButton();
        btnAgregarNuevoProducto1 = new javax.swing.JButton();
        btnVerProductos = new javax.swing.JButton();
        btnHistorialDePedidos1 = new javax.swing.JButton();
        btnVerIngresos1 = new javax.swing.JButton();
        btnVerEgresos1 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVentasDelDia.setBackground(new java.awt.Color(153, 153, 255));
        btnVentasDelDia.setForeground(new java.awt.Color(0, 0, 0));
        btnVentasDelDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton6.png"))); // NOI18N
        btnVentasDelDia.setText("Ventas Del Dia");
        btnVentasDelDia.setBorder(null);
        btnVentasDelDia.setBorderPainted(false);
        btnVentasDelDia.setContentAreaFilled(false);
        btnVentasDelDia.setFocusPainted(false);
        btnVentasDelDia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVentasDelDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasDelDiaActionPerformed(evt);
            }
        });
        add(btnVentasDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        btnAgregarNuevoProducto1.setBackground(new java.awt.Color(153, 153, 255));
        btnAgregarNuevoProducto1.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarNuevoProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton.png"))); // NOI18N
        btnAgregarNuevoProducto1.setText("Agregar nuevo producto ");
        btnAgregarNuevoProducto1.setBorder(null);
        btnAgregarNuevoProducto1.setBorderPainted(false);
        btnAgregarNuevoProducto1.setContentAreaFilled(false);
        btnAgregarNuevoProducto1.setDefaultCapable(false);
        btnAgregarNuevoProducto1.setFocusPainted(false);
        btnAgregarNuevoProducto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarNuevoProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevoProducto1ActionPerformed(evt);
            }
        });
        add(btnAgregarNuevoProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 250, 40));

        btnVerProductos.setBackground(new java.awt.Color(153, 153, 255));
        btnVerProductos.setForeground(new java.awt.Color(0, 0, 0));
        btnVerProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton1.png"))); // NOI18N
        btnVerProductos.setText("Ver todos los productos");
        btnVerProductos.setBorder(null);
        btnVerProductos.setBorderPainted(false);
        btnVerProductos.setContentAreaFilled(false);
        btnVerProductos.setFocusPainted(false);
        btnVerProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });
        add(btnVerProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        btnHistorialDePedidos1.setBackground(new java.awt.Color(153, 153, 255));
        btnHistorialDePedidos1.setForeground(new java.awt.Color(0, 0, 0));
        btnHistorialDePedidos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton3.png"))); // NOI18N
        btnHistorialDePedidos1.setText("Ver historial de pedidos");
        btnHistorialDePedidos1.setBorder(null);
        btnHistorialDePedidos1.setBorderPainted(false);
        btnHistorialDePedidos1.setContentAreaFilled(false);
        btnHistorialDePedidos1.setFocusPainted(false);
        btnHistorialDePedidos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorialDePedidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialDePedidos1ActionPerformed(evt);
            }
        });
        add(btnHistorialDePedidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 40));

        btnVerIngresos1.setBackground(new java.awt.Color(153, 153, 255));
        btnVerIngresos1.setForeground(new java.awt.Color(0, 0, 0));
        btnVerIngresos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton4.png"))); // NOI18N
        btnVerIngresos1.setText("Ver Ingresos");
        btnVerIngresos1.setBorder(null);
        btnVerIngresos1.setBorderPainted(false);
        btnVerIngresos1.setContentAreaFilled(false);
        btnVerIngresos1.setFocusPainted(false);
        btnVerIngresos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerIngresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerIngresos1ActionPerformed(evt);
            }
        });
        add(btnVerIngresos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, 40));

        btnVerEgresos1.setBackground(new java.awt.Color(153, 153, 255));
        btnVerEgresos1.setForeground(new java.awt.Color(0, 0, 0));
        btnVerEgresos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/boton5.png"))); // NOI18N
        btnVerEgresos1.setText("Ver egresos");
        btnVerEgresos1.setBorder(null);
        btnVerEgresos1.setBorderPainted(false);
        btnVerEgresos1.setContentAreaFilled(false);
        btnVerEgresos1.setFocusPainted(false);
        btnVerEgresos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerEgresos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEgresos1ActionPerformed(evt);
            }
        });
        add(btnVerEgresos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, 40));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/x.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/administrador.png"))); // NOI18N
        jLabel1.setText("imgAdmin");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 190, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/fondo.png"))); // NOI18N
        add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentasDelDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasDelDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasDelDiaActionPerformed

    private void btnAgregarNuevoProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevoProducto1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAgregarNuevoProducto1ActionPerformed
    
    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerProductosActionPerformed

    private void btnHistorialDePedidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialDePedidos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialDePedidos1ActionPerformed

    private void btnVerIngresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerIngresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerIngresos1ActionPerformed

    private void btnVerEgresos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEgresos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerEgresos1ActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            // Cerrar el JFrame
            frame.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    public JButton getBtnAgregarNuevoProducto1() {
        return btnAgregarNuevoProducto1;
    }

    public void setBtnAgregarNuevoProducto1(JButton btnAgregarNuevoProducto1) {
        this.btnAgregarNuevoProducto1 = btnAgregarNuevoProducto1;
    }

    public JButton getBtnVerProductos() {
        return btnVerProductos;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnAgregarNuevoProducto1;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnHistorialDePedidos1;
    private javax.swing.JButton btnVentasDelDia;
    private javax.swing.JButton btnVerEgresos1;
    private javax.swing.JButton btnVerIngresos1;
    private javax.swing.JButton btnVerProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
