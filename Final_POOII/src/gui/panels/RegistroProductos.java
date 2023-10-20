package gui.panels;

import clases.Producto;
import clases.command.AgregarCommand;
import clases.command.Command;
import clases.command.Constantes;
import clases.command.EliminarProductoCommand;
import clases.command.MostrarTablaCommand;
import conexionBD.ProductoDAO;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RegistroProductos extends javax.swing.JPanel {
    
    RegistroProductos app;
    public DefaultTableModel modelo = new DefaultTableModel();
    public int id;

    public RegistroProductos() {
        initComponents();
        Constantes.listarProductos(this);
    }
    private void executeCommand(Command command) {
        command.execute();

    }

    //********************************************************************************************



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        precioTxt = new javax.swing.JTextField();
        agregarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        limpiarDatosButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        stockTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        modeloTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        volverButton = new javax.swing.JButton();
        fondoRegProd = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, -1, -1));

        idTxt.setEditable(false);
        idTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idTxt.setBorder(null);
        jPanel1.add(idTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 22, 198, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 83, 73, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Precio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 181, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Stock");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 232, -1, -1));

        marcaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        marcaTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(marcaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 79, 198, 30));

        precioTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        precioTxt.setBorder(null);
        precioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTxtActionPerformed(evt);
            }
        });
        jPanel1.add(precioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 177, 198, 30));

        agregarButton.setText("Registrar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(agregarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 364, 89, -1));

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 364, 100, -1));

        limpiarDatosButton.setText("Limpiar");
        limpiarDatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarDatosButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limpiarDatosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 328, 97, -1));

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(modificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 364, -1, -1));
        jPanel1.add(stockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 232, 61, 46));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Modelo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 133, 63, -1));

        modeloTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modeloTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(modeloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 129, 198, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 46, 310, 400));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MARCA", "MODELO", "PRECIO", "STOCK"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 46, 515, 343));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 401, -1, 80));

        volverButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volverButton.setText("Volver");
        add(volverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 426, 133, 40));

        fondoRegProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoRegProd.png"))); // NOI18N
        add(fondoRegProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        app=this;
        executeCommand(new EliminarProductoCommand(app));
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void limpiarDatosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDatosButtonActionPerformed
        Constantes.limpiarComponentes(this);
    }//GEN-LAST:event_limpiarDatosButtonActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        app=this;
        executeCommand(new AgregarCommand(app));
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        app=this;
        executeCommand(new MostrarTablaCommand(app));
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        // TODO add your handling code here:
        //Con prog funcional
        String buscar = buscarTxt.getText();
        /*List<Cliente> clientesActuales = productoDAO.listar();
        List<Cliente> clientesEncontrados = clientesActuales.stream()
                .filter(cliente -> cliente.getNombre().contains(buscar))
                .collect(Collectors.toList());

        for (Cliente cliente : clientesActuales) {
            if (cliente.getNombre().contains(buscar)) {
                clientesEncontrados.add(cliente);
            }
        }
        limpiarTabla();
        if (!clientesEncontrados.isEmpty()) {

            modelo = (DefaultTableModel) tablaProductos.getModel();
            Object[] ob = new Object[5];
            clientesEncontrados.forEach(cliente -> {
                ob[0] = cliente.getId();
                ob[1] = cliente.getDNI();
                ob[2] = cliente.getNombre();
                ob[3] = cliente.getTelefono();
                ob[4] = cliente.getDireccion();
                modelo.addRow(ob);
            });
            tablaProductos.setModel(modelo);
        }*/
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void precioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTxtActionPerformed
    
    public JButton getVolverButton(){
        return volverButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel fondoRegProd;
    public javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarDatosButton;
    public javax.swing.JTextField marcaTxt;
    public javax.swing.JTextField modeloTxt;
    private javax.swing.JButton modificarButton;
    public javax.swing.JTextField precioTxt;
    public javax.swing.JTextField stockTxt;
    public javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
