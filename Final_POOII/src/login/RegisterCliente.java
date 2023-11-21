package login;

import java.awt.Color;
import javax.swing.JOptionPane;
import conexionBD.ClienteDAO;

/**
 * La clase RegisterCliente representa la interfaz de registro de clientes.
 * Permite a los usuarios ingresar sus datos para crear una cuenta en la tienda.
 */

public class RegisterCliente extends javax.swing.JFrame {
    private LoginCliente login;
    Validacion validacion = new Validacion();

    /**
     * Constructor de la clase RegisterCliente. Inicializa los componentes de la interfaz.
    */
    public RegisterCliente() {
        
        initComponents();
        setLocationRelativeTo(null);
        title.requestFocusInWindow();
        setResizable(false); //Evita que el usuario modifque el tamaño
    }
    
    /**
     * Inicializa y configura los componentes de la interfaz.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        RegisterPanel = new keeptoo.KGradientPanel();
        correoLabel = new javax.swing.JLabel();
        correoTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        registerBtn = new javax.swing.JPanel();
        registerBtnTxt = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        dniTxt = new javax.swing.JTextField();
        dniLabel = new javax.swing.JLabel();
        bgUser = new diseño.RoundedPanel();
        bgCorreo = new diseño.RoundedPanel();
        bgDni = new diseño.RoundedPanel();
        bgPass = new diseño.RoundedPanel();
        txtName = new javax.swing.JLabel();
        lblSlongan = new javax.swing.JLabel();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        background.setMinimumSize(new java.awt.Dimension(500, 440));
        background.setPreferredSize(new java.awt.Dimension(500, 440));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imgLogo.setForeground(new java.awt.Color(255, 255, 255));
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.jpeg"))); // NOI18N
        background.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 190));

        RegisterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        correoLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        correoLabel.setForeground(new java.awt.Color(255, 255, 255));
        correoLabel.setText("CORREO");
        RegisterPanel.add(correoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        correoTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        correoTxt.setForeground(new java.awt.Color(204, 204, 204));
        correoTxt.setText("Ingrese su correo");
        correoTxt.setBorder(null);
        correoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                correoTxtMousePressed(evt);
            }
        });
        RegisterPanel.add(correoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        RegisterPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 410, 20));

        passLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("CONTRASEÑA");
        RegisterPanel.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        passTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        RegisterPanel.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        RegisterPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 410, 20));

        registerBtn.setBackground(new java.awt.Color(255, 255, 255));

        registerBtnTxt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerBtnTxt.setForeground(new java.awt.Color(0, 0, 0));
        registerBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerBtnTxt.setText("REGISTRAR");
        registerBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registerBtnLayout = new javax.swing.GroupLayout(registerBtn);
        registerBtn.setLayout(registerBtnLayout);
        registerBtnLayout.setHorizontalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        registerBtnLayout.setVerticalGroup(
            registerBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBtnTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        RegisterPanel.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 130, 40));

        nombreLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreLabel.setText("USUARIO");
        RegisterPanel.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(204, 204, 204));
        nombreTxt.setText("Ingrese su usuario");
        nombreTxt.setBorder(null);
        nombreTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nombreTxtMousePressed(evt);
            }
        });
        RegisterPanel.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 410, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        RegisterPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 410, 20));

        title.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("REGISTRESE");
        RegisterPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        RegisterPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 20));

        dniTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        dniTxt.setForeground(new java.awt.Color(204, 204, 204));
        dniTxt.setText("Ingrese su dni");
        dniTxt.setBorder(null);
        dniTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dniTxtMousePressed(evt);
            }
        });
        RegisterPanel.add(dniTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 410, 30));

        dniLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        dniLabel.setForeground(new java.awt.Color(255, 255, 255));
        dniLabel.setText("DNI");
        RegisterPanel.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        bgUser.setBackground(new java.awt.Color(255, 255, 255));
        bgUser.setRoundBottomLeft(15);
        bgUser.setRoundBottomRight(15);
        bgUser.setRoundTopLeft(15);
        bgUser.setRoundTopRight(15);

        javax.swing.GroupLayout bgUserLayout = new javax.swing.GroupLayout(bgUser);
        bgUser.setLayout(bgUserLayout);
        bgUserLayout.setHorizontalGroup(
            bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        bgUserLayout.setVerticalGroup(
            bgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        RegisterPanel.add(bgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 430, 30));

        bgCorreo.setBackground(new java.awt.Color(255, 255, 255));
        bgCorreo.setRoundBottomLeft(15);
        bgCorreo.setRoundBottomRight(15);
        bgCorreo.setRoundTopLeft(15);
        bgCorreo.setRoundTopRight(15);

        javax.swing.GroupLayout bgCorreoLayout = new javax.swing.GroupLayout(bgCorreo);
        bgCorreo.setLayout(bgCorreoLayout);
        bgCorreoLayout.setHorizontalGroup(
            bgCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        bgCorreoLayout.setVerticalGroup(
            bgCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        RegisterPanel.add(bgCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        bgDni.setBackground(new java.awt.Color(255, 255, 255));
        bgDni.setRoundBottomLeft(15);
        bgDni.setRoundBottomRight(15);
        bgDni.setRoundTopLeft(15);
        bgDni.setRoundTopRight(15);

        javax.swing.GroupLayout bgDniLayout = new javax.swing.GroupLayout(bgDni);
        bgDni.setLayout(bgDniLayout);
        bgDniLayout.setHorizontalGroup(
            bgDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        bgDniLayout.setVerticalGroup(
            bgDniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        RegisterPanel.add(bgDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        bgPass.setBackground(new java.awt.Color(255, 255, 255));
        bgPass.setRoundBottomLeft(15);
        bgPass.setRoundBottomRight(15);
        bgPass.setRoundTopLeft(15);
        bgPass.setRoundTopRight(15);

        javax.swing.GroupLayout bgPassLayout = new javax.swing.GroupLayout(bgPass);
        bgPass.setLayout(bgPassLayout);
        bgPassLayout.setHorizontalGroup(
            bgPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        bgPassLayout.setVerticalGroup(
            bgPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        RegisterPanel.add(bgPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        background.add(RegisterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 500, 510));

        txtName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("TIENDA XXXXXXXXXXXX");
        background.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        lblSlongan.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblSlongan.setForeground(new java.awt.Color(102, 102, 102));
        lblSlongan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlongan.setText("La tienda que vende algo xd");
        lblSlongan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        background.add(lblSlongan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 252, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cambia el texto "Ingrese correo" al hacer click para ingresar correo.
     * @param evt El evento del mouse.
    */
    private void correoTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoTxtMousePressed
        if (correoTxt.getText().equals("Ingrese su correo")) {
            correoTxt.setText("");
            correoTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_correoTxtMousePressed

    /**
     * Cambia el texto "********" al hacer click para ingresar contraseña.
     * @param evt El evento del mouse.
    */
    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_passTxtMousePressed

    /**
     * Cambia el texto "Ingrese su usuario" al hacer click para ingresar el usuario.
     * @param evt El evento del mouse.
    */
    private void nombreTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreTxtMousePressed
        if (nombreTxt.getText().equals("Ingrese su usuario")) {
            nombreTxt.setText("");
            nombreTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_nombreTxtMousePressed

    /**
     * Cambia el color del boton al pasar el mouse.
     * @param evt El evento del mouse.
    */
    private void registerBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseExited
        registerBtn.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_registerBtnTxtMouseExited

    /**
     * Cambia el color del boton al pasar el mouse.
     * @param evt El evento del mouse.
    */
    private void registerBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseEntered
        registerBtn.setBackground(new Color(225,217,217));
    }//GEN-LAST:event_registerBtnTxtMouseEntered

    /**
     * Método invocado cuando se presiona el botón de registro.
     * Recopila los datos de la interfaz y realiza la validación antes de agregar el cliente.
     * @param evt El evento del mouse.
     */
    private void registerBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseClicked
        
        String usuario = nombreTxt.getText();
        String correo = correoTxt.getText();
        String contraseña = new String(passTxt.getPassword()); 
        String dni = dniTxt.getText();
        
        // Llama al método de validación
        if (!validacion.validarRegistro(usuario, correo, contraseña, dni)) {
            return; // Detiene la ejecución si la validación no es exitosa
        }
        
        ClienteDAO clienteDAO = new ClienteDAO();
        Object[] o = new Object[5];
        try {
            o[0] = usuario;
            o[1] = correo;
            o[2] = contraseña;
            o[3] = Integer.parseInt(dni);
            o[4] = true;
            
                clienteDAO.agregar(o);
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
        }
    }//GEN-LAST:event_registerBtnTxtMouseClicked

    
    /**
     * Cambia el texto "Ingrese su dni" al hacer click para ingresar el dni.
     * @param evt El evento del mouse.
    */
    private void dniTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dniTxtMousePressed
        if (dniTxt.getText().equals("Ingrese su dni")) {
            dniTxt.setText("");
            dniTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_dniTxtMousePressed

    /**
     * Ocultar y mostrar el Login
     * @param evt 
     */
    private void lblRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {                                            
        this.setVisible(false); // Oculta la ventana de registro
         // Muestra la ventana de inicio de sesión
    }    
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
            java.util.logging.Logger.getLogger(RegisterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            @Override
            public void run() {
                new RegisterCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel RegisterPanel;
    private javax.swing.JPanel background;
    private diseño.RoundedPanel bgCorreo;
    private diseño.RoundedPanel bgDni;
    private diseño.RoundedPanel bgPass;
    private diseño.RoundedPanel bgUser;
    private javax.swing.JLabel correoLabel;
    private javax.swing.JTextField correoTxt;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblSlongan;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPanel registerBtn;
    private javax.swing.JLabel registerBtnTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
