package dashboard;

import clases.CarritoCompras;
import clases.Producto;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * La clase ProductoItemArmarPC representa un elemento individual en la interfaz de usuario
 * para la selección de productos al armar una PC. Contiene información sobre el producto,
 * como su nombre, imagen y precio. Permite a los usuarios seleccionar productos y agregarlos al carrito de compras.
 */
public class ProductoItemArmarPC extends javax.swing.JPanel {

    // Atributos que almacenan información sobre el producto, carrito y productos seleccionados
    private Producto producto;
    private CarritoCompras carrito;
    private List<Producto> productos;
    
    /**
     * Constructor para ProductoItemArmarPC.
     *
     * @param producto El producto asociado a este elemento.
     * @param carrito El carrito de compras actual del usuario.
     * @param productos La lista de productos seleccionados.
     */
    public ProductoItemArmarPC(Producto producto, CarritoCompras carrito, List<Producto> productos) {
        initComponents();
        this.producto = producto;
        this.carrito = carrito;
        this.productos = productos;
    }
    
    /**
     * Cambia el color del texto de la etiqueta y maneja la lógica cuando se hace clic en el panel.
     *
     * @param text La etiqueta cuyo color se cambiará.
     * @return La lista actualizada de productos seleccionados.
     */
    public List cambiarColor(JLabel text) {
        panelProducto.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (productos.size() >= 8) {
                        JOptionPane.showMessageDialog(null, "No puedes agregar mas de 8 productos!");
                    } else if (producto.getStock() <= 0) {
                        JOptionPane.showMessageDialog(null, "No hay este producto en stock!");
                    } else if (productos.contains(producto)) {
                        JOptionPane.showMessageDialog(null, "Este producto ya fue elegido!");
                    } else {
                        productos.add(producto);
                        JOptionPane.showMessageDialog(null, "Product elegido");
                        text.setForeground(Color.red);
                    }
                }
            });
        return productos;
    }
    
    /**
     * Establece la información del producto en la interfaz gráfica.
     */
    public void setInformacion() {
        setNombreProducto(producto.getMarca());
        setPrecioProducto(producto.getPrecio());
        setImagenProducto(producto.getImagen());
    }

    /**
     * Establece el nombre del producto en la etiqueta correspondiente.
     *
     * @param nombre El nombre del producto.
     */
    public void setNombreProducto(String nombre) {
        lblNombre.setText(nombre);
    }

    /**
     * Establece la imagen del producto en la etiqueta correspondiente.
     *
     * @param imagen La imagen del producto.
     */
    public void setImagenProducto(Image imagen) {
        lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(80,
            68, Image.SCALE_SMOOTH)));
    }

    /**
     * Establece el precio del producto en la etiqueta correspondiente.
     *
     * @param precio El precio del producto.
     */
    public void setPrecioProducto(double precio) {
        lblPrecio.setText("S/."+String.valueOf(precio));
    }

    /**
     * Devuelve la etiqueta de la imagen del producto.
     *
     * @return La etiqueta de la imagen del producto.
     */
    public JLabel getLblImagen() {
        return lblImagen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProducto = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelProducto.setBackground(new java.awt.Color(255, 255, 255));
        panelProducto.setForeground(new java.awt.Color(255, 255, 255));

        lblImagen.setBackground(new java.awt.Color(255, 255, 255));
        lblImagen.setForeground(new java.awt.Color(255, 255, 255));
        lblImagen.setText("imagen");
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(76, 76, 76));
        lblNombre.setText("Item Name");

        lblPrecio.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(76, 76, 76));
        lblPrecio.setText("$0.00");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductoLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrecio)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(20, 20, 20))
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JPanel panelProducto;
    // End of variables declaration//GEN-END:variables
}
