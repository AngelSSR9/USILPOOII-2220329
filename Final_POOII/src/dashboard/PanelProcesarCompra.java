package dashboard;

import diseño.ScrollBarCustom;
import clases.CarritoCompras;
import clases.Cliente;
import clases.DetalleCarrito;
import clases.PC;
import clases.Pedido;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.DetalleCarritoDAO;
import conexionBD.DetallePedidoDAO;
import conexionBD.DetallesPcDAO;
import conexionBD.PcDAO;
import conexionBD.PedidoDAO;
import conexionBD.ProductoDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelProcesarCompra extends javax.swing.JPanel {

    DetalleCarritoDAO detalleCarritoDAO = new DetalleCarritoDAO();
    DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    ProductoDAO productoDAO = new ProductoDAO();
    PcDAO pcDAO = new PcDAO();
    DetallesPcDAO detallesPcDAO = new DetallesPcDAO();
    CarritoCompras carrito;
    CarritoDAO c = new CarritoDAO();
    Cliente cliente;
    int idPedido = 0;
    double total = 0;

    public PanelProcesarCompra(Cliente cliente) {
        initComponents();
        productosScrollPanel.setVerticalScrollBar(new ScrollBarCustom());
        panelProductos.setLayout(new GridLayout(0, 1));
        productosScrollPanel.getVerticalScrollBar().setValue(0);
        this.cliente = cliente;
    }

    public void establecerProductos() {

        this.carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        if (carrito != null) {
            panelProductos.removeAll();

            List<DetalleCarrito> listaDetalles = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());
            calcularTotal();
            int cant = 0;
            for (DetalleCarrito detalle : listaDetalles) {

                if (detalle.getIdProducto() != 0) {
                    Producto producto = productoDAO.obtenerProductoPorId(detalle.getIdProducto());
                    PanelMiniProducto productoPanel = new PanelMiniProducto(producto, detalle.getCantidad());
                    panelProductos.add(productoPanel);
                    panelProductos.revalidate();
                    panelProductos.repaint();
                    cant++;
                } else {
                    PC pc = pcDAO.obtenerPcPorId(detalle.getIdPC());
                    pc.setPartes(detallesPcDAO.obtenerDetallesPorId(pc.getId()));
                    PanelMiniProducto productoPanel = new PanelMiniProducto(pc, detalle.getCantidad());
                    panelProductos.add(productoPanel);
                    panelProductos.revalidate();
                    panelProductos.repaint();
                    cant++;
                }

            }
            if (listaDetalles.size() == 1) {
                for (int i = 0; i < 2; i++) {
                    JPanel pan = new JPanel();
                    panelProductos.add(pan);
                }
            }
            //lblTotal.setText(String.valueOf(total));
            lblNumeroProductos.setText(String.valueOf(cant));
        }

    }

    public void calcularTotal() {
        CarritoCompras carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        List<DetalleCarrito> listaDetalles = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());

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

    private void generarPedido(String metodoPago) {
        guardarNuevaVenta(metodoPago);
        guardarDetallesVenta();
        eliminarCarrito();
        crearNuevoCarrito();
        panelProductos.removeAll();
        lblNumeroProductos.setText("0");
        lblTotal.setText("0");
    }

    public void guardarNuevaVenta(String metodoPago) {
        idPedido = pedidoDAO.agregar(new Date(), carrito.getIdCliente(), metodoPago);
    }

    public void guardarDetallesVenta() {
        Pedido pedido = pedidoDAO.obtenerPedidoPorId(idPedido);
        List<DetalleCarrito> listaDetalles = detalleCarritoDAO.obtenerDetallesPorId(carrito.getIdCarrito());
        for (DetalleCarrito detalle : listaDetalles) {
            Object[] o = new Object[5];
            if (detalle.getIdProducto() != 0) {
                Producto producto = productoDAO.obtenerProductoPorId(detalle.getIdProducto());
                productoDAO.actualizarStock(producto.getId(), producto.getStock() - detalle.getCantidad());

                o[0] = pedido.getIdPedido();
                o[1] = producto.getId();
                o[2] = detalle.getCantidad();
                o[3] = producto.getPrecio();
                o[4] = 1;
                detallePedidoDAO.agregar(o);
            } else {
                PC pc = pcDAO.obtenerPcPorId(detalle.getIdPC());
                pc.setPartes(detallesPcDAO.obtenerDetallesPorId(pc.getId()));
                pcDAO.actualizarStock(pc.getId(), pc.getStock() - detalle.getCantidad());

                o[0] = pedido.getIdPedido();
                o[1] = pc.getId();
                o[2] = detalle.getCantidad();
                o[3] = pc.getPartes().stream()
                        .map(p -> p.getPrecio())
                        .reduce(0.0,(a, b) -> a + b);
                o[4] = 0;
                detallePedidoDAO.agregar(o);
            }

        }
    }

    public void eliminarCarrito() {
        detalleCarritoDAO.eliminarTodosDetalles(carrito.getIdCarrito());
        c.eliminar(carrito.getIdCarrito());
        establecerProductos();
    }

    public void crearNuevoCarrito() {
        c.agregar(cliente.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        checkTarjetaCredito = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        checkTarjetaDebito = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        checkTransferencia = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        productosScrollPanel = new javax.swing.JScrollPane();
        panelProductos = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        buttonPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblNumeroProductos = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Medio de Pago");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tarjeta de crédito");

        checkTarjetaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTarjetaCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkTarjetaCredito)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkTarjetaCredito)
                    .addComponent(jLabel4))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tarjeta de débito");

        checkTarjetaDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTarjetaDebitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkTarjetaDebito)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkTarjetaDebito)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Transferencia bancaria");

        checkTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTransferenciaActionPerformed(evt);
            }
        });

        jLabel8.setText("BBVA CONTINENTAL:N° 0000-0000-0000000000");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel9.setText("INTERBANK: N° 0000000000000");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel10.setText("BCP: N° 999-9999999-9-99");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel11.setText("Tu pedido no se procesará hasta que se haya ");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel12.setText("recibido el importe en nuestra cuenta.");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkTransferencia)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 31, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(checkTransferencia))
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        productosScrollPanel.setBorder(null);

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        productosScrollPanel.setViewportView(panelProductos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblTotal.setText("jLabel3");

        buttonPagar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonPagar.setText("Finalizar pedido");
        buttonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPagarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Productos");

        lblNumeroProductos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNumeroProductos.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(40, 40, 40))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblNumeroProductos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(buttonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(productosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNumeroProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productosScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addComponent(buttonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagarActionPerformed
        if (lblNumeroProductos.getText() != "0") {

            if (checkTarjetaCredito.isSelected() || checkTarjetaDebito.isSelected() || checkTransferencia.isSelected()) {
                if (checkTarjetaCredito.isSelected() || checkTarjetaDebito.isSelected()) {
                    FramePagar frame = new FramePagar();
                    frame.pagarBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            checkTarjetaCredito.setSelected(false);
                            checkTarjetaDebito.setSelected(false);
                            JOptionPane.showMessageDialog(null, "Pedido Finalizado\nGracias por su compra !");
                            if(checkTarjetaCredito.isSelected())
                                generarPedido("Tarjeta Crédito");
                            else
                                generarPedido("Tarjeta Débito");
                        }   

                    });
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido Finalizado\nTiene 24 horas para realizar la transferencia.");
                    checkTransferencia.setSelected(false);
                    generarPedido("Transferencia Bancaria");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un medio de pago.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el carrito de compras.");
        }


    }//GEN-LAST:event_buttonPagarActionPerformed

    private void checkTarjetaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTarjetaCreditoActionPerformed
        if (checkTarjetaDebito.isSelected() || checkTransferencia.isSelected()) {
            checkTransferencia.setSelected(false);
            checkTarjetaDebito.setSelected(false);
        }
    }//GEN-LAST:event_checkTarjetaCreditoActionPerformed

    private void checkTarjetaDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTarjetaDebitoActionPerformed
        if (checkTarjetaCredito.isSelected() || checkTransferencia.isSelected()) {
            checkTransferencia.setSelected(false);
            checkTarjetaCredito.setSelected(false);
        }
    }//GEN-LAST:event_checkTarjetaDebitoActionPerformed

    private void checkTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTransferenciaActionPerformed
        if (checkTarjetaCredito.isSelected() || checkTarjetaDebito.isSelected()) {
            checkTarjetaDebito.setSelected(false);
            checkTarjetaCredito.setSelected(false);
        }
    }//GEN-LAST:event_checkTransferenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPagar;
    private javax.swing.JCheckBox checkTarjetaCredito;
    private javax.swing.JCheckBox checkTarjetaDebito;
    private javax.swing.JCheckBox checkTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNumeroProductos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JScrollPane productosScrollPanel;
    // End of variables declaration//GEN-END:variables
}
