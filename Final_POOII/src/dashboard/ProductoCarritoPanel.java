package dashboard;

import clases.CarritoCompras;
import clases.Producto;
import conexionBD.DetalleCarritoDAO;
import conexionBD.DetallePedidoDAO;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProductoCarritoPanel extends javax.swing.JPanel {
    DetalleCarritoDAO d = new DetalleCarritoDAO();
    Producto producto;
    CarritoCompras carrito;
    int cantidad;

    public ProductoCarritoPanel(Producto producto, int cantidad, CarritoCompras carrito) {
        initComponents();
        this.producto = producto;
        this.cantidad = cantidad;
        this.carrito = carrito;
        establecerComponentes();
    }

    private void establecerComponentes() {
        
        //CONFIGURACION JSPINNER
        SpinnerModel model = new SpinnerNumberModel(1, 1, producto.getStock(), 1); // valor inicial, mínimo, máximo y paso
        spinnerCantidad.setModel(model);
        JComponent editor = spinnerCantidad.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            //textField.setEnabled(false);
            textField.setFocusable(false);
            textField.setEditable(false);
        }

        spinnerCantidad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Realizar acciones cuando se produce un cambio en el JSpinner
                System.out.println(spinnerCantidad.getValue());
                if((int)spinnerCantidad.getValue() >= producto.getStock()){
                    d.actualizarCantidadProducto((int) spinnerCantidad.getValue(), carrito.getIdCarrito(), producto.getId());
                }
            }
        });
        
        lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(137,
            105, Image.SCALE_SMOOTH)));
        lblModelo.setText(producto.getModelo());
        lblPrecio.setText(String.valueOf(producto.getPrecio()));
        System.out.println(cantidad);
        spinnerCantidad.setValue(cantidad);
        lblSubtotal.setText(String.valueOf(cantidad * producto.getPrecio()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEliminar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPrecio = new javax.swing.JLabel();
        spinnerCantidad = new javax.swing.JSpinner();
        lblSubtotal = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(99, 96, 119), 1, true));

        lblModelo.setText("jLabel2");

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tacho.png"))); // NOI18N
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEliminarMouseExited(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("precio");
        jPanel2.add(lblPrecio);
        jPanel2.add(spinnerCantidad);

        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtotal.setText("Subtotal");
        jPanel2.add(lblSubtotal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEliminar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblModelo)
                        .addGap(62, 62, 62))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseEntered
        lblEliminar.setForeground(Color.red);
    }//GEN-LAST:event_lblEliminarMouseEntered

    private void lblEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseExited
        lblEliminar.setForeground(new Color(30, 30, 30));
    }//GEN-LAST:event_lblEliminarMouseExited

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        
        
    }//GEN-LAST:event_lblEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JSpinner spinnerCantidad;
    // End of variables declaration//GEN-END:variables
}
