package login;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import clases.*;
import conexionBD.CarritoDAO;
import conexionBD.ClienteDAO;
import conexionBD.ProductoDAO;
import java.awt.Font;
import dashboard.MenuCliente;
import java.security.Principal;

public class LoginCliente extends javax.swing.JFrame {
    
    MenuCliente principal = new MenuCliente();
    
    private Plantillaentrar p1;
    public LoginCliente() {
        
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        title.requestFocusInWindow();
    }
    
    Cliente customer;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lblMsjNoHayCuenta = new javax.swing.JLabel();
        pnl_overlay = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        lblSlonga = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        favicon = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dniTxt = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        Text1 = new javax.swing.JPanel();
        Text2 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        lblRegistrarse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(0, 29, 50));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(500, 440));
        bg.setPreferredSize(new java.awt.Dimension(500, 440));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMsjNoHayCuenta.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblMsjNoHayCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblMsjNoHayCuenta.setText("¿No tiene una cuenta?");
        bg.add(lblMsjNoHayCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

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
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.jpeg"))); // NOI18N
        pnl_overlay.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 190));

        txtName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("TIENDA XXXXXXXXXXXX");
        pnl_overlay.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        lblSlonga.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
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
        pnl_overlay.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 26, 28));

        bg.add(pnl_overlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 470, 550));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        kGradientPanel1.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        title.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("INICIAR SESION");
        kGradientPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        dniLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        dniLabel.setForeground(new java.awt.Color(255, 255, 255));
        dniLabel.setText("DNI");
        kGradientPanel1.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 450, 10));

        passLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("CONTRASEÑA");
        kGradientPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 450, 10));

        dniTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        dniTxt.setForeground(new java.awt.Color(204, 204, 204));
        dniTxt.setText("Ingrese su dni");
        dniTxt.setAutoscrolls(false);
        dniTxt.setBorder(null);
        dniTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dniTxtMousePressed(evt);
            }
        });
        kGradientPanel1.add(dniTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 410, 30));

        passTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        kGradientPanel1.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 410, 30));

        Text1.setBackground(new java.awt.Color(255, 255, 255));
        Text1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Text1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Text1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Text1Layout = new javax.swing.GroupLayout(Text1);
        Text1.setLayout(Text1Layout);
        Text1Layout.setHorizontalGroup(
            Text1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Text1Layout.setVerticalGroup(
            Text1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        kGradientPanel1.add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 450, 30));

        Text2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Text2Layout = new javax.swing.GroupLayout(Text2);
        Text2.setLayout(Text2Layout);
        Text2Layout.setHorizontalGroup(
            Text2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        Text2Layout.setVerticalGroup(
            Text2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        kGradientPanel1.add(Text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        loginBtn.setBackground(new java.awt.Color(255, 255, 255));

        loginBtnTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
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
            .addGroup(loginBtnLayout.createSequentialGroup()
                .addComponent(loginBtnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        kGradientPanel1.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        lblRegistrarse.setBackground(new java.awt.Color(255, 0, 255));
        lblRegistrarse.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblRegistrarse.setForeground(new java.awt.Color(0, 204, 0));
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
        kGradientPanel1.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        bg.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(225,217,217));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        
        int dni = Integer.parseInt(dniTxt.getText());
        String password = String.valueOf(passTxt.getPassword());
        
        // Llamada al método de autenticación
        //boolean autenticado = autenticarCliente(dni, password);
        // Aquí llama al método de ClienteDAO para verificar las credenciales en la base de datos.
        // Devuelve true si las credenciales son válidas y false en caso contrario.
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.obtenerClientePorDNI(dni);
        
        principal.setCliente(cliente);
        
        if (cliente != null && cliente.getContraseña().equals(password)) {
            // Autenticación exitosa, abre la ventana principal o realiza las acciones necesarias
            this.setVisible(false);
            principal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                }
            });
            principal.setVisible(true);
        } else {
            // Credenciales incorrectas, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
                
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private boolean autenticarCliente(int dni, String password) {
        // Aquí llama al método de ClienteDAO para verificar las credenciales en la base de datos.
        // Devuelve true si las credenciales son válidas y false en caso contrario.
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = clienteDAO.obtenerClientePorDNI(dni);
        principal.setCliente(cliente);
        return cliente != null && cliente.getContraseña().equals(password);

    }
    
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
            dniTxt.setText("Ingrese su correo");
            dniTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void Text1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Text1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Text1MouseClicked

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
    private javax.swing.JPanel Text1;
    private javax.swing.JPanel Text2;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KGradientPanel kGradientPanel1;
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
    // End of variables declaration//GEN-END:variables
}
