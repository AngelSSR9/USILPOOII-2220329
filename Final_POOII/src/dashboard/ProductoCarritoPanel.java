package dashboard;

import clases.CarritoCompras;
import clases.PC;
import clases.Producto;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ProductoCarritoPanel extends javax.swing.JPanel {

    private final int radioEsquinas = 15;
    Producto producto;
    PC pc;
    int cantidad;

    public ProductoCarritoPanel(Producto producto, int cantidad, CarritoCompras carrito) {
        super();
        initComponents();
        setOpaque(false);
        this.producto = producto;
        this.cantidad = cantidad;
        establecerComponentes();
    }

    public ProductoCarritoPanel(PC pc, int cantidad, CarritoCompras carrito) {
        super();
        initComponents();
        setOpaque(false);
        this.pc = pc;
        this.cantidad = cantidad;
        establecerComponentes();
    }

    private void establecerComponentes() {

        if (producto != null) {
            SpinnerModel model = new SpinnerNumberModel(1, 1, producto.getStock(), 1); // valor inicial, mínimo, máximo y paso
            spinnerCantidad.setModel(model);
            lblImagen.setIcon(new ImageIcon(producto.getImagen().getScaledInstance(137,
                    105, Image.SCALE_SMOOTH)));
            lblModelo.setText(producto.getMarca() + " " + producto.getModelo());
            lblPrecio.setText(String.valueOf(producto.getPrecio()));
            spinnerCantidad.setValue(cantidad);
            lblSubtotal.setText(String.valueOf(cantidad * producto.getPrecio()));
        } else {
            SpinnerModel model = new SpinnerNumberModel(1, 1, pc.getStock(), 1); // valor inicial, mínimo, máximo y paso
            spinnerCantidad.setModel(model);
            double precioPC = pc.getPartes().stream()
                    .map(p -> p.getPrecio())
                    .reduce(0.0, (a, b) -> a + b);
            lblImagen.setIcon(new ImageIcon(pc.getImagen().getScaledInstance(137,
                    105, Image.SCALE_SMOOTH)));
            lblModelo.setText(pc.getNombre());
            lblPrecio.setText(String.valueOf(precioPC));
            spinnerCantidad.setValue(cantidad);
            lblSubtotal.setText(String.valueOf(cantidad * precioPC));
        }

        //CONFIGURACION JSPINNER
        JComponent editor = spinnerCantidad.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setFocusable(false);
            textField.setEditable(false);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Dibuja un rectángulo con esquinas redondeadas
        Shape forma;
        forma = new RoundRectangle2D.Double(0, 0, width, height, radioEsquinas, radioEsquinas);
        g2d.setColor(getBackground());
        g2d.fill(forma);
        g2d.dispose();
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

        setBackground(new java.awt.Color(255, 255, 255));

        lblModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblModelo.setText("jLabel2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tacho.png"))); // NOI18N
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("precio");
        jPanel2.add(lblPrecio);
        jPanel2.add(spinnerCantidad);

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtotal.setText("Subtotal");
        jPanel2.add(lblSubtotal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
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
                .addContainerGap(25, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    public javax.swing.JSpinner spinnerCantidad;
    // End of variables declaration//GEN-END:variables
}
