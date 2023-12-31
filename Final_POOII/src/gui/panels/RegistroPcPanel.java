/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panels;

import clases.PC;
import clases.Producto;
import conexionBD.DetallesPcDAO;
import conexionBD.PcDAO;
import conexionBD.ProductoDAO;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author henry
 */
public class RegistroPcPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistroPanelPanel
     */
    ProductoDAO productoDAO = new ProductoDAO();
    PcDAO pcDAO = new PcDAO();
    DetallesPcDAO detallesPcDAO = new DetallesPcDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter;
    
    public RegistroPcPanel() {
        initComponents();
        listarProductos();
    }
    
    /**
     * Lista los PC en tabla modelo
     */
    private void listarProductos() {
        List<PC> lista = pcDAO.listar();
        System.out.println(lista.size());
        modelo = (DefaultTableModel) tablaPc.getModel();
        Object[] ob = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getStock();
            
            modelo.addRow(ob);
        }
        //establecen los modelos de tablas en tablaPc
        tablaPc.setModel(modelo);
        tablaPc.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tablaPc.setRowSorter(sorter);
    }
    
    /**
     * Filtra las fiilas segun lo escrito en buscarTxt.
     */
    private void buscar() {
        try {
            String textoBusqueda = buscarTxt.getText().toLowerCase(); // Convertir a minúsculas


                // ignora caracteres especiales para no afectar la busqueda e ignora que sea mayuscula y minuscula
                RowFilter<Object, Object> filtro = RowFilter.regexFilter("(?i)" + Pattern.quote(textoBusqueda));
                //filtra las coincidencias
                sorter.setRowFilter(filtro);

        } catch (Exception e) {
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPc = new javax.swing.JTable();
        txtStock = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPc);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 620, 303));

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 78, 53));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 110, 54));

        btnStock.setText("Cambiar Stock");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });
        add(btnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 110, 54));

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, 55));
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablaPc.getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt(tablaPc.getValueAt(fila, 0).toString());
            pcDAO.eliminar(id);
            detallesPcDAO.eliminarDetallesPc(id);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        // TODO add your handling code here:
        int fila = tablaPc.getSelectedRow();// indice de la fila seleccionada
        
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        }else{
            
            if(!txtStock.getText().matches(".[^\\d.].")){
                    if(!txtStock.getText().isEmpty()){
                    int id = Integer.parseInt(tablaPc.getValueAt(fila, 0).toString()); //recoge el id de la tabla

                    final int stockAct = Integer.parseInt(txtStock.getText());  //recoge el valor del stock a aumentar

                    //crea lista con los elementos del pc para comprobar que todos los elementos existan
                    List<Integer> prodPcList = detallesPcDAO.obtenerDetallesPorId(id).stream()
                        .map(Producto::getId)
                        .collect(Collectors.toList());
                    boolean todosLosProductosExisten = prodPcList.stream().allMatch(i->productoDAO.comprobarProducto(i));//verificar si todos existen

                    if(todosLosProductosExisten){
                        //se verifica que todos los elementos que componen la pc tengan suficiente stock
                        boolean prolst = detallesPcDAO.obtenerDetallesPorId(id).stream().allMatch(det->det.getStock()>=stockAct);

                        if(prolst){

                            int stk= pcDAO.obtenerPcPorId(id).getStock();// stock que se solicitó
                            pcDAO.actualizarStock(id, stk+stockAct); //actualiza el stock del pc

                            List<Producto> idListProd = detallesPcDAO.obtenerDetallesPorId(id);
                            for(Producto i : idListProd){
                                productoDAO.actualizarStock(i.getId(), i.getStock()-stockAct);//actualiza el stock de los productos empleados
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "No el stock de alguno de sus elemento no es suficiente");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "No existe alguno(s) de los elementos que lo componian");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Determina el stock");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnStockActionPerformed

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        
        buscar();
    }//GEN-LAST:event_buscarTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnStock;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPc;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
