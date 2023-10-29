package dashboard;

import clases.CarritoCompras;
import clases.Producto;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelItem extends javax.swing.JPanel {

    Producto producto;
    CarritoCompras carrito;
        
    public PanelItem(Producto producto, CarritoCompras carrito) {
        initComponents();
        this.producto = producto;
        this.carrito = carrito;
    }

    public void setInformacion() {
        setNombreProducto(producto.getMarca() + " " + producto.getModelo());
        setPrecioProducto(producto.getPrecio());
        setImagenProducto(producto.getImagen());
    }

    public void setNombreProducto(String nombre) {
        lblNombre.setText(nombre);
    }

    public void setImagenProducto(Image imagen) {
        lblImagen.setIcon(new ImageIcon(imagen));
    }

    public void setDescripcionProducto(String descripcion) {
        lblDescripcion.setText(descripcion);
    }

    public void setPrecioProducto(double precio) {
        lblPrecio.setText(String.valueOf(precio));
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 82, 104), 1, true));

        lblNombre.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(76, 76, 76));
        lblNombre.setText("Item Name");

        lblDescripcion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(178, 178, 178));
        lblDescripcion.setText("Description");

        lblImagen.setText("imagenProducto");
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenMouseClicked(evt);
            }
        });

        lblPrecio.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(76, 76, 76));
        lblPrecio.setText("$0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPrecio)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseClicked
        FrameDetalleProducto f = new FrameDetalleProducto(producto, carrito);
        f.setVisible(true);
    }//GEN-LAST:event_lblImagenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
