package gui.panels;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class FabricacionPanel extends javax.swing.JPanel {
    private ImageIcon imagen;
    public FabricacionPanel() {
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
        OpcionComponentes = new javax.swing.JPanel();
        LblComponentes1 = new javax.swing.JLabel();
        OpcionPeriferico = new javax.swing.JPanel();
        LblComponentes2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BarraSup = new javax.swing.JPanel();
        btnCerrarOpciones = new javax.swing.JButton();
        btnOpciones2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setPreferredSize(new java.awt.Dimension(800, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sliderOpciones.setBackground(new java.awt.Color(51, 204, 255));
        sliderOpciones.setForeground(new java.awt.Color(0, 204, 255));
        sliderOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OpcionComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionComponentesMouseClicked(evt);
            }
        });
        OpcionComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes1.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/iconCompo.png"))); // NOI18N
        LblComponentes1.setText("Componentes");
        OpcionComponentes.add(LblComponentes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        sliderOpciones.add(OpcionComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 50));

        OpcionPeriferico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpcionPerifericoMouseClicked(evt);
            }
        });
        OpcionPeriferico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblComponentes2.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        LblComponentes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/iconPerif.png"))); // NOI18N
        LblComponentes2.setText("  Periféricos");
        OpcionPeriferico.add(LblComponentes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 40));

        sliderOpciones.add(OpcionPeriferico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, 50));

        add(sliderOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 150, 380));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 380, 270));

        BarraSup.setBackground(new java.awt.Color(51, 51, 255));
        BarraSup.setForeground(new java.awt.Color(51, 51, 255));
        BarraSup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/x.png"))); // NOI18N
        btnCerrarOpciones.setBorderPainted(false);
        btnCerrarOpciones.setContentAreaFilled(false);
        btnCerrarOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarOpcionesActionPerformed(evt);
            }
        });
        BarraSup.add(btnCerrarOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 5, 30, 30));

        btnOpciones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenees/botonOpciones.png"))); // NOI18N
        btnOpciones2.setBorderPainted(false);
        btnOpciones2.setContentAreaFilled(false);
        btnOpciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpciones2ActionPerformed(evt);
            }
        });
        BarraSup.add(btnOpciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 30, 30));

        add(BarraSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarOpcionesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCerrarOpcionesActionPerformed

    private void btnOpciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpciones2ActionPerformed
        // TODO add your handling code here:
        int posicion = this.sliderOpciones.getX();
        if(posicion >-1){
            Animacion.Animacion.mover_izquierda(0, -188, 2, 2, sliderOpciones);
        }
        else{
            Animacion.Animacion.mover_derecha(-188, 0, 2, 2, sliderOpciones);
        }
    }//GEN-LAST:event_btnOpciones2ActionPerformed

    private void OpcionComponentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionComponentesMouseClicked
        // TODO add your handling code here:
            String rutaImagen = "C:/Users/henry/OneDrive/Escritorio/de la usil/3 ciclo/POO2/USILPOOII-2220329/Final_POOII/src/imagenees/x.png";
    imagen = new ImageIcon(rutaImagen);
    // Establece la imagen en un JLabel dentro del panel
    JLabel labelImagen = new JLabel(imagen);
    jPanel1.removeAll();  // Elimina cualquier componente anterior
    jPanel1.add(labelImagen);  // Agrega la imagen al panel
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_OpcionComponentesMouseClicked

    private void OpcionPerifericoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpcionPerifericoMouseClicked
        // TODO add your handling code here:
        String rutaImagen = "C:/Users/henry/OneDrive/Escritorio/de la usil/3 ciclo/POO2/USILPOOII-2220329/Final_POOII/src/imagenees/iconCarrito.png";
    imagen = new ImageIcon(rutaImagen);
    // Establece la imagen en un JLabel dentro del panel
    JLabel labelImagen = new JLabel(imagen);
    jPanel1.removeAll();  // Elimina cualquier componente anterior
    jPanel1.add(labelImagen);  // Agrega la imagen al panel
    jPanel1.revalidate();
    jPanel1.repaint();
    }//GEN-LAST:event_OpcionPerifericoMouseClicked

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
    private javax.swing.JPanel OpcionComponentes;
    private javax.swing.JPanel OpcionPeriferico;
    private javax.swing.JButton btnCerrarOpciones;
    private javax.swing.JButton btnOpciones2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel sliderOpciones;
    // End of variables declaration//GEN-END:variables
}
