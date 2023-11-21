
package gui.panels;

import clases.Cliente;
import clases.PC;
import clases.Producto;
import clases.observer.ElementoObservado;
import clases.observer.TiendaSubject;
import conexionBD.ClienteDAO;
import conexionBD.ProductoDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import clases.observer.Subject;
import conexionBD.PcDAO;

/**
 * Panel para realizar anuncios de productos y PCs.
 * Permite seleccionar un producto o una PC y enviar notificaciones a los clientes.
 */
public class AnunciarPanel extends javax.swing.JPanel {

    // DAO para acceder a la base de datos de productos
    ProductoDAO productoDAO = new ProductoDAO();
    PcDAO pcDAO = new PcDAO();
    
    public AnunciarPanel() {
        initComponents();
        cargarCombos();
    }

    /**
     * Método para cargar los combos con los productos y PCs disponibles.
     */
    public final void cargarCombos(){
        List<Producto> listaProductos = productoDAO.listar();
        listaProductos.forEach(producto -> productosComboBox.addItem(producto.getTipo()+" "+producto.getMarca()));
        List<PC> listaPcs = pcDAO.listar();
        listaPcs.forEach(pc -> pcComboBox.addItem(pc.getNombre()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separador = new javax.swing.JPanel();
        tituloAnunciarProductos = new javax.swing.JLabel();
        pcComboBox = new javax.swing.JComboBox<>();
        productosComboBox = new javax.swing.JComboBox<>();
        btnAnunciarProd = new javax.swing.JButton();
        btnAnunciarPc = new javax.swing.JButton();
        lblElegirProducto = new javax.swing.JLabel();
        lblElegirPc = new javax.swing.JLabel();

        separador.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout separadorLayout = new javax.swing.GroupLayout(separador);
        separador.setLayout(separadorLayout);
        separadorLayout.setHorizontalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        separadorLayout.setVerticalGroup(
            separadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        tituloAnunciarProductos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tituloAnunciarProductos.setText("ANUNCIAR PRODUCTOS");

        btnAnunciarProd.setText("Anunciar producto");
        btnAnunciarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnunciarProdMouseClicked(evt);
            }
        });

        btnAnunciarPc.setText("Anunciar PC");
        btnAnunciarPc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnunciarPcMouseClicked(evt);
            }
        });

        lblElegirProducto.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        lblElegirProducto.setText("Elija un producto");

        lblElegirPc.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        lblElegirPc.setText("Elija una pc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(productosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lblElegirProducto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnAnunciarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblElegirPc)
                                .addGap(136, 136, 136))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnunciarPc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloAnunciarProductos)
                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(tituloAnunciarProductos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblElegirPc)
                                .addGap(38, 38, 38)
                                .addComponent(pcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(btnAnunciarPc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblElegirProducto)
                                .addGap(33, 33, 33)
                                .addComponent(productosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnAnunciarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento del botón "Anunciar producto" que notifica a los clientes sobre el producto seleccionado.
     *
     * @param evt Evento de clic del mouse
     */
    private void btnAnunciarProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnunciarProdMouseClicked
        ElementoObservado productoEncontrado = encontrarProducto(productosComboBox);
        if(productoEncontrado!=null){
            // Obtener la listaProductos de clientes, añadir y notificarlos OBserver
            ClienteDAO clienteDAO = new ClienteDAO();
            Subject tienda = TiendaSubject.getInstancia();
            List<Cliente> clientes = clienteDAO.listar();
            clientes.stream()
                .filter(Cliente::isDecision) 
                .forEach(tienda::añadir);  
            JOptionPane.showMessageDialog(null, "Espere a que los correos se envien");
            tienda.notificar(productoEncontrado);
            System.out.println("Mensajes Enviados");
            JOptionPane.showMessageDialog(null, "Mesajes enviados");
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay stock de este producto");
        }
            
    }//GEN-LAST:event_btnAnunciarProdMouseClicked

    private void btnAnunciarPcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnunciarPcMouseClicked
        ElementoObservado pcEncontrada = encontrarPc(pcComboBox);
        if(pcEncontrada!=null){
            // Obtener la lista de clientes, añadir y notificarlos como Observer
            ClienteDAO clienteDAO = new ClienteDAO();
            Subject tienda = TiendaSubject.getInstancia();
            List<Cliente> clientes = clienteDAO.listar();
            clientes.stream()
                .filter(Cliente::isDecision) 
                .forEach(tienda::añadir);  
            JOptionPane.showMessageDialog(null, "Espere a que los correos se envíen");
            tienda.notificar(pcEncontrada);
            System.out.println("Mensajes Enviados");
            JOptionPane.showMessageDialog(null, "Mensajes enviados");
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay stock de esta pc");
        }
        
    }//GEN-LAST:event_btnAnunciarPcMouseClicked

    /**
     * Método para encontrar un producto seleccionado en el combo.
     *
     * @param box ComboBox que contiene la listaProductos de productos
     * @return Producto seleccionado o null si no hay stock
     */
    private Producto encontrarProducto(JComboBox box){
        List<Producto> valoresEspecificos = productoDAO.listar();
            int selectedIndex = box.getSelectedIndex();
            
            if (selectedIndex >= 0 && selectedIndex < valoresEspecificos.size()) {
               if(valoresEspecificos.get(selectedIndex).getStock()!=0){
                    return valoresEspecificos.get(selectedIndex);
                }else{
                    return null;
                }
            }else{
                return null;
            }
        
    }
    
    private PC encontrarPc (JComboBox box){
        List<PC> valoresEspecificos = pcDAO.listar();
        int selectedIndex = box.getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < valoresEspecificos.size()) {
            if (valoresEspecificos.get(selectedIndex).getStock() != 0) {
                return valoresEspecificos.get(selectedIndex);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnunciarPc;
    private javax.swing.JButton btnAnunciarProd;
    private javax.swing.JLabel lblElegirPc;
    private javax.swing.JLabel lblElegirProducto;
    private javax.swing.JComboBox<String> pcComboBox;
    private javax.swing.JComboBox<String> productosComboBox;
    private javax.swing.JPanel separador;
    private javax.swing.JLabel tituloAnunciarProductos;
    // End of variables declaration//GEN-END:variables
}
