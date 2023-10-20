package login;



import clases.Cliente;
import clases.Constantes;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import clases.Constantes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

public class RegisterCliente extends javax.swing.JFrame {
    private LoginCliente login;


    public RegisterCliente() {
        
        initComponents();
        setLocationRelativeTo(null);
        agregarEventos();

        title.requestFocusInWindow();
    }
    
    private void agregarEventos() {
        
        nombreTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (nombreTxt.getText().isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }
                //System.out.println("Se ha insertado texto: " + dniRegistroTxt.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (nombreTxt.getText().isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        userTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (userTxt.getText().isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }
                //System.out.println("Se ha insertado texto: " + dniRegistroTxt.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField

                if (userTxt.getText().isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
        });

        passTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (String.valueOf(passTxt.getPassword()).isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se ejecuta cuando se elimina texto del JTextField
                if (String.valueOf(passTxt.getPassword()).isEmpty()) {
                    registerBtn.setEnabled(false);
                } else {
                    if (!hayCampoVacio()) {
                        registerBtn.setEnabled(true);
                    }
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se ejecuta cuando se cambia el estilo del texto (p. ej., formato de fuente)
            }
            
        });
       
    }
    
    private boolean hayCampoVacio() {
        String nombre = nombreTxt.getText();
        String usuario = userTxt.getText();
        String password = String.valueOf(passTxt.getPassword());

        return nombre.isEmpty() || usuario.isEmpty() || password.isEmpty();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        favicon = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
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
        Text1 = new javax.swing.JPanel();
        Text2 = new javax.swing.JPanel();
        Text3 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        lblSlonga = new javax.swing.JLabel();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(500, 440));
        bg.setPreferredSize(new java.awt.Dimension(500, 440));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imgLogo.setForeground(new java.awt.Color(255, 255, 255));
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo.jpeg"))); // NOI18N
        bg.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 190));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        kGradientPanel1.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 60));

        userLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("CORREO");
        kGradientPanel1.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        userTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su correo");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        kGradientPanel1.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 410, 20));

        passLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("CONTRASEÑA");
        kGradientPanel1.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        passTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        kGradientPanel1.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 410, 20));

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

        kGradientPanel1.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 130, 40));

        nombreLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(255, 255, 255));
        nombreLabel.setText("USUARIO");
        kGradientPanel1.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(204, 204, 204));
        nombreTxt.setText("Ingrese su usuario");
        nombreTxt.setBorder(null);
        nombreTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nombreTxtMousePressed(evt);
            }
        });
        nombreTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTxtActionPerformed(evt);
            }
        });
        kGradientPanel1.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 410, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        kGradientPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 410, 20));

        title.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("REGISTRESE");
        kGradientPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

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

        kGradientPanel1.add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 430, 30));

        Text2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Text2Layout = new javax.swing.GroupLayout(Text2);
        Text2.setLayout(Text2Layout);
        Text2Layout.setHorizontalGroup(
            Text2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        Text2Layout.setVerticalGroup(
            Text2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        kGradientPanel1.add(Text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 430, -1));

        Text3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Text3Layout = new javax.swing.GroupLayout(Text3);
        Text3.setLayout(Text3Layout);
        Text3Layout.setHorizontalGroup(
            Text3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        Text3Layout.setVerticalGroup(
            Text3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        kGradientPanel1.add(Text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        bg.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 500, 510));

        txtName.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("TIENDA XXXXXXXXXXXX");
        bg.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        lblSlonga.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblSlonga.setForeground(new java.awt.Color(102, 102, 102));
        lblSlonga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlonga.setText("La tienda que vende algo xd");
        lblSlonga.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bg.add(lblSlonga, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 252, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su correo")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void nombreTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreTxtMousePressed
        if (nombreTxt.getText().equals("Ingrese su usuario")) {
            nombreTxt.setText("");
            nombreTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_nombreTxtMousePressed

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void registerBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseExited
        registerBtn.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_registerBtnTxtMouseExited

    private void registerBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseEntered
        registerBtn.setBackground(new Color(225,217,217));
    }//GEN-LAST:event_registerBtnTxtMouseEntered

    private void registerBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseClicked
        if (!esDireccionDeCorreoValida(userTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una dirección de correo electrónico válida.");
            return;
        }
        
        
        //String verificationToken = UUID.randomUUID().toString();
        //Se crea la clase propiedades para luego configurarlo
        Properties properties = new Properties();
        
        // Configuración del servidor de correo
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        // Autenticación
        /*
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pruebamonitor7@gmail.com", "togj fhkc imxh wldz");
            }
        };
        */
        //Se crea una session en la que se pasan las propiedades configuradas
        Session session = Session.getDefaultInstance(properties);
        // Creación y envío del correo
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pruebamonitor7@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(userTxt.getText()));
            message.setSubject("Correo de bienvenida ");
            message.setText("Bienvenido a la tienda Nose el nombre","ISO-8859-1","html");
            
            // Crear el contenido HTML como un String
            String htmlContent = "<html><body>";
            htmlContent += "<p>Bienvenido a la tienda Nose el nombre</p>";
            htmlContent += "<img src='cid:imagen123'>"; // La imagen se referencia por CID
            htmlContent += "</body></html>";
            
            // Creamos un cuerpo multipart para incluir texto HTML y la imagen
            MimeMultipart multipart = new MimeMultipart("related");
            //Es una de las partes del multipart
            MimeBodyPart htmlPart = new MimeBodyPart();
            //Se coloca el contenido del correo
            htmlPart.setContent(htmlContent,"text/html" );
            //se agrega al multipart
            multipart.addBodyPart(htmlPart);
            
            // Creamos la parte de la imagen
            MimeBodyPart imagePart = new MimeBodyPart();
            
            // Carga la imagen desde el paquete "img"
            InputStream imgStream = getClass().getResourceAsStream("/img/imgNewProduct.png");
            
            //Convertir a bytes la imagen
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = imgStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = byteArrayOutputStream.toByteArray();
            
            //se crea un datahandler, que sirva para gstionar el contenido de la imagen, esta imagen debe de estar en bytes, luego se coloca en la imagen
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(imageBytes, "image/png")));
            imagePart.setHeader("Content-ID", "<imagen123>"); // Coincide con el CID en el contenido HTML
            
            //se agrega otra parte al multipart
            multipart.addBodyPart(imagePart);
            
            // se Establece el contenido del mensaje
            message.setContent(multipart);

            
            //logica para enviar mensaje
            Transport mTransport = session.getTransport("smtp");
            mTransport.connect("pruebamonitor7@gmail.com", "togj fhkc imxh wldz");
            mTransport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "Gracias por registrarse");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

    }//GEN-LAST:event_registerBtnTxtMouseClicked

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void Text1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Text1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Text1MouseClicked

    private boolean esDireccionDeCorreoValida(String direccionCorreo) {
        // Utiliza una expresión regular simple para validar la dirección de correo.
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return direccionCorreo.matches(regex);
    }
    
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
            public void run() {
                new RegisterCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Text1;
    private javax.swing.JPanel Text2;
    private javax.swing.JPanel Text3;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel favicon;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblSlonga;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPanel registerBtn;
    private javax.swing.JLabel registerBtnTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
