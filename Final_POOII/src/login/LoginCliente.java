package login;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import clases.Cliente;
import conexionBD.ClienteDAO;
import dashboard.NewMenuCliente;
/**
 * Clase que representa la ventana de inicio de sesión para clientes.
 */
public class LoginCliente extends javax.swing.JFrame {
    
    // Instancias de clases
    public NewMenuCliente menuPrincipal = new NewMenuCliente();
    Autenticacion autenticacion = new Autenticacion();
    RegisterCliente registerCliente = new RegisterCliente();
    Validacion validacion = new Validacion();
    /**
     * Constructor de la clase LoginCliente.
     */
    public LoginCliente() {
        
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        title.requestFocusInWindow();
        setResizable(false); //Evita que el usuario modifque el tamaño
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lblMsjNoHayCuenta = new javax.swing.JLabel();
        backgroundImg = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        lblSlonga = new javax.swing.JLabel();
        PanelLogin = new keeptoo.KGradientPanel();
        title = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dniTxt = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        lblRegistrarse = new javax.swing.JLabel();
        dniTxtPanel = new diseño.RoundedPanel();
        passTxtPanel = new diseño.RoundedPanel();
        loginBtn = new diseño.RoundedPanel();
        loginBtnTxt = new javax.swing.JLabel();

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

        backgroundImg.setBackground(new java.awt.Color(255, 255, 255));
        backgroundImg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imgLogo.setForeground(new java.awt.Color(255, 255, 255));
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.jpeg"))); // NOI18N
        backgroundImg.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, 190));

        txtName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("TIENDA XXXXXXXXXXXX");
        backgroundImg.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        lblSlonga.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblSlonga.setForeground(new java.awt.Color(102, 102, 102));
        lblSlonga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlonga.setText("La tienda que vende algo xd");
        lblSlonga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backgroundImg.add(lblSlonga, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 252, 20));

        bg.add(backgroundImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 470, 550));

        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("INICIAR SESION");
        PanelLogin.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        dniLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        dniLabel.setForeground(new java.awt.Color(255, 255, 255));
        dniLabel.setText("DNI");
        PanelLogin.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        PanelLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 450, 10));

        passLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("CONTRASEÑA");
        PanelLogin.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        PanelLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 450, 10));

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
        PanelLogin.add(dniTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 410, 30));

        passTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        PanelLogin.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 410, 30));

        lblRegistrarse.setBackground(new java.awt.Color(255, 0, 255));
        lblRegistrarse.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblRegistrarse.setForeground(new java.awt.Color(0, 204, 0));
        lblRegistrarse.setText("Registrese");
        lblRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarseMouseClicked(evt);
            }
        });
        PanelLogin.add(lblRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        dniTxtPanel.setBackground(new java.awt.Color(255, 255, 255));
        dniTxtPanel.setRoundBottomLeft(15);
        dniTxtPanel.setRoundBottomRight(15);
        dniTxtPanel.setRoundTopLeft(15);
        dniTxtPanel.setRoundTopRight(15);

        javax.swing.GroupLayout dniTxtPanelLayout = new javax.swing.GroupLayout(dniTxtPanel);
        dniTxtPanel.setLayout(dniTxtPanelLayout);
        dniTxtPanelLayout.setHorizontalGroup(
            dniTxtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        dniTxtPanelLayout.setVerticalGroup(
            dniTxtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelLogin.add(dniTxtPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 450, 30));

        passTxtPanel.setBackground(new java.awt.Color(255, 255, 255));
        passTxtPanel.setRoundBottomLeft(15);
        passTxtPanel.setRoundBottomRight(15);
        passTxtPanel.setRoundTopLeft(15);
        passTxtPanel.setRoundTopRight(15);

        javax.swing.GroupLayout passTxtPanelLayout = new javax.swing.GroupLayout(passTxtPanel);
        passTxtPanel.setLayout(passTxtPanelLayout);
        passTxtPanelLayout.setHorizontalGroup(
            passTxtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        passTxtPanelLayout.setVerticalGroup(
            passTxtPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelLogin.add(passTxtPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        loginBtn.setBackground(new java.awt.Color(255, 255, 255));
        loginBtn.setRoundBottomLeft(15);
        loginBtn.setRoundBottomRight(15);
        loginBtn.setRoundTopLeft(15);
        loginBtn.setRoundTopRight(15);

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
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        PanelLogin.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 100, 50));

        bg.add(PanelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 550));

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

    /**
     * Cambia el color del boton del mouse al pasar sobre este
     * @param evt 
     */
    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(225,217,217));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    /**
     * Cambia el color del boton del mouses al pasar sobre este
     * @param evt 
     */
    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_loginBtnTxtMouseExited

    /**
     * Método que se ejecuta cuando se hace clic en el botón de inicio de sesión.
     * @param evt Evento de ratón asociado al clic.
     */
    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        
        String dniTexto = dniTxt.getText();
        String password = String.valueOf(passTxt.getPassword());
        
        // Validación de campos
        if(!validacion.validarIngreso(dniTexto, password)){
            return;
        }
        int dni = Integer.parseInt(dniTxt.getText());
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.obtenerClientePorDNI(dni);
        
        // Llama al método de autenticación
        if (!autenticacion.autenticarCliente(dni, password, cliente)) {
            return; // Detiene la ejecución si la validación no es exitosa
        }
        else{
            menuPrincipal.setCliente(cliente);
            this.setVisible(false);
            menuPrincipal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                }
            });
            menuPrincipal.setVisible(true);
        }           
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    
    /**
     * hace visible el Register si no cuenta con una cuenta
     * @param evt 
     */
    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarseMouseClicked
        registerCliente.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                setVisible(true);
            }
        });
        registerCliente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblRegistrarseMouseClicked

    /**
     * Cambia el texto "Ingrese su dni" al hacer click para ingresar el dni.
     * @param evt El evento del mouse.
    */
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

    /**
     * Cambia el texto "********" al hacer click para ingresar la contraseña.
     * @param evt El evento del mouse.
    */
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
    private keeptoo.KGradientPanel PanelLogin;
    private javax.swing.JPanel backgroundImg;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dniLabel;
    public javax.swing.JTextField dniTxt;
    private diseño.RoundedPanel dniTxtPanel;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblMsjNoHayCuenta;
    private javax.swing.JLabel lblRegistrarse;
    private javax.swing.JLabel lblSlonga;
    private diseño.RoundedPanel loginBtn;
    public javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel passLabel;
    public javax.swing.JPasswordField passTxt;
    private diseño.RoundedPanel passTxtPanel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
