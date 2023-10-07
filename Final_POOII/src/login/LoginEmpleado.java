package login;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class LoginEmpleado extends javax.swing.JFrame {
   
    public LoginEmpleado() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
   
        title.requestFocusInWindow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        dniTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        lblMsjNoHayCuenta = new javax.swing.JLabel();
        lblRegistrarse = new javax.swing.JLabel();

        setFocusable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(500, 440));
        bg.setPreferredSize(new java.awt.Dimension(500, 440));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        dniLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        dniLabel.setText("DNI");
        bg.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        dniTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        dniTxt.setForeground(new java.awt.Color(204, 204, 204));
        dniTxt.setText("Ingrese su dni");
        dniTxt.setBorder(null);
        dniTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dniTxtMousePressed(evt);
            }
        });
        dniTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniTxtActionPerformed(evt);
            }
        });
        bg.add(dniTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        passTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 410, 10));

        loginBtn.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));

        lblMsjNoHayCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMsjNoHayCuenta.setText("¿No tiene una cuenta?");
        bg.add(lblMsjNoHayCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));

        lblRegistrarse.setBackground(new java.awt.Color(0, 0, 255));
        lblRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegistrarse.setForeground(new java.awt.Color(0, 51, 255));
        lblRegistrarse.setText("Registrese");
        lblRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseExited(evt);
            }
        });
        bg.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(0,134,190));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void dniTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dniTxtMousePressed
        if (dniTxt.getText().equals("Ingrese su dni")) {
            dniTxt.setText("");
            dniTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_dniTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (dniTxt.getText().isEmpty()) {
            dniTxt.setText("Ingrese su dni");
            dniTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        
        JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso.");
                
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseClicked
        
        this.setVisible(false);
    }//GEN-LAST:event_lblRegistrarseMouseClicked

    private void dniTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniTxtActionPerformed

    private void lblRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseEntered
        // TODO add your handling code here:
        lblRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblRegistrarseMouseEntered

    private void lblRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseExited
        // TODO add your handling code here:
        lblRegistrarse.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_lblRegistrarseMouseExited

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
            java.util.logging.Logger.getLogger(LoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblMsjNoHayCuenta;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
