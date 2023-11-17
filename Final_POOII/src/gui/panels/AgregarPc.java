/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.panels;
import clases.Constantes;
import clases.PC;
import clases.Producto;
import conexionBD.DetallesPcDAO;
import conexionBD.PcDAO;
import conexionBD.ProductoDAO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author henry
 */
public class AgregarPc extends javax.swing.JPanel {

    
    PC pc;
    ProductoDAO productoDAO = new ProductoDAO();
    PcDAO pcDAO = new PcDAO();
    DetallesPcDAO detPc = new DetallesPcDAO();
    String path;
    /**
        * Creates new form AgregarPc
     */
    public AgregarPc() {
        
        initComponents();
        cargarComboBox();
    }
    /**
     * Llena todos los combobox con los productos por tipo
     */
    private void cargarComboBox(){
        
        List<Producto> listaMother =  productoDAO.obtenerProductosPorTipo("motherboard");
        listaMother.forEach((t) -> cBoMoBo.addItem(t.getTipo()+"marca "+t.getMarca()));

        List<Producto> listaRam =  productoDAO.obtenerProductosPorTipo("memoria ram");
        listaRam.forEach((t) -> cBoxMemRam.addItem(t.getTipo()+" marca "+t.getMarca()));

        List<Producto> listaRom =  productoDAO.obtenerProductosPorTipo("memoria rom");
        listaRom.forEach((t) -> cBoxMemRom.addItem(t.getTipo()+" marca "+t.getMarca()));

        List<Producto> listaPro =  productoDAO.obtenerProductosPorTipo("procesador");
        listaPro.forEach((t) -> cBoxProce.addItem(t.getTipo()+" marca "+t.getMarca()));

        List<Producto> listaRefr =  productoDAO.obtenerProductosPorTipo("refrigeracion");
        cBoxRefrig.addItem("sin seleccionar");
        listaRefr.forEach((t) -> cBoxRefrig.addItem(t.getTipo()+" marca "+t.getMarca()));
        
        
        List<Producto> listaMouse =  productoDAO.obtenerProductosPorTipo("mouse");
        cBoxMouse.addItem("sin seleccionar");
        listaMouse.forEach((t) -> cBoxMouse.addItem(t.getTipo()+" marca "+t.getMarca()));
        
        List<Producto> listaTar =  productoDAO.obtenerProductosPorTipo("tarjeta grafica");
        cBoxTarjGraf.addItem("sin seleccionar");
        listaTar.forEach((t) -> cBoxTarjGraf.addItem(t.getTipo()+" marca "+t.getMarca()));
        
        List<Producto> listaAud =  productoDAO.obtenerProductosPorTipo("audifonos");
        cBoxAudif.addItem("sin seleccionar");
        listaAud.forEach((t) -> cBoxAudif.addItem(t.getTipo()+" marca "+t.getMarca()));
        
        List<Producto> listaTec =  productoDAO.obtenerProductosPorTipo("teclado");
        cBoxTeclado.addItem("sin seleccionar");
        listaTec.forEach((t) -> cBoxTeclado.addItem(t.getTipo()+" marca "+t.getMarca()));
        
        List<Producto> listaMon =  productoDAO.obtenerProductosPorTipo("monitor");
        cBoxMonitor.addItem("sin seleccionar");
        listaMon.forEach((t) -> cBoxMonitor.addItem(t.getTipo()+" marca "+t.getMarca()));
        
    }
    /**
     * 
     * @param prod
     * @param box
     * @return devuelve El producto de tipo componente segun el item de combobox seleccionado
     * si
     */
    private Producto agregarCom(String prod, JComboBox box){
        //
        List<Producto> valoresEspecificos = productoDAO.obtenerProductosPorTipo(prod);
            int selectedIndex = box.getSelectedIndex();
            //verifica si el indice del item seleccionado esta dentro del rango de la lista de componentes de determinado tipo.
            if (selectedIndex >= 0 && selectedIndex < valoresEspecificos.size()) {
                //verifica que el stock del componente no sea 0.
               if(valoresEspecificos.get(selectedIndex).getStock()!=0){
                   //retorna el producto que esta ubicado un determinada posicion.
                return valoresEspecificos.get(selectedIndex);
                }else{
                    return null;
                }
            }else{
                return null;
            }
        
    }
    /**
     * 
     * @param prod
     * @param box
     * @return devuelve el producto de tipo periferico segun el item de combobox seleccionado
     */
    private Producto agregarPer(String prod, JComboBox box){
        List<Producto> valoresEspecificos = productoDAO.obtenerProductosPorTipo(prod);
            int selectedIndex = box.getSelectedIndex()-1;//el primer elemento del checkbox no tiene valor debido a que puedes no agregar periferico.
            //verifica si el indice del item seleccionado esta dentro del rango de la lista de periferico de determinado tipo.
            if (selectedIndex >= 0 && selectedIndex < valoresEspecificos.size()) {
                //verifica que el stock del componente no sea 0.
                if(valoresEspecificos.get(selectedIndex).getStock()!=0){
                    String valorEspecifico = valoresEspecificos.get(selectedIndex).getTipo();
                    //retorna el producto que esta ubicado un determinada posicion.
                return valoresEspecificos.get(selectedIndex);
                }else{
                    return null;
                }
                
            }else{
                return null;
            }
        
    }
    
    private int agregarPcBD() {
        Object[] o = new Object[3];
        
        try{
            o[0] = txtNombre.getText();
            o[1] = Integer.parseInt(txtStock.getText());
            o[2] = txtImagen.getText();
            
            int id=pcDAO.agregar(o);
            Constantes.limpiarPanel(updatePanel);
            return id;
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            System.out.println(ex);
            return -1;
        }
    }
    
    /*public void agregarPc() {
        boolean confirm = agregarPcBD();
        if (confirm) {
            Constantes.limpiarPanel(updatePanel);
            // Obtener la lista de clientes, añadir y notificarlos OBserver
            
            ClienteDAO clienteDAO = new ClienteDAO();
            TiendaSubject tienda = TiendaSubject.getInstancia();
            List<Cliente> clientes = clienteDAO.listar();
            for (Cliente cliente : clientes) {
                tienda.añadir(cliente);
            }
            JOptionPane.showMessageDialog(null, "Espere a que los correos se envien");
            tienda.notificar();
            System.out.println("Mensajes Enviados");
            JOptionPane.showMessageDialog(null, "Mesajes enviados");
            
        }
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cBoxMemRam = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cBoxMemRom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cBoxProce = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cBoMoBo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cBoxRefrig = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cBoxTarjGraf = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cBoxMouse = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cBoxAudif = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cBoxTeclado = new javax.swing.JComboBox<>();
        cBoxMonitor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        selectedPhoto = new javax.swing.JLabel();
        updatePanel = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        photoSelection = new javax.swing.JButton();

        jLabel2.setText("Memoria ROM");

        jLabel3.setText("Procesador");

        jLabel4.setText("MotherBoard");

        cBoMoBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoMoBoActionPerformed(evt);
            }
        });

        jLabel5.setText("Refrigeración");

        jLabel6.setText("Tarjeta Grafica");

        jLabel7.setText("Mouse");

        jLabel8.setText("Audifonos");

        jLabel9.setText("Teclado");

        jLabel10.setText("Monitor");

        jButton1.setText("Nueva Pc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Memoria RAM");

        selectedPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectedPhoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 77, 64), 1, true));
        selectedPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel12.setText("Stock");

        jLabel13.setText("imagen");

        txtImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImagenActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

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

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatePanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatePanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(204, 204, 204)))
                .addComponent(photoSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(19, 19, 19)
                        .addComponent(photoSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cBoxMemRam, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxMemRom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel4))
                                    .addComponent(cBoMoBo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxRefrig, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cBoxAudif, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel8)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cBoxTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(60, 60, 60)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxProce, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3))
                            .addComponent(cBoxMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cBoxMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel7))
                            .addComponent(cBoxTarjGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(updatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(selectedPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(updatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(selectedPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxMemRam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cBoxProce, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cBoxMemRom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxTarjGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxRefrig, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cBoMoBo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cBoxAudif, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cBoxTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImagenActionPerformed
    
    private void photoSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoSelectionActionPerformed
        // TODO add your handling code here:
        /**
         * muestra la imagen en el jlabel.
         */
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File selectedImage = fc.getSelectedFile();

        if (selectedImage != null) {
            path = selectedImage.getAbsolutePath();

            try {
                Image img = ImageIO.read(selectedImage);
                txtImagen.setText(path);
                selectedPhoto.setIcon(new ImageIcon(img.getScaledInstance(selectedPhoto.getWidth(),
                    selectedPhoto.getHeight(), Image.SCALE_SMOOTH)));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
        }
        
    }//GEN-LAST:event_photoSelectionActionPerformed

    private void cBoMoBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoMoBoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoMoBoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //verifica que ninguno sea nulo
        if(agregarCom("memoria ram", cBoxMemRam)== null || agregarCom("memoria rom", cBoxMemRom)== null || agregarCom("procesador", cBoxProce)==null || agregarCom("motherboard", cBoMoBo)==null){
            JOptionPane.showMessageDialog(this, "El stock esta en 0");
        }else{
            
            List<Producto> prod = new ArrayList<Producto>();
            prod.add(agregarCom("memoria ram", cBoxMemRam));
            prod.add(agregarCom("memoria rom", cBoxMemRom));
            prod.add(agregarCom("procesador", cBoxProce));
            prod.add(agregarCom("motherboard", cBoMoBo));
            if(agregarPer("refrigeracion", cBoxTarjGraf)!=null){
                prod.add(agregarPer("refrigeracion", cBoxTarjGraf));
            }
            if(agregarPer("mouse", cBoxMouse)!=null){
                prod.add(agregarPer("mouse", cBoxMouse));
            }
            if(agregarPer("audifonos", cBoxAudif)!=null){
                prod.add(agregarPer("audifonos", cBoxAudif));
            }
            if(agregarPer("teclado", cBoxTeclado)!=null){
                prod.add(agregarPer("teclado", cBoxTeclado));
            }
            if(agregarPer("monitor", cBoxMonitor)!=null){
                prod.add(agregarPer("monitor", cBoxMonitor));
            }
            
            
            Object[] o = new Object[2];
            
            
            //crea lista para comprobar que todos los elementos existar
            boolean todosLosProductosExisten = prod.stream().allMatch(i->productoDAO.comprobarProducto(i.getId()));
            if(todosLosProductosExisten){
                int stockAct = Integer.parseInt(txtStock.getText());//se guarda el stock puesto.
                //se vaerifica que todos los elementos q componen la pc tengan suficiente stock
                boolean confirm = prod.stream().allMatch(s -> productoDAO.obtenerProductoPorId(s.getId()).getStock()>=stockAct);
                        
                if(confirm){
                        int id=agregarPcBD();
                        for(int a=0;a<prod.size();a++){

                        try {
                            o[0] = id;
                            o[1] = prod.get(a).getId();
                            detPc.agregar(o);
                            
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
                        }
                    }
                    
                    for(Producto i : prod){
                        productoDAO.actualizarStock(i.getId(), i.getStock()-stockAct);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "No el stock de alguno de sus elemento no es suficiente");
                }
            }else{
                JOptionPane.showMessageDialog(this, "No existe alguno(s) de los elementos que lo componian");
            }
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cBoMoBo;
    public javax.swing.JComboBox<String> cBoxAudif;
    public javax.swing.JComboBox<String> cBoxMemRam;
    public javax.swing.JComboBox<String> cBoxMemRom;
    public javax.swing.JComboBox<String> cBoxMonitor;
    public javax.swing.JComboBox<String> cBoxMouse;
    public javax.swing.JComboBox<String> cBoxProce;
    public javax.swing.JComboBox<String> cBoxRefrig;
    public javax.swing.JComboBox<String> cBoxTarjGraf;
    public javax.swing.JComboBox<String> cBoxTeclado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton photoSelection;
    private javax.swing.JLabel selectedPhoto;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    private javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables
}
