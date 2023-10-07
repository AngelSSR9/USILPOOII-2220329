package login;



import newpackage.Cliente;
import newpackage.Constantes;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import newpackage.Constantes;

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

        dniTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (!Constantes.esDniValido(dniTxt)) {
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

                if (!Constantes.esDniValido(dniTxt)) {
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

        telephoneTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se ejecuta cuando se inserta texto en el JTextField
                if (!Constantes.esTelefonoValido(telephoneTxt)) {
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

                if (!Constantes.esTelefonoValido(telephoneTxt)) {
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
        String dni = dniTxt.getText();
        String telefono = telephoneTxt.getText();
        String usuario = userTxt.getText();
        String password = String.valueOf(passTxt.getPassword());

        return nombre.isEmpty() || dni.isEmpty() || telefono.isEmpty() || usuario.isEmpty() || password.isEmpty();

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
        registerBtn = new javax.swing.JPanel();
        registerBtnTxt = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        telephoneTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        dniLabel = new javax.swing.JLabel();
        dniTxt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        nombreLabel = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setMinimumSize(new java.awt.Dimension(500, 440));
        bg.setPreferredSize(new java.awt.Dimension(500, 440));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        favicon.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 60));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("REGISTRESE");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su nombre de usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 410, 20));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        passTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 410, 20));

        registerBtn.setBackground(new java.awt.Color(0, 134, 190));

        registerBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        registerBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
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

        bg.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 130, 40));

        telefonLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        telefonLabel.setText("TELEFONO");
        bg.add(telefonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        telephoneTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        telephoneTxt.setForeground(new java.awt.Color(204, 204, 204));
        telephoneTxt.setText("Ingrese su telefono");
        telephoneTxt.setBorder(null);
        telephoneTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                telephoneTxtMousePressed(evt);
            }
        });
        bg.add(telephoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 410, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 410, 20));

        dniLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        dniLabel.setText("DNI");
        bg.add(dniLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        dniTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        dniTxt.setForeground(new java.awt.Color(204, 204, 204));
        dniTxt.setText("Ingrese su dni");
        dniTxt.setBorder(null);
        dniTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dniTxtMousePressed(evt);
            }
        });
        bg.add(dniTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 410, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 410, 20));

        nombreLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        nombreLabel.setText("NOMBRE");
        bg.add(nombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        nombreTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreTxt.setForeground(new java.awt.Color(204, 204, 204));
        nombreTxt.setText("Ingrese su nombre");
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
        bg.add(nombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 410, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 410, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su nombre de usuario")) {
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

    private void telephoneTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telephoneTxtMousePressed
        if (telephoneTxt.getText().equals("Ingrese su telefono")) {
            telephoneTxt.setText("");
            telephoneTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_telephoneTxtMousePressed

    private void dniTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dniTxtMousePressed
        if (dniTxt.getText().equals("Ingrese su dni")) {
            dniTxt.setText("");
            dniTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_dniTxtMousePressed

    private void nombreTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreTxtMousePressed
        if (nombreTxt.getText().equals("Ingrese su nombre")) {
            nombreTxt.setText("");
            nombreTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_nombreTxtMousePressed

    private void nombreTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTxtActionPerformed

    private void registerBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseExited
        registerBtn.setBackground(new Color(0,134,190));
    }//GEN-LAST:event_registerBtnTxtMouseExited

    private void registerBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseEntered
        registerBtn.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_registerBtnTxtMouseEntered

    private void registerBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnTxtMouseClicked
        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.\nPor favor inicie sesión para continuar.");

    }//GEN-LAST:event_registerBtnTxtMouseClicked

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
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTxt;
    private javax.swing.JLabel favicon;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPanel registerBtn;
    private javax.swing.JLabel registerBtnTxt;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JTextField telephoneTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
