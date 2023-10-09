package gui.frames;

import gui.panels.FabricacionPanel;
import gui.panels.OpcionesAdminPanel;
import gui.panels.RegistroProductos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenuGerente extends javax.swing.JFrame {

    int xMouse, yMouse;
    OpcionesAdminPanel panelOpciones;
    FabricacionPanel fab;
    RegistroProductos registroProductos;

    public FrameMenuGerente() {
        initComponents();
        setLocationRelativeTo(null);
        agregarEventos();
        eventosBotones();

    }

    private void eventosBotones() {
        panelOpciones.getBtnAgregarNuevoProducto1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*panelPrincipal.removeAll();
                panelPrincipal.add(fab);*/

                panelPrincipal.removeAll();
                panelPrincipal.add(fab);
                pack();
                revalidate();
                repaint();
            }
        });

        panelOpciones.getBtnVerProductos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia el contenido del JFrame al panel registroProductos
                panelPrincipal.setVisible(false);
                setContentPane(registroProductos);
                pack();
                revalidate();
                repaint();

            }
        });

        //Configuracion para cerrar panels
        fab.getBtnCerrarOpciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelOpciones);
                
                pack();
                revalidate();
                repaint();
            }
        });

        registroProductos.getBtnCerrarOpciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setContentPane(panelPrincipal);
                panelPrincipal.setVisible(true);
                
                pack();
                revalidate();
                repaint();
            }

        });

    }

    private void agregarEventos() {
        this.panelOpciones = new OpcionesAdminPanel(this);
        this.fab = new FabricacionPanel();
        this.registroProductos = new RegistroProductos();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelOpciones);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

        topPanel.setBackground(new java.awt.Color(0, 0, 0,0));
        topPanel.setForeground(new java.awt.Color(204, 204, 204));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });
        topPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_topPanelMouseDragged

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
            java.util.logging.Logger.getLogger(FrameMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMenuGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
