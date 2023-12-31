package dashboard;

import clases.Cliente;
import clases.Pedido;
import conexionBD.PedidoDAO;
import gui.frames.FrameMostrarVentas;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Panel que muestra el historial de pedidos para un cliente específico.
 */
public class PanelHistorialPedidos extends javax.swing.JPanel {

    Cliente cliente;
    private PedidoDAO pedidoDAO = new PedidoDAO();
    public DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorter;
    
    /**
     * Constructor de la clase PanelHistorialPedidos.
     *
     * @param cliente El cliente para el cual se mostrará el historial de pedidos.
     */
    public PanelHistorialPedidos(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        listarPedidos();
    }
    
    /**
     * Método que lista los pedidos del cliente y los muestra en la tabla.
     */
    public final void listarPedidos(){
        List<Pedido> lista = pedidoDAO.listar();
        modelo = (DefaultTableModel) tablaPedidos.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getIdCliente()==cliente.getId()){
                ob[0] = lista.get(i).getIdPedido();
                ob[1] = lista.get(i).getFecha();
                ob[2] = lista.get(i).getMetodoPago();

                modelo.addRow(ob);
            }
        }
        
        tablaPedidos.setModel(modelo);
        tablaPedidos.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        tablaPedidos.setRowSorter(sorter);
    }
    
    /**
     * Método para buscar un pedido en la tabla según el texto ingresado.
     */
    private void buscarPedido() {
        try {
            String textoBusqueda = buscarTxt.getText().toLowerCase(); // Convertir a minúsculas
                // ignora caracteres especiales para no afectar la busqueda e ignora que sea mayuscula y minuscula
                RowFilter<Object, Object> filtro = RowFilter.regexFilter("(?i)" + Pattern.quote(textoBusqueda));
                //filtra las coincidencias
                sorter.setRowFilter(filtro);

        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHistorialDePedidosCliente = new keeptoo.KGradientPanel();
        tituloPedidos = new javax.swing.JLabel();
        scrollPedidos = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnVerDetalles = new javax.swing.JButton();
        panelBuscar = new javax.swing.JPanel();
        buscarTxt = new javax.swing.JTextField();

        tituloPedidos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tituloPedidos.setText("Pedidos Totales");

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha de generado", "Metodo de pago"
            }
        ));
        tablaPedidos.setFocusable(false);
        tablaPedidos.setMinimumSize(new java.awt.Dimension(60, 100));
        tablaPedidos.setSelectionBackground(new java.awt.Color(204, 0, 204));
        scrollPedidos.setViewportView(tablaPedidos);

        btnVerDetalles.setText("Ver Detalles");
        btnVerDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerDetallesMouseClicked(evt);
            }
        });

        panelBuscar.setBackground(new java.awt.Color(0, 0, 0,0));
        panelBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buscarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelHistorialDePedidosClienteLayout = new javax.swing.GroupLayout(panelHistorialDePedidosCliente);
        panelHistorialDePedidosCliente.setLayout(panelHistorialDePedidosClienteLayout);
        panelHistorialDePedidosClienteLayout.setHorizontalGroup(
            panelHistorialDePedidosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistorialDePedidosClienteLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(panelHistorialDePedidosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloPedidos))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistorialDePedidosClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(btnVerDetalles)
                .addGap(182, 182, 182))
        );
        panelHistorialDePedidosClienteLayout.setVerticalGroup(
            panelHistorialDePedidosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistorialDePedidosClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tituloPedidos)
                .addGroup(panelHistorialDePedidosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHistorialDePedidosClienteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistorialDePedidosClienteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerDetalles)
                        .addGap(44, 44, 44))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHistorialDePedidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHistorialDePedidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método llamado cuando se hace clic en el botón para ver detalles de un pedido.
     *
     * @param evt El evento de clic del mouse.
     */
    private void btnVerDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerDetallesMouseClicked
        // TODO add your handling code here:
        int fila = tablaPedidos.getSelectedRow();
        if(fila !=-1){
            int idPed = Integer.parseInt(tablaPedidos.getValueAt(fila, 0).toString());
            Pedido pedido = pedidoDAO.obtenerPedidoPorId(idPed);
            FrameMostrarVentas mostVen = new FrameMostrarVentas(pedido);
            mostVen.setVisible(true);
        }else{
            JOptionPane.showConfirmDialog(this, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_btnVerDetallesMouseClicked

    /**
     * Método llamado cuando se libera una tecla en el campo de búsqueda.
     *
     * @param evt El evento de teclado.
     */
    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased

        buscarPedido();
    }//GEN-LAST:event_buscarTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JPanel panelBuscar;
    private keeptoo.KGradientPanel panelHistorialDePedidosCliente;
    private javax.swing.JScrollPane scrollPedidos;
    public javax.swing.JTable tablaPedidos;
    private javax.swing.JLabel tituloPedidos;
    // End of variables declaration//GEN-END:variables
}
