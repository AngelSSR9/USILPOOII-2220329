package login;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import newpackage.*;

public class LoginCliente extends javax.swing.JFrame {
    
    private Plantillaentrar p1;
    public LoginCliente() {
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
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        lblMsjNoHayCuenta = new javax.swing.JLabel();
        lblRegistrarse = new javax.swing.JLabel();
        pnl_overlay = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        lblSlonga = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(0, 204, 204));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(500, 440));
        bg.setPreferredSize(new java.awt.Dimension(500, 440));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        userTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 410, 20));

        passLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        passTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 410, 10));

        loginBtn.setBackground(new java.awt.Color(0, 134, 190));

        loginBtnTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));

        lblMsjNoHayCuenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMsjNoHayCuenta.setText("¿No tiene una cuenta?");
        bg.add(lblMsjNoHayCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, -1, -1));

        lblRegistrarse.setBackground(new java.awt.Color(0, 0, 255));
        lblRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        bg.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        pnl_overlay.setBackground(new java.awt.Color(255, 255, 255));
        pnl_overlay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_overlayMouseDragged(evt);
            }
        });
        pnl_overlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_overlayMousePressed(evt);
            }
        });
        pnl_overlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imgLogo.setForeground(new java.awt.Color(255, 255, 255));
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swingg_dribble/images/Logo.jpeg"))); // NOI18N
        pnl_overlay.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, 190));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("TIENDA XXXXXXXXXXXX");
        pnl_overlay.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        lblSlonga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSlonga.setForeground(new java.awt.Color(102, 102, 102));
        lblSlonga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlonga.setText("La tienda que vende algo xd");
        lblSlonga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnl_overlay.add(lblSlonga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 252, 20));

        exit.setBackground(new java.awt.Color(231, 73, 134));
        exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(231, 73, 134));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        pnl_overlay.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 0, 26, 28));

        bg.add(pnl_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 450, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
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

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        
        String user = userTxt.getText();
        String password = String.valueOf(passTxt.getPassword());
        
        
        this.setVisible(false);
        Plantillaentrar plantilla = new Plantillaentrar();
        plantilla.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                setVisible(true);
            }
        });
        plantilla.setVisible(true);
                
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseClicked
        RegisterCliente regCli = new RegisterCliente();
        regCli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                setVisible(true);
            }
        });
        regCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRegistrarseMouseClicked

    private void lblRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseEntered
        // TODO add your handling code here:
        lblRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblRegistrarseMouseEntered

    private void lblRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseExited
        // TODO add your handling code here:
        lblRegistrarse.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_lblRegistrarseMouseExited

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void pnl_overlayMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_overlayMouseDragged
        // TODO add your handling code here:int x = evt.getXOnScreen();

    }//GEN-LAST:event_pnl_overlayMouseDragged

    private void pnl_overlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_overlayMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_pnl_overlayMousePressed

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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblMsjNoHayCuenta;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JLabel lblSlonga;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPanel pnl_overlay;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
