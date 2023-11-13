package gui.panels;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MenuAdminPanel extends javax.swing.JPanel {

    private RegistroProductosPanel regProd;
    private VentasDelDiaPanel vnts;
    private VerClientesPanel clnts;
    private AgregarProductoPanel agg;
    private AnunciarPanel anun;
    private AgregarPc pc;

    public MenuAdminPanel() {
        initComponents();
        cargarComboBoxProductos();
        cargarComboBoxColores();
        
        
    }

    private void cargarComboBoxProductos() {

    }

    private void cargarComboBoxColores() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        sliderOpciones = new javax.swing.JPanel();
        opcionRegistrarProductos = new javax.swing.JPanel();
        LblComponentes6 = new javax.swing.JLabel();
        LblComponentes7 = new javax.swing.JLabel();
        opcionAnunciar = new javax.swing.JPanel();
        LblComponentes5 = new javax.swing.JLabel();
        OpcionAgregarPc = new javax.swing.JPanel();
        LblComponentes2 = new javax.swing.JLabel();
        OpcionVentasDelDia = new javax.swing.JPanel();
        LblComponentes3 = new javax.swing.JLabel();
        opcionVerClientes = new javax.swing.JPanel();
        LblComponentes4 = new javax.swing.JLabel();
        opcionAgregarProductos = new javax.swing.JPanel();
        LblComponentes8 = new javax.swing.JLabel();
        LblComponentes9 = new javax.swing.JLabel();
        BarraSup = new javax.swing.JPanel();
        btnCerrarOpciones = new javax.swing.JButton();
        btnOpciones2 = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        barraSup = new javax.swing.JPanel();

        jLabel2.setText("jLabel2");

        setPreferredSize(new java.awt.Dimension(650, 420));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sliderOpciones.setBackground(new java.awt.Color(51, 204, 255));
        sliderOpciones.setForeground(new java.awt.Color(0, 204, 255));
        sliderOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opcionRegistrarProductos.setBackground(new java.awt.Color(51, 204, 255));
        opcionRegistrarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionRegistrarProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionRegistrarProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionRegistrarProductosMouseExited(evt);
            }
        });
        opcionRegistrarProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes6.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes6.setText("registro");
        opcionRegistrarProductos.add(LblComponentes6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        LblComponentes7.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes7.setText("productos");
        opcionRegistrarProductos.add(LblComponentes7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        sliderOpciones.add(opcionRegistrarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 170, 50));

        opcionAnunciar.setBackground(new java.awt.Color(51, 204, 255));
        opcionAnunciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAnunciarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionAnunciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionAnunciarMouseExited(evt);
            }
        });
        opcionAnunciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes5.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes5.setText("Anunciar");
        opcionAnunciar.add(LblComponentes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(opcionAnunciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 170, 50));

        OpcionAgregarPc.setBackground(new java.awt.Color(51, 204, 255));
        OpcionAgregarPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionAgregarPcMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OpcionAgregarPcMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OpcionAgregarPcMouseExited(evt);
            }
        });
        OpcionAgregarPc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes2.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconPerif.png"))); // NOI18N
        LblComponentes2.setText("Agregar Pc");
        OpcionAgregarPc.add(LblComponentes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        sliderOpciones.add(OpcionAgregarPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, 50));

        OpcionVentasDelDia.setBackground(new java.awt.Color(51, 204, 255));
        OpcionVentasDelDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionVentasDelDiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OpcionVentasDelDiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OpcionVentasDelDiaMouseExited(evt);
            }
        });
        OpcionVentasDelDia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes3.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes3.setText("VEr pedidos");
        OpcionVentasDelDia.add(LblComponentes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(OpcionVentasDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, -1));

        opcionVerClientes.setBackground(new java.awt.Color(51, 204, 255));
        opcionVerClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionVerClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionVerClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionVerClientesMouseExited(evt);
            }
        });
        opcionVerClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes4.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes4.setText("VEr clientes");
        opcionVerClientes.add(LblComponentes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(opcionVerClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 40));

        opcionAgregarProductos.setBackground(new java.awt.Color(51, 204, 255));
        opcionAgregarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionAgregarProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionAgregarProductosMouseExited(evt);
            }
        });
        opcionAgregarProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes8.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes8.setText("Agregar");
        opcionAgregarProductos.add(LblComponentes8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        LblComponentes9.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes9.setText("productos");
        opcionAgregarProductos.add(LblComponentes9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 20));

        sliderOpciones.add(opcionAgregarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, 50));

        add(sliderOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 170, 570));

        BarraSup.setBackground(new java.awt.Color(51, 51, 255));
        BarraSup.setForeground(new java.awt.Color(51, 51, 255));
        BarraSup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x.png"))); // NOI18N
        btnCerrarOpciones.setBorderPainted(false);
        btnCerrarOpciones.setContentAreaFilled(false);
        btnCerrarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarOpcionesActionPerformed(evt);
            }
        });
        BarraSup.add(btnCerrarOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 30, 30));

        btnOpciones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonOpciones.png"))); // NOI18N
        btnOpciones2.setBorderPainted(false);
        btnOpciones2.setContentAreaFilled(false);
        btnOpciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpciones2ActionPerformed(evt);
            }
        });
        BarraSup.add(btnOpciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 30, 30));

        add(BarraSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 40));

        panelContenido.setBackground(new java.awt.Color(204, 204, 204));

        barraSup.setBackground(new java.awt.Color(204, 204, 204));
        panelContenido.add(barraSup);

        add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 853, 496));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarOpcionesActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            // Cerrar el JFrame
            frame.dispose();
    }//GEN-LAST:event_btnCerrarOpcionesActionPerformed

    private void btnOpciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpciones2ActionPerformed
        // TODO add your handling code here:
        int posicion = this.sliderOpciones.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -188, 2, 2, sliderOpciones);
        } else {
            Animacion.Animacion.mover_derecha(-188, 0, 2, 2, sliderOpciones);
        }
    }//GEN-LAST:event_btnOpciones2ActionPerformed

    private void OpcionAgregarPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionAgregarPcMouseClicked
        // TODO add your handling code here:
        this.pc = new AgregarPc();
        panelContenido.removeAll();  // Elimina cualquier componente anterior
        panelContenido.add(pc);  // Agrega la imagen al panel
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_OpcionAgregarPcMouseClicked

    private void OpcionAgregarPcMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionAgregarPcMouseEntered
        // TODO add your handling code here:
        OpcionAgregarPc.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_OpcionAgregarPcMouseEntered

    private void OpcionAgregarPcMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionAgregarPcMouseExited
        // TODO add your handling code here:
        OpcionAgregarPc.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_OpcionAgregarPcMouseExited

    private void OpcionVentasDelDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseClicked
        // TODO add your handling code here:
        this.vnts = new VentasDelDiaPanel();
        panelContenido.removeAll();
        panelContenido.add(vnts);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_OpcionVentasDelDiaMouseClicked

    private void OpcionVentasDelDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseEntered
        // TODO add your handling code here:
        OpcionVentasDelDia.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_OpcionVentasDelDiaMouseEntered

    private void OpcionVentasDelDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseExited
        // TODO add your handling code here:
        OpcionVentasDelDia.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_OpcionVentasDelDiaMouseExited

    private void opcionVerClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerClientesMouseClicked
        // TODO add your handling code here:
        this.clnts = new VerClientesPanel();
        panelContenido.removeAll();
        panelContenido.add(clnts);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_opcionVerClientesMouseClicked

    private void opcionVerClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerClientesMouseEntered
        // TODO add your handling code here:
        opcionVerClientes.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionVerClientesMouseEntered

    private void opcionVerClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerClientesMouseExited
        // TODO add your handling code here:
        opcionVerClientes.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionVerClientesMouseExited

    private void opcionAnunciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseClicked
        // TODO add your handling code here:
        this.anun = new AnunciarPanel();
        panelContenido.removeAll();
        panelContenido.add(anun);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_opcionAnunciarMouseClicked

    private void opcionAnunciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseEntered
        // TODO add your handling code here:
        opcionAnunciar.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionAnunciarMouseEntered

    private void opcionAnunciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseExited
        // TODO add your handling code here:
        opcionAnunciar.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionAnunciarMouseExited

    private void opcionRegistrarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionRegistrarProductosMouseClicked
        // TODO add your handling code here:
        this.regProd = new RegistroProductosPanel();
        panelContenido.removeAll();
        panelContenido.add(regProd);
        panelContenido.revalidate();
        panelContenido.repaint();
        
    }//GEN-LAST:event_opcionRegistrarProductosMouseClicked

    private void opcionRegistrarProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionRegistrarProductosMouseEntered
        // TODO add your handling code here:
        opcionRegistrarProductos.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionRegistrarProductosMouseEntered

    private void opcionRegistrarProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionRegistrarProductosMouseExited
        // TODO add your handling code here:
        opcionRegistrarProductos.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionRegistrarProductosMouseExited

    private void opcionAgregarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarProductosMouseClicked
        // TODO add your handling code here:
        this.agg = new AgregarProductoPanel();
        panelContenido.removeAll();
        panelContenido.add(agg);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_opcionAgregarProductosMouseClicked

    private void opcionAgregarProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarProductosMouseEntered
        // TODO add your handling code here:
        opcionAgregarProductos.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionAgregarProductosMouseEntered

    private void opcionAgregarProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarProductosMouseExited
        // TODO add your handling code here:
        opcionAgregarProductos.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionAgregarProductosMouseExited

    public JButton getBtnCerrarOpciones() {
        return btnCerrarOpciones;

    }

    public void setBtnCerrarOpciones(JButton btnCerrarOpciones) {
        this.btnCerrarOpciones = btnCerrarOpciones;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSup;
    private javax.swing.JLabel LblComponentes2;
    private javax.swing.JLabel LblComponentes3;
    private javax.swing.JLabel LblComponentes4;
    private javax.swing.JLabel LblComponentes5;
    private javax.swing.JLabel LblComponentes6;
    private javax.swing.JLabel LblComponentes7;
    private javax.swing.JLabel LblComponentes8;
    private javax.swing.JLabel LblComponentes9;
    private javax.swing.JPanel OpcionAgregarPc;
    private javax.swing.JPanel OpcionVentasDelDia;
    private javax.swing.JPanel barraSup;
    private javax.swing.JButton btnCerrarOpciones;
    private javax.swing.JButton btnOpciones2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel opcionAgregarProductos;
    private javax.swing.JPanel opcionAnunciar;
    private javax.swing.JPanel opcionRegistrarProductos;
    private javax.swing.JPanel opcionVerClientes;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel sliderOpciones;
    // End of variables declaration//GEN-END:variables
}
