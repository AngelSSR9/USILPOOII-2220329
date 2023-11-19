package dashboard;

import clases.CarritoCompras;
import clases.PC;
import clases.Producto;
import conexionBD.DetallesPcDAO;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelItem extends javax.swing.JPanel {

    Producto producto;
    PC pc;
    CarritoCompras carrito;
        
    public PanelItem(Producto producto, CarritoCompras carrito) {
        initComponents();
        this.producto = producto;
        this.carrito = carrito;
        setInformacionProducto();
    }

    public PanelItem(PC p, CarritoCompras carrito) {
        initComponents();
        this.pc = p;
        this.carrito = carrito;
        DetallesPcDAO detallesPcDAO = new DetallesPcDAO();
        this.pc.setPartes(detallesPcDAO.obtenerDetallesPorId(pc.getId()));
        setInformacionPC();
    }
    
    public void setInformacionPC(){
        setNombreProducto(pc.getNombre());
        setPrecioProducto(pc.getPartes().stream()
                .map(p -> p.getPrecio())
                .reduce(0.0,(a,b) -> a+b));
        setDescripcionProducto("");
        
        setImagenProducto(pc.getImagen());
    }

    public void setInformacionProducto() {
        setNombreProducto(producto.getMarca() + " " + producto.getModelo());
        setPrecioProducto(producto.getPrecio());
        setDescripcionProducto(producto.getTipo());
        setImagenProducto(producto.getImagen());
    }

    public void setNombreProducto(String nombre) {
        lblNombre.setText(nombre);
    }

    public void setImagenProducto(Image imagen) {
        lblImagen.setIcon(new ImageIcon(imagen.getScaledInstance(203,
            169, Image.SCALE_SMOOTH)));
    }

    public void setDescripcionProducto(String descripcion) {
        lblDescripcion.setText(descripcion);
    }

    public void setPrecioProducto(double precio) {
        lblPrecio.setText("s/." + String.valueOf(precio));
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

        setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(76, 76, 76));
        lblNombre.setText("Item Name");

        lblDescripcion.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(178, 178, 178));
        lblDescripcion.setText("Description");

        lblImagen.setText("imagenProducto");
        lblImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenMouseClicked
        if(producto != null){
            FrameDetalleProducto f = new FrameDetalleProducto(producto, carrito);
            f.setVisible(true);
        }
        else{
            FrameDetalleProducto f = new FrameDetalleProducto(pc, carrito);
            f.setVisible(true);
        }
        
    }//GEN-LAST:event_lblImagenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
