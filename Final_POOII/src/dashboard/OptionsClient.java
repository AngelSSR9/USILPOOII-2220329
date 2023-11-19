/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dashboard;

import clases.Cliente;
import conexionBD.ClienteDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


/**
 * Panel que muestra las opciones disponibles para un cliente, como ver y editar
 * información personal y revisar el estado de la cuenta.
 * Permite acceder a la edición de datos personales.
 */
public class OptionsClient extends javax.swing.JPanel {

    // Cliente asociado a este panel
    Cliente cliente;
    // Panel para la edición de datos del cliente
    EditarDatosCliente editarDatos = new EditarDatosCliente();
    
    /**
     * Constructor que inicializa los componentes del panel y muestra los datos del cliente.
     *
     * @param cliente Cliente para el cual se mostrarán las opciones.
     */
    public OptionsClient(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        mostrarDatos();
    }

    /**
     * Muestra los datos del cliente en el panel.
     */
    public final void mostrarDatos(){
        txtUsuario.setText(cliente.getNombre());
        txtCorreo.setText(cliente.getCorreo());
        txtDni.setText(Integer.toString(cliente.getDni()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        tittleInformacionPersonal = new javax.swing.JLabel();
        panelDatosPersonales = new javax.swing.JPanel();
        lblDatosPersonales = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JLabel();
        txtDni = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        PanelEstadoDeCuenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(204, 204, 0));
        setPreferredSize(new java.awt.Dimension(660, 440));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tittleInformacionPersonal.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        tittleInformacionPersonal.setForeground(new java.awt.Color(255, 255, 255));
        tittleInformacionPersonal.setText("MI INFORMACION PERSONAL");
        kGradientPanel1.add(tittleInformacionPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        panelDatosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        panelDatosPersonales.setForeground(new java.awt.Color(204, 204, 204));
        panelDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDatosPersonales.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        lblDatosPersonales.setForeground(new java.awt.Color(204, 0, 204));
        lblDatosPersonales.setText("DATOS PERSONALES");
        panelDatosPersonales.add(lblDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 0, 204));
        panelDatosPersonales.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, 30));

        txtCorreo.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(204, 0, 204));
        panelDatosPersonales.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 230, 40));

        txtDni.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        txtDni.setForeground(new java.awt.Color(204, 0, 204));
        panelDatosPersonales.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 240, 30));

        lblCorreo.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(153, 0, 153));
        lblCorreo.setText("Correo:");
        panelDatosPersonales.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(153, 0, 153));
        lblUsuario.setText("Usuario:");
        panelDatosPersonales.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblDni.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        lblDni.setForeground(new java.awt.Color(153, 0, 153));
        lblDni.setText("Dni:");
        panelDatosPersonales.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/lapizRosaEditaer.jpeg"))); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        panelDatosPersonales.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        kGradientPanel1.add(panelDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 790, 210));

        PanelEstadoDeCuenta.setBackground(new java.awt.Color(255, 255, 255));
        PanelEstadoDeCuenta.setForeground(new java.awt.Color(204, 204, 204));
        PanelEstadoDeCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboardimg/verificado.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 6, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setText("VERIFICADO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 180, 40));

        PanelEstadoDeCuenta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 540, 50));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 204));
        jLabel2.setText("ESTADO DE LA CUENTA");
        PanelEstadoDeCuenta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        kGradientPanel1.add(PanelEstadoDeCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 540, 120));

        add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 530));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada cuando se hace clic en el botón de editar.
     * Muestra la ventana de edición de datos personales.
     *
     * @param evt Evento del mouse.
     */
    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        
        JFrame popupFrame = new JFrame();
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editarDatos.setCliente(this.cliente);
        popupFrame.getContentPane().add(editarDatos);
        popupFrame.pack();
        popupFrame.setLocationRelativeTo(this); 
        popupFrame.setVisible(true);
    }//GEN-LAST:event_btnEditarMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEstadoDeCuenta;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JLabel tittleInformacionPersonal;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JLabel txtDni;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
