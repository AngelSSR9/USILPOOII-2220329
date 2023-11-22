/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panels;

import clases.Constantes;
import clases.Producto;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import conexionBD.ProductoDAO;
import java.util.List;

/**
 *
 * @author henry
 */
public class AgregarProductoPanel extends javax.swing.JPanel {

    public DefaultTableModel modelo = new DefaultTableModel();
    public int id;
    ProductoDAO productoDAO = new ProductoDAO();
    String path;

    /**
     * Creates new form RegistrarProductoPanel
     */
    public AgregarProductoPanel() {
        initComponents();
    }
    /**
     * 
     * @return devuelve true si se cambis la BD existosamente
     * en caso contrario devuelve false
     */
    private boolean agregarProductoBD() {
        Object[] o = new Object[8];
        String marca = marcaTxt.getText();
        String modelo = modeloTxt.getText();
        String precio = precioTxt.getText();
        String stock = stockTxt.getText();
        String categoria = (String) catCombo.getSelectedItem();
        String tipo = (String)boxTipo.getSelectedItem();
        String rutaImagen = imagenTxt.getText();
        String descripcion = mDescription.getText();

        //String direccion = direccionTxt.getText();
        try {

            o[0] = marca;
            o[1] = modelo;
            o[2] = Double.parseDouble(precio);
            o[3] = Integer.parseInt(stock);
            o[4] = categoria;
            o[5] = tipo;
            o[6] = rutaImagen;
            o[7] = descripcion;

            productoDAO.agregar(o);

            return true;
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            return false;
        }
    }
    /**
     * Limpia los compenente si se cambio la BD
     */
    public void agregarProducto() {
        boolean confirm = agregarProductoBD();
        if (confirm) {
            Constantes.limpiarPanel(updatePanel);
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

        updatePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        modeloTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        stockTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        imagenTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        catCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        mDescription = new javax.swing.JTextArea();
        selectedPhoto = new javax.swing.JLabel();
        photoSelection = new javax.swing.JButton();
        precioTxt = new javax.swing.JTextField();
        LogInButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        boxTipo = new javax.swing.JComboBox<>();

        updatePanel.setBackground(new java.awt.Color(255, 255, 255));
        updatePanel.setPreferredSize(new java.awt.Dimension(853, 496));
        updatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 77, 64));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Product Details");
        updatePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 740, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 77, 64));
        jSeparator1.setForeground(new java.awt.Color(0, 77, 64));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 1));
        updatePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 200, 3));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 77, 64));
        jLabel4.setText("Brand:");
        updatePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 80, -1));

        marcaTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        marcaTxt.setForeground(new java.awt.Color(0, 77, 64));
        marcaTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));
        marcaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaTxtActionPerformed(evt);
            }
        });
        updatePanel.add(marcaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 362, -1));

        modeloTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        modeloTxt.setForeground(new java.awt.Color(0, 77, 64));
        modeloTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));
        modeloTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloTxtActionPerformed(evt);
            }
        });
        updatePanel.add(modeloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 362, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 77, 64));
        jLabel5.setText("Model:");
        updatePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 80, -1));

        stockTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stockTxt.setForeground(new java.awt.Color(0, 77, 64));
        stockTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));
        stockTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTxtActionPerformed(evt);
            }
        });
        updatePanel.add(stockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 110, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 77, 64));
        jLabel6.setText("Category:");
        updatePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 80, -1));

        imagenTxt.setEditable(false);
        imagenTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        imagenTxt.setForeground(new java.awt.Color(0, 77, 64));
        imagenTxt.setText("Choose photo:");
        imagenTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));
        imagenTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenTxtActionPerformed(evt);
            }
        });
        updatePanel.add(imagenTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 210, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 77, 64));
        jLabel7.setText("Price:");
        updatePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 80, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 77, 64));
        jLabel8.setText("Stock:");
        updatePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 77, 64));
        jLabel9.setText("Product Description:");
        updatePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 140, -1));

        catCombo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        catCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Periferico", "Componente" }));
        catCombo.setSelectedIndex(-1);
        catCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catComboActionPerformed(evt);
            }
        });
        updatePanel.add(catCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        mDescription.setColumns(20);
        mDescription.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        mDescription.setLineWrap(true);
        mDescription.setRows(5);
        mDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 77, 64), 1, true));
        jScrollPane1.setViewportView(mDescription);

        updatePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 370, 190));

        selectedPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 77, 64), 1, true));
        selectedPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updatePanel.add(selectedPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 230, 210));

        photoSelection.setBackground(new java.awt.Color(0, 153, 153));
        photoSelection.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        photoSelection.setForeground(new java.awt.Color(255, 255, 255));
        photoSelection.setBorder(null);
        photoSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photoSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoSelectionActionPerformed(evt);
            }
        });
        updatePanel.add(photoSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 50, 30));

        precioTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        precioTxt.setForeground(new java.awt.Color(0, 77, 64));
        precioTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 77, 64)));
        precioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTxtActionPerformed(evt);
            }
        });
        updatePanel.add(precioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, -1));

        LogInButton.setBackground(new java.awt.Color(0, 153, 153));
        LogInButton.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(255, 255, 255));
        LogInButton.setText("Update");
        LogInButton.setBorder(null);
        LogInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });
        updatePanel.add(LogInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 130, 50));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 77, 64));
        jLabel10.setText("tipo");
        updatePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 30, -1));

        updatePanel.add(boxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void marcaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaTxtActionPerformed

    private void modeloTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloTxtActionPerformed

    private void stockTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTxtActionPerformed

    private void imagenTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagenTxtActionPerformed

    private void photoSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoSelectionActionPerformed
        // TODO add your handling code here:

        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File selectedImage = fc.getSelectedFile();

        if (selectedImage != null) {
            path = selectedImage.getAbsolutePath();

            try {
                Image img = ImageIO.read(selectedImage);
                imagenTxt.setText(path);
                selectedPhoto.setIcon(new ImageIcon(img.getScaledInstance(selectedPhoto.getWidth(),
                        selectedPhoto.getHeight(), Image.SCALE_SMOOTH)));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }

    }//GEN-LAST:event_photoSelectionActionPerformed

    private void precioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTxtActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_precioTxtActionPerformed

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        if(!stockTxt.getText().matches(".[^\\d.].") && !precioTxt.getText().matches(".[^\\d.].")){
            List<Producto> lstProdc = productoDAO.listar();
            String marca = marcaTxt.getText();
            String modelo = modeloTxt.getText();
            String precio = precioTxt.getText();
            String stock = stockTxt.getText();
            String categoria = (String) catCombo.getSelectedItem();
            String tipo = (String)boxTipo.getSelectedItem();
            String rutaImagen = imagenTxt.getText();
            String descripcion = mDescription.getText();
             boolean mismoProducto = lstProdc.stream().anyMatch(a -> a.getMarca().equals(marca) && a.getModelo().equals(modelo) && a.getTipo().equals(tipo));
            if(!mismoProducto){
                    List<String> text = List.of(marca, modelo, precio, stock, descripcion, rutaImagen);

                if(text.stream().allMatch(t -> !t.isEmpty()) && catCombo.getSelectedItem()!=null && boxTipo.getSelectedItem().toString()!=null){
                    agregarProducto();
                }else{
                    JOptionPane.showMessageDialog(this, "Debes llenar todos los casilleros");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Este producto ya esta registrado");
            }
                
        }
        else{
            JOptionPane.showMessageDialog(this, "Ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void catComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catComboActionPerformed
        String item = (String) catCombo.getSelectedItem();
        if(item.equals("Componente")){
            boxTipo.removeAllItems();
            boxTipo.addItem("PROCESADOR");
            boxTipo.addItem("PLACA MADRE");
            boxTipo.addItem("TARJETA DE VIDEO");
            boxTipo.addItem("MEMORIA RAM");
            boxTipo.addItem("ALMACENAMIENTO");
            boxTipo.addItem("REFRIGERACION");
            boxTipo.addItem("FUENTE DE PODER");
            boxTipo.addItem("GABINETE");
        }
        else if(item.equals("Periferico")){
            boxTipo.removeAllItems();
            boxTipo.addItem("MONITOR");
            boxTipo.addItem("MOUSE");
            boxTipo.addItem("TECLADO");
            boxTipo.addItem("AUDIFONOS");
            boxTipo.addItem("MOUSEPAD");
        }
             
    }//GEN-LAST:event_catComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogInButton;
    private javax.swing.JComboBox<String> boxTipo;
    public javax.swing.JComboBox<String> catCombo;
    public javax.swing.JTextField imagenTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea mDescription;
    public javax.swing.JTextField marcaTxt;
    public javax.swing.JTextField modeloTxt;
    private javax.swing.JButton photoSelection;
    public javax.swing.JTextField precioTxt;
    private javax.swing.JLabel selectedPhoto;
    public javax.swing.JTextField stockTxt;
    public javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables
}
