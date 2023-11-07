package dashboard;

import clases.Producto;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PanelMiniProducto extends javax.swing.JPanel {
    
    Producto producto;
    int cantidad;
    
    public PanelMiniProducto(Producto producto, int cantidad) {
        initComponents();
        this.producto = producto;
        this.cantidad = cantidad;
        setInformacion();
    }
    
    public void setInformacion() {
        setNombreProducto(producto.getMarca() + " " + producto.getModelo());
        setPrecioProducto(producto.getPrecio());
        setImagenProducto(producto.getImagen());
        setMarcaProducto(producto.getMarca());
        setCantidadProducto(cantidad);
    }

    public void setNombreProducto(String nombre) {
        lblNombre.setText(nombre);
    }

    public void setImagenProducto(Image imagen) {
        lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(88,
            80, Image.SCALE_SMOOTH)));
    }

    public void setPrecioProducto(double precio) {
        lblPrecio.setText(String.valueOf(precio));
    }
    
    public void setMarcaProducto(String marca){
        lblMarca.setText(marca);
    }
    
    public void setCantidadProducto(int cantidad){
        lblCantidad.setText(String.valueOf(cantidad) + "un.");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagen = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblImagen.setText("jLabel4");

        lblMarca.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMarca.setText("jLabel5");

        lblNombre.setText("jLabel6");

        lblCantidad.setText("jLabel7");

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrecio.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca)
                            .addComponent(lblCantidad))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecio)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblPrecio))
                        .addGap(15, 15, 15)
                        .addComponent(lblCantidad)
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
