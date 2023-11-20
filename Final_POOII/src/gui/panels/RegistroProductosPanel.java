package gui.panels;

import clases.Constantes;
import clases.Producto;
import conexionBD.ProductoDAO;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class RegistroProductosPanel extends javax.swing.JPanel {
    RegistroProductosPanel app;
    public DefaultTableModel modelo = new DefaultTableModel();
    public int id;
    ProductoDAO productoDAO = new ProductoDAO();
    TableRowSorter<DefaultTableModel> sorter;
    /**
     * constructor del panel
     */
    public RegistroProductosPanel() {
        initComponents();
        listarProductos();
    }

    /**
     * 
     * @return devuelve true si se envio existosmente los cambios a la BD,
     * en caso contrario devolverá falso
     */
        private boolean modificarProductoBD() {
        Object[] o = new Object[9];
        String marca = marcaTxt.getText();
        String modelo = modeloTxt.getText();
        String precio = precioTxt.getText();
        String stock = stockTxt.getText();
        String categoria = categoriaTxt.getText();
        String tipo = tipoTxt.getText();
        String rutaImagen = imagenTxt.getText();
        String descripcion = mDescripcion.getText();
        String id = idTxt.getText();
        try {
           
            o[0] = marca;
            o[1] = modelo;
            o[2] = Double.parseDouble(precio);
            o[3] = Integer.parseInt(stock);
            o[4] = categoria;
            o[5] = tipo;
            o[6] = rutaImagen;
            o[7] = descripcion;
            o[8] = Integer.parseInt(id);

            productoDAO.actualizar(o);

            return true;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error: " + ex.toString());
            return false;
        }

    }
    /**
     * lista en la tabla todos los productos y se establecen modelos
     */
    public void listarProductos() {
        List<Producto> lista = productoDAO.listar();
        System.out.println(lista.size());
        modelo = (DefaultTableModel) tablaProductos.getModel();
        Object[] ob = new Object[7];
        lista.forEach((t) -> {
            ob[0] = t.getId();
            ob[1] = t.getMarca();
            ob[2] = t.getModelo();
            ob[3] = t.getPrecio();
            ob[4] = t.getCategoria();
            ob[5] = t.getTipo();
            ob[6] = t.getStock();
            modelo.addRow(ob);
        });
        
        tablaProductos.setModel(modelo);
        tablaProductos.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tablaProductos.setRowSorter(sorter);
    }
    /**
     * verifica si se cambio correctamente la bd para limpiar los campos.
     */
    public void modificarProducto(){
        boolean confirm = modificarProductoBD();
        if (confirm) {
            Constantes.limpiarPanel(jPanel1);
            Constantes.limpiarTabla(modelo);
            listarProductos();
        }
    }
    
    /**
     * filtra las filas segun lo escrito en el txtBuscar
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        precioTxt = new javax.swing.JTextField();
        eliminarButton = new javax.swing.JButton();
        limpiarDatosButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        stockTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        modeloTxt = new javax.swing.JTextField();
        categoriaTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        imagenTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tipoTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mDescripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        fondoRegProd = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        idTxt.setEditable(false);
        idTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idTxt.setBorder(null);
        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });
        jPanel1.add(idTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 50, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Precio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Stock");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, -1, -1));

        marcaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        marcaTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(marcaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 130, 20));

        precioTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        precioTxt.setBorder(null);
        precioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTxtActionPerformed(evt);
            }
        });
        jPanel1.add(precioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 120, 20));

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 100, -1));

        limpiarDatosButton.setText("Limpiar");
        limpiarDatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarDatosButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limpiarDatosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 97, -1));

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(modificarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));
        jPanel1.add(stockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 60, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("Modelo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 63, -1));

        modeloTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modeloTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(modeloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 110, 20));

        categoriaTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoriaTxt.setBorder(null);
        categoriaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaTxtActionPerformed(evt);
            }
        });
        jPanel1.add(categoriaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 150, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("Categoria:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("Descripcion");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        imagenTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imagenTxt.setBorder(null);
        imagenTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenTxtActionPerformed(evt);
            }
        });
        jPanel1.add(imagenTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 150, 20));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Tipo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        tipoTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoTxt.setBorder(null);
        tipoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoTxtActionPerformed(evt);
            }
        });
        jPanel1.add(tipoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 140, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Imagen:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        mDescripcion.setColumns(20);
        mDescripcion.setRows(5);
        jScrollPane2.setViewportView(mDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 370, 80));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 830, 160));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MARCA", "MODELO", "PRECIO", "CATEGORIA", "TIPO", "STOCK"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 820, 240));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, 55));

        fondoRegProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoRegProd.png"))); // NOI18N
        add(fondoRegProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int fila = tablaProductos.getSelectedRow(); // indice de fila seleccionada
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            
            id = Integer.parseInt(tablaProductos.getValueAt(fila, 0).toString());
            String marca = tablaProductos.getValueAt(fila, 1).toString();
            String modelo = tablaProductos.getValueAt(fila, 2).toString();
            String precio = tablaProductos.getValueAt(fila, 3).toString();
            String categoria = tablaProductos.getValueAt(fila, 4).toString();
            String tipo = tablaProductos.getValueAt(fila, 5).toString();
            String stock = tablaProductos.getValueAt(fila, 6).toString();
            
            // llena los cuadros de textos con los datos de la fila seleccionada.
            idTxt.setText(String.valueOf(id));
            marcaTxt.setText(marca);
            modeloTxt.setText(modelo);
            precioTxt.setText(precio);
            categoriaTxt.setText(categoria);
            tipoTxt.setText(tipo);
            stockTxt.setText(stock);
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased

        buscar();
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void tipoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoTxtActionPerformed

    private void imagenTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagenTxtActionPerformed

    private void categoriaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaTxtActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        // TODO add your handling code here:
        List<String> lst = List.of(idTxt.getText(),marcaTxt.getText(),modeloTxt.getText(), precioTxt.getText()
                                    , categoriaTxt.getText(), tipoTxt.getText(), imagenTxt.getText(), stockTxt.getText());
        if(lst.stream().allMatch(l->!l.isEmpty())){
            modificarProducto();
        }else {
            JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");
        }
        
    }//GEN-LAST:event_modificarButtonActionPerformed

    private void limpiarDatosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarDatosButtonActionPerformed
        Constantes.limpiarPanel(jPanel1);
    }//GEN-LAST:event_limpiarDatosButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        int fila = tablaProductos.getSelectedRow();
        int ids = Integer.parseInt(tablaProductos.getValueAt(fila, 0).toString());
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            productoDAO.eliminar(ids);
        }
        Constantes.limpiarPanel(jPanel1);
            Constantes.limpiarTabla(modelo);
            listarProductos();
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void precioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTxtActionPerformed

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTxtActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarTxt;
    public javax.swing.JTextField categoriaTxt;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JLabel fondoRegProd;
    public javax.swing.JTextField idTxt;
    public javax.swing.JTextField imagenTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiarDatosButton;
    private javax.swing.JTextArea mDescripcion;
    public javax.swing.JTextField marcaTxt;
    public javax.swing.JTextField modeloTxt;
    private javax.swing.JButton modificarButton;
    public javax.swing.JTextField precioTxt;
    public javax.swing.JTextField stockTxt;
    public javax.swing.JTable tablaProductos;
    public javax.swing.JTextField tipoTxt;
    // End of variables declaration//GEN-END:variables
}
