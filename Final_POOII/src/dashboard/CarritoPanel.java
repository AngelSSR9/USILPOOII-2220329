package dashboard;

import diseño.ScrollBarCustom;
import clases.CarritoCompras;
import clases.Cliente;
import clases.DetalleCarrito;
import clases.PC;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.DetalleCarritoDAO;
import conexionBD.DetallesPcDAO;
import conexionBD.PcDAO;
import conexionBD.ProductoDAO;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarritoPanel extends javax.swing.JPanel {

    ProductoDAO productoDAO = new ProductoDAO();
    DetallesPcDAO detallesPcDAO = new DetallesPcDAO();
    PcDAO pcDAO = new PcDAO();
    CarritoDAO c = new CarritoDAO();
    DetalleCarritoDAO detalleCarritoDAO = new DetalleCarritoDAO();
    Cliente cliente;
    double total;

    public CarritoPanel(Cliente cliente) {
        initComponents();
        iniciar();
        this.cliente = cliente;
    }

    public void iniciar() {
        productosScrollPanel.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 1);
        layout.setHgap(5);
        layout.setVgap(5);
        panelProductos.setLayout(layout);
        panelProductos.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
    }

    public void establecerComponentes() {
        productosScrollPanel.getVerticalScrollBar().setValue(0);
        panelProductos.removeAll();

        CarritoCompras carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        List<DetalleCarrito> listaDetalles = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());

        if (listaDetalles.isEmpty()) {
            buttonProcesarCompra.setEnabled(false);
        } else {
            buttonProcesarCompra.setEnabled(true);
        }

        total = 0;
        calcularTotal();
        for (DetalleCarrito detalle : listaDetalles) {

            if (detalle.getIdProducto() != 0) {
                Producto producto = productoDAO.obtenerProductoPorId(detalle.getIdProducto());

                ProductoCarritoPanel productoPanel = new ProductoCarritoPanel(producto, detalle.getCantidad(), carrito);

                productoPanel.lblEliminar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        detalleCarritoDAO.eliminar(carrito.getIdCarrito(), producto.getId(), 1);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CarritoPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        establecerComponentes();
                    }
                });

                productoPanel.spinnerCantidad.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        // Realizar acciones cuando se produce un cambio en el JSpinner
                        if ((int) productoPanel.spinnerCantidad.getValue() <= producto.getStock()) {
                            detalleCarritoDAO.actualizarCantidadProducto((int) productoPanel.spinnerCantidad.getValue(), carrito.getIdCarrito(), producto.getId(), 1);
                            calcularTotal();
                        }
                    }
                });

                panelProductos.add(productoPanel);
                panelProductos.revalidate();
                panelProductos.repaint();
            }
            else{
                PC pc = pcDAO.obtenerPcPorId(detalle.getIdPC());
                pc.setPartes(detallesPcDAO.obtenerDetallesPorId(pc.getId()));
                ProductoCarritoPanel productoPanel = new ProductoCarritoPanel(pc, detalle.getCantidad(), carrito);

                productoPanel.lblEliminar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        detalleCarritoDAO.eliminar(carrito.getIdCarrito(), pc.getId(), 0);
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CarritoPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        establecerComponentes();
                    }
                });

                productoPanel.spinnerCantidad.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        // Realizar acciones cuando se produce un cambio en el JSpinner
                        if ((int) productoPanel.spinnerCantidad.getValue() <= pc.getStock()) {
                            detalleCarritoDAO.actualizarCantidadProducto((int) productoPanel.spinnerCantidad.getValue(), carrito.getIdCarrito(), pc.getId(), 0);
                            calcularTotal();
                        }
                    }
                });

                panelProductos.add(productoPanel);
                panelProductos.revalidate();
                panelProductos.repaint();
            }

            
        }
        
        
        int cant = listaDetalles.size();
        if (cant == 1 || cant == 2) {
            while (cant < 3) {
                JPanel p = new JPanel();
                panelProductos.add(p);
                cant++;
            }
        }
        lblTotal.setText(String.valueOf(total));
    }

    public void calcularTotal() {
        CarritoCompras carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        List<DetalleCarrito> listaDetalles = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());
        buttonProcesarCompra.setEnabled(!listaDetalles.isEmpty());

        total = listaDetalles.stream()
                .map(detalle -> {
                    if (detalle.getIdProducto() != 0) {
                        Producto producto = productoDAO.obtenerProductoPorId(detalle.getIdProducto());
                        return producto.getPrecio() * detalle.getCantidad();
                    } else {
                        PC pc = pcDAO.obtenerPcPorId(detalle.getIdPC());
                        pc.setPartes(new DetallesPcDAO().obtenerDetallesPorId(pc.getId()));
                        return pc.getPartes().stream()
                                .map(p -> p.getPrecio())
                                .reduce(0.0, (a, b) -> a + b) * detalle.getCantidad();
                    }

                })
                .reduce(0.0, (a, b) -> a + b);
        lblTotal.setText(String.valueOf(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productosScrollPanel = new javax.swing.JScrollPane();
        panelProductos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        buttonProcesarCompra = new javax.swing.JButton();

        productosScrollPanel.setBorder(null);

        panelProductos.setLayout(new java.awt.GridLayout(1, 0));
        productosScrollPanel.setViewportView(panelProductos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Carro de compra");

        jLabel2.setText("Precio");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Producto");

        jLabel5.setText("Subtotal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        lblTotal.setText("total");

        buttonProcesarCompra.setText("Continuar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(buttonProcesarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(buttonProcesarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productosScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonProcesarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JScrollPane productosScrollPanel;
    // End of variables declaration//GEN-END:variables
}
