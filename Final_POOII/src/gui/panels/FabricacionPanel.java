package gui.panels;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FabricacionPanel extends javax.swing.JPanel {

    private ImageIcon imagen;
    private RegistroProductos regProd;

    public FabricacionPanel() {
        initComponents();
        cargarComboBoxProductos();
        cargarComboBoxColores();
        this.regProd = new RegistroProductos();

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
        opcionVerProductos = new javax.swing.JPanel();
        LblComponentes6 = new javax.swing.JLabel();
        opcionAnunciar = new javax.swing.JPanel();
        LblComponentes5 = new javax.swing.JLabel();
        OpcionComponentes = new javax.swing.JPanel();
        LblComponentes1 = new javax.swing.JLabel();
        OpcionPeriferico = new javax.swing.JPanel();
        LblComponentes2 = new javax.swing.JLabel();
        OpcionVentasDelDia = new javax.swing.JPanel();
        LblComponentes3 = new javax.swing.JLabel();
        opcionIyE = new javax.swing.JPanel();
        LblComponentes4 = new javax.swing.JLabel();
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

        opcionVerProductos.setBackground(new java.awt.Color(51, 204, 255));
        opcionVerProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionVerProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionVerProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionVerProductosMouseExited(evt);
            }
        });
        opcionVerProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes6.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes6.setText("Ver productos");
        opcionVerProductos.add(LblComponentes6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        sliderOpciones.add(opcionVerProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 170, 50));

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

        sliderOpciones.add(opcionAnunciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 170, 50));

        OpcionComponentes.setBackground(new java.awt.Color(51, 204, 255));
        OpcionComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionComponentesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OpcionComponentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OpcionComponentesMouseExited(evt);
            }
        });
        OpcionComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes1.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes1.setText("Componentes");
        OpcionComponentes.add(LblComponentes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(OpcionComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 50));

        OpcionPeriferico.setBackground(new java.awt.Color(51, 204, 255));
        OpcionPeriferico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionPerifericoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OpcionPerifericoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OpcionPerifericoMouseExited(evt);
            }
        });
        OpcionPeriferico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes2.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconPerif.png"))); // NOI18N
        LblComponentes2.setText("  Periféricos");
        OpcionPeriferico.add(LblComponentes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        sliderOpciones.add(OpcionPeriferico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, 50));

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
        LblComponentes3.setText("Ventas del dia");
        OpcionVentasDelDia.add(LblComponentes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(OpcionVentasDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 170, -1));

        opcionIyE.setBackground(new java.awt.Color(51, 204, 255));
        opcionIyE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionIyEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionIyEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionIyEMouseExited(evt);
            }
        });
        opcionIyE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes4.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconCompo.png"))); // NOI18N
        LblComponentes4.setText("Ver ingreso y egresos");
        opcionIyE.add(LblComponentes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(opcionIyE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 170, 40));

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

    private void OpcionComponentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionComponentesMouseClicked
        // TODO add your handling code here:
        String rutaImagen = "C:/Users/henry/OneDrive/Escritorio/de la usil/3 ciclo/POO2/USILPOOII-2220329/Final_POOII/src/img/x.png";
        imagen = new ImageIcon(rutaImagen);
        // Establece la imagen en un JLabel dentro del panel
        JLabel labelImagen = new JLabel(imagen);
        panelContenido.removeAll();  // Elimina cualquier componente anterior
        panelContenido.add(labelImagen);  // Agrega la imagen al panel
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_OpcionComponentesMouseClicked

    private void OpcionPerifericoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionPerifericoMouseClicked
        // TODO add your handling code here:
        String rutaImagen = "C:/Users/henry/OneDrive/Escritorio/de la usil/3 ciclo/POO2/USILPOOII-2220329/Final_POOII/src/img/iconCarrito.png";
        imagen = new ImageIcon(rutaImagen);
        // Establece la imagen en un JLabel dentro del panel
        JLabel labelImagen = new JLabel(imagen);
        panelContenido.removeAll();  // Elimina cualquier componente anterior
        panelContenido.add(labelImagen);  // Agrega la imagen al panel
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_OpcionPerifericoMouseClicked

    private void OpcionComponentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionComponentesMouseEntered
        // TODO add your handling code here:
        OpcionComponentes.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_OpcionComponentesMouseEntered

    private void OpcionComponentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionComponentesMouseExited
        // TODO add your handling code here:
        OpcionComponentes.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_OpcionComponentesMouseExited

    private void OpcionPerifericoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionPerifericoMouseEntered
        // TODO add your handling code here:
        OpcionPeriferico.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_OpcionPerifericoMouseEntered

    private void OpcionPerifericoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionPerifericoMouseExited
        // TODO add your handling code here:
        OpcionPeriferico.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_OpcionPerifericoMouseExited

    private void OpcionVentasDelDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_OpcionVentasDelDiaMouseClicked

    private void OpcionVentasDelDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseEntered
        // TODO add your handling code here:
        OpcionVentasDelDia.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_OpcionVentasDelDiaMouseEntered

    private void OpcionVentasDelDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionVentasDelDiaMouseExited
        // TODO add your handling code here:
        OpcionVentasDelDia.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_OpcionVentasDelDiaMouseExited

    private void opcionIyEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionIyEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionIyEMouseClicked

    private void opcionIyEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionIyEMouseEntered
        // TODO add your handling code here:
        opcionIyE.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionIyEMouseEntered

    private void opcionIyEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionIyEMouseExited
        // TODO add your handling code here:
        opcionIyE.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionIyEMouseExited

    private void opcionAnunciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionAnunciarMouseClicked

    private void opcionAnunciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseEntered
        // TODO add your handling code here:
        opcionAnunciar.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionAnunciarMouseEntered

    private void opcionAnunciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAnunciarMouseExited
        // TODO add your handling code here:
        opcionAnunciar.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionAnunciarMouseExited

    private void opcionVerProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerProductosMouseClicked
        // TODO add your handling code here:
        panelContenido.removeAll();
        panelContenido.add(regProd);
        panelContenido.revalidate();
        panelContenido.repaint();
        
    }//GEN-LAST:event_opcionVerProductosMouseClicked

    private void opcionVerProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerProductosMouseEntered
        // TODO add your handling code here:
        opcionVerProductos.setBackground(new Color(102,255,255));
    }//GEN-LAST:event_opcionVerProductosMouseEntered

    private void opcionVerProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionVerProductosMouseExited
        // TODO add your handling code here:
        opcionVerProductos.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_opcionVerProductosMouseExited

    public JButton getBtnCerrarOpciones() {
        return btnCerrarOpciones;

    }

    public void setBtnCerrarOpciones(JButton btnCerrarOpciones) {
        this.btnCerrarOpciones = btnCerrarOpciones;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSup;
    private javax.swing.JLabel LblComponentes1;
    private javax.swing.JLabel LblComponentes2;
    private javax.swing.JLabel LblComponentes3;
    private javax.swing.JLabel LblComponentes4;
    private javax.swing.JLabel LblComponentes5;
    private javax.swing.JLabel LblComponentes6;
    private javax.swing.JPanel OpcionComponentes;
    private javax.swing.JPanel OpcionPeriferico;
    private javax.swing.JPanel OpcionVentasDelDia;
    private javax.swing.JPanel barraSup;
    private javax.swing.JButton btnCerrarOpciones;
    private javax.swing.JButton btnOpciones2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel opcionAnunciar;
    private javax.swing.JPanel opcionIyE;
    private javax.swing.JPanel opcionVerProductos;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel sliderOpciones;
    // End of variables declaration//GEN-END:variables
}
