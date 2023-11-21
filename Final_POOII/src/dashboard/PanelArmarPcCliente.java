/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dashboard;

import clases.CarritoCompras;
import clases.Cliente;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.DetalleCarritoDAO;
import conexionBD.ProductoDAO;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import diseño.ScrollBarCustom;

/**
 * La clase PanelArmarPcCliente representa el panel principal para armar una PC.
 * Permite a los usuarios seleccionar diferentes componentes y agregarlos al carrito de compras.
 */
public class PanelArmarPcCliente extends javax.swing.JPanel {

    // Instancias de DAO para la interacción con la base de datos
    private ProductoDAO productoDAO = new ProductoDAO();
    private CarritoDAO carritoDAO = new CarritoDAO();
    
    // Carrito de compras actual del usuario
    private CarritoCompras carrito;
    
    private Cliente cliente;
    
    // Lista para almacenar productos seleccionados
    private List<Producto> productosElegidos = new ArrayList<>();
    
    // Variables para almacenar el tipo de componente seleccionado y su etiqueta correspondiente
    private String componenteSeleccionado;
    private JLabel nombreDelComponenteSeleccionado;
    
    
    /**
     * Constructor para PanelArmarPcCliente.
     * Inicializa el panel y configura el estado inicial.
     *
     * @param cliente El usuario actual.
     */
    public PanelArmarPcCliente(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.carrito = carritoDAO.obtenerCarritoPorIdCliente(cliente.getId());
        iniciar();
    }
    
    /**
     * Inicializa el diseño del panel.
     */
    private void iniciar(){
        scrollPanePrincipal.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(5);
        layout.setVgap(5);
        panelPrincipal.setLayout(layout);
    }
    
    /**
     * Actualiza los productos mostrados según el tipo de componente seleccionado.
     */
    public void establecerItems(){
        setCarrito();
        panelPrincipal.removeAll();
        List<Producto> productos = productoDAO.listar();
        for (Producto p : productos) {
            if(p.getTipo().equals(componenteSeleccionado)){
                ProductoItemArmarPC panel = new ProductoItemArmarPC(p,carrito,productosElegidos);
                panel.setInformacion();
                panelPrincipal.add(panel);
                productosElegidos = panel.cambiarColor(nombreDelComponenteSeleccionado);
            }
        }

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.white);
            panelPrincipal.add(panel);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        PanelComponentes = new javax.swing.JPanel();
        panelHeadComponentes = new javax.swing.JPanel();
        lblComponentes = new javax.swing.JLabel();
        btnProcesador = new javax.swing.JPanel();
        lblProcesador = new javax.swing.JLabel();
        btnPlacaMadre = new javax.swing.JPanel();
        lblPlacaMadre = new javax.swing.JLabel();
        btnMemoriaRAM = new javax.swing.JPanel();
        lblMemoriaRAM = new javax.swing.JLabel();
        btnAlmacenamiento = new javax.swing.JPanel();
        lblDisco = new javax.swing.JLabel();
        btnTarjetaDeVideo = new javax.swing.JPanel();
        lblTarjetaDeVideo = new javax.swing.JLabel();
        btnGabinete = new javax.swing.JPanel();
        lblGabinete = new javax.swing.JLabel();
        btnFuenteDePoder = new javax.swing.JPanel();
        lblFuenteDePoder = new javax.swing.JLabel();
        btnEnfriamiento = new javax.swing.JPanel();
        lblEnfriamento = new javax.swing.JLabel();
        PanelProductosArmarPC = new javax.swing.JPanel();
        panelHeadProductos = new javax.swing.JPanel();
        lblComponentes1 = new javax.swing.JLabel();
        scrollPanePrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        PanelPagoPc = new javax.swing.JPanel();
        panelHeadResumen = new javax.swing.JPanel();
        lblResumen = new javax.swing.JLabel();
        btnAgregarCarrito = new javax.swing.JButton();
        lblSistemaEnfriamentoColor = new javax.swing.JLabel();
        lblProcesadorColor = new javax.swing.JLabel();
        lblPlacaMadreColor = new javax.swing.JLabel();
        lblMemoriaRAMColor = new javax.swing.JLabel();
        lblAlmacenamientoColor = new javax.swing.JLabel();
        lblTarjetaDeVideoColor = new javax.swing.JLabel();
        lblGabineteColor = new javax.swing.JLabel();
        lblFuentePoderColor = new javax.swing.JLabel();

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeadComponentes.setBackground(new java.awt.Color(0, 0, 0));
        panelHeadComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblComponentes.setForeground(new java.awt.Color(255, 255, 255));
        lblComponentes.setText("COMPONENTES");
        panelHeadComponentes.add(lblComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 17, -1, -1));

        PanelComponentes.add(panelHeadComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        btnProcesador.setBackground(new java.awt.Color(255, 255, 255));
        btnProcesador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnProcesador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcesadorMouseClicked(evt);
            }
        });
        btnProcesador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProcesador.setBackground(new java.awt.Color(0, 0, 0));
        lblProcesador.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblProcesador.setForeground(new java.awt.Color(0, 0, 0));
        lblProcesador.setText("PROCESADOR");
        btnProcesador.add(lblProcesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 30));

        PanelComponentes.add(btnProcesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 260, 50));

        btnPlacaMadre.setBackground(new java.awt.Color(255, 255, 255));
        btnPlacaMadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPlacaMadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlacaMadreMouseClicked(evt);
            }
        });
        btnPlacaMadre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlacaMadre.setBackground(new java.awt.Color(0, 0, 0));
        lblPlacaMadre.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblPlacaMadre.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacaMadre.setText("PLACA MADRE");
        btnPlacaMadre.add(lblPlacaMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        PanelComponentes.add(btnPlacaMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 40));

        btnMemoriaRAM.setBackground(new java.awt.Color(255, 255, 255));
        btnMemoriaRAM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnMemoriaRAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemoriaRAMMouseClicked(evt);
            }
        });
        btnMemoriaRAM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMemoriaRAM.setBackground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAM.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblMemoriaRAM.setForeground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAM.setText("MEMORIA RAM");
        btnMemoriaRAM.add(lblMemoriaRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        PanelComponentes.add(btnMemoriaRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 260, 50));

        btnAlmacenamiento.setBackground(new java.awt.Color(255, 255, 255));
        btnAlmacenamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAlmacenamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlmacenamientoMouseClicked(evt);
            }
        });
        btnAlmacenamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDisco.setBackground(new java.awt.Color(0, 0, 0));
        lblDisco.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblDisco.setForeground(new java.awt.Color(0, 0, 0));
        lblDisco.setText("ALMACENAMIENTO");
        btnAlmacenamiento.add(lblDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        PanelComponentes.add(btnAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 260, 40));

        btnTarjetaDeVideo.setBackground(new java.awt.Color(255, 255, 255));
        btnTarjetaDeVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnTarjetaDeVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTarjetaDeVideoMouseClicked(evt);
            }
        });
        btnTarjetaDeVideo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTarjetaDeVideo.setBackground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideo.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblTarjetaDeVideo.setForeground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideo.setText("TARJETA DE VIDEO");
        btnTarjetaDeVideo.add(lblTarjetaDeVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        PanelComponentes.add(btnTarjetaDeVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 260, 50));

        btnGabinete.setBackground(new java.awt.Color(255, 255, 255));
        btnGabinete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGabinete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGabineteMouseClicked(evt);
            }
        });
        btnGabinete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGabinete.setBackground(new java.awt.Color(0, 0, 0));
        lblGabinete.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblGabinete.setForeground(new java.awt.Color(0, 0, 0));
        lblGabinete.setText("GABINETE");
        btnGabinete.add(lblGabinete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        PanelComponentes.add(btnGabinete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 260, 50));

        btnFuenteDePoder.setBackground(new java.awt.Color(255, 255, 255));
        btnFuenteDePoder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnFuenteDePoder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFuenteDePoderMouseClicked(evt);
            }
        });
        btnFuenteDePoder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFuenteDePoder.setBackground(new java.awt.Color(0, 0, 0));
        lblFuenteDePoder.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblFuenteDePoder.setForeground(new java.awt.Color(0, 0, 0));
        lblFuenteDePoder.setText("FUENTE DE PODER");
        btnFuenteDePoder.add(lblFuenteDePoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        PanelComponentes.add(btnFuenteDePoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 260, 50));

        btnEnfriamiento.setBackground(new java.awt.Color(255, 255, 255));
        btnEnfriamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnEnfriamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnfriamientoMouseClicked(evt);
            }
        });
        btnEnfriamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnfriamento.setBackground(new java.awt.Color(0, 0, 0));
        lblEnfriamento.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblEnfriamento.setForeground(new java.awt.Color(0, 0, 0));
        lblEnfriamento.setText("REFRIGERACION");
        btnEnfriamiento.add(lblEnfriamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        PanelComponentes.add(btnEnfriamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 50));

        kGradientPanel1.add(PanelComponentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 430));

        PanelProductosArmarPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeadProductos.setBackground(new java.awt.Color(0, 0, 0));
        panelHeadProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblComponentes1.setForeground(new java.awt.Color(255, 255, 255));
        lblComponentes1.setText("PRODUCTOS");
        panelHeadProductos.add(lblComponentes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        PanelProductosArmarPC.add(panelHeadProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        scrollPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.GridLayout(1, 0));
        scrollPanePrincipal.setViewportView(panelPrincipal);

        PanelProductosArmarPC.add(scrollPanePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 260, 380));

        kGradientPanel1.add(PanelProductosArmarPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 260, 430));

        PanelPagoPc.setBackground(new java.awt.Color(255, 255, 255));
        PanelPagoPc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeadResumen.setBackground(new java.awt.Color(0, 0, 0));
        panelHeadResumen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblResumen.setForeground(new java.awt.Color(255, 255, 255));
        lblResumen.setText("RESUMEN");
        panelHeadResumen.add(lblResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        PanelPagoPc.add(panelHeadResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        btnAgregarCarrito.setBackground(new java.awt.Color(51, 51, 255));
        btnAgregarCarrito.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        btnAgregarCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCarrito.setText("Agregar al carrito");
        btnAgregarCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCarritoMouseClicked(evt);
            }
        });
        PanelPagoPc.add(btnAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 150, 40));

        lblSistemaEnfriamentoColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblSistemaEnfriamentoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblSistemaEnfriamentoColor.setText("SISTEMA DE ENFRIAMIENTO");
        PanelPagoPc.add(lblSistemaEnfriamentoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        lblProcesadorColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblProcesadorColor.setForeground(new java.awt.Color(0, 0, 0));
        lblProcesadorColor.setText("PROCESADOR");
        PanelPagoPc.add(lblProcesadorColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblPlacaMadreColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblPlacaMadreColor.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacaMadreColor.setText("PLACA MADRE");
        PanelPagoPc.add(lblPlacaMadreColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblMemoriaRAMColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblMemoriaRAMColor.setForeground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAMColor.setText("MEMORIA RAM");
        PanelPagoPc.add(lblMemoriaRAMColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblAlmacenamientoColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblAlmacenamientoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblAlmacenamientoColor.setText("ALMACENAMIENTO");
        PanelPagoPc.add(lblAlmacenamientoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblTarjetaDeVideoColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblTarjetaDeVideoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideoColor.setText("TARJETA DE VIDEO");
        PanelPagoPc.add(lblTarjetaDeVideoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        lblGabineteColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblGabineteColor.setForeground(new java.awt.Color(0, 0, 0));
        lblGabineteColor.setText("GABINETE");
        PanelPagoPc.add(lblGabineteColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        lblFuentePoderColor.setFont(new java.awt.Font("Dubai Light", 1, 14)); // NOI18N
        lblFuentePoderColor.setForeground(new java.awt.Color(0, 0, 0));
        lblFuentePoderColor.setText("FUENTE DE PODER");
        PanelPagoPc.add(lblFuentePoderColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        kGradientPanel1.add(PanelPagoPc, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 260, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProcesadorMouseClicked
        clasificarItems(lblProcesador, lblProcesadorColor);
    }//GEN-LAST:event_btnProcesadorMouseClicked

    private void btnPlacaMadreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlacaMadreMouseClicked
        clasificarItems(lblPlacaMadre, lblPlacaMadreColor);
    }//GEN-LAST:event_btnPlacaMadreMouseClicked

    private void btnMemoriaRAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMemoriaRAMMouseClicked
        clasificarItems(lblMemoriaRAM, lblMemoriaRAMColor);
    }//GEN-LAST:event_btnMemoriaRAMMouseClicked

    private void btnAlmacenamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlmacenamientoMouseClicked
        clasificarItems(lblDisco, lblAlmacenamientoColor);
    }//GEN-LAST:event_btnAlmacenamientoMouseClicked

    private void btnTarjetaDeVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTarjetaDeVideoMouseClicked
        clasificarItems(lblTarjetaDeVideo, lblTarjetaDeVideoColor);
    }//GEN-LAST:event_btnTarjetaDeVideoMouseClicked

    private void btnFuenteDePoderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuenteDePoderMouseClicked
        clasificarItems(lblFuenteDePoder, lblFuentePoderColor);
    }//GEN-LAST:event_btnFuenteDePoderMouseClicked

    private void btnEnfriamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnfriamientoMouseClicked
        clasificarItems(lblEnfriamento, lblSistemaEnfriamentoColor);
    }//GEN-LAST:event_btnEnfriamientoMouseClicked

    private void btnGabineteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGabineteMouseClicked
        clasificarItems(lblGabinete, lblGabineteColor);
    }//GEN-LAST:event_btnGabineteMouseClicked

    /**
     * Maneja el evento cuando se hace clic en el botón "Agregar al carrito".
     * Agrega los productos seleccionados al carrito de compras y actualiza la base de datos.
     *
     * @param evt El evento del ratón que desencadena la acción.
     */
    private void btnAgregarCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCarritoMouseClicked

        if(productosElegidos.size()==8){
            for(Producto producto : productosElegidos){
                Object o[] = new Object[3];
                o[0] = carrito.getIdCarrito();
                o[1] = producto.getId();
                o[2] = 1;
                DetalleCarritoDAO d =  new DetalleCarritoDAO();
                d.agregar(o);
            }
            JOptionPane.showMessageDialog(null, "Productos en el carrito");
            reestablecerColor();
            productosElegidos.removeAll(productosElegidos);
        }
        else{
            int faltan = 8- productosElegidos.size();
            JOptionPane.showMessageDialog(null, "Te falta seleccionar "+ faltan+" productos");
        }
    }//GEN-LAST:event_btnAgregarCarritoMouseClicked

    /**
     * Clasifica el tipo de componente seleccionado y actualiza los productos mostrados en consecuencia.
     *
     * @param name La etiqueta que representa el tipo de componente seleccionado.
     * @param nameColor La etiqueta que representa el color del tipo de componente seleccionado.
     */
    public void clasificarItems(JLabel name, JLabel nameColor){
        this.componenteSeleccionado = name.getText();
        this.nombreDelComponenteSeleccionado = nameColor;
        establecerItems();
        
    }
    
    public void reestablecerColor(){
        lblProcesadorColor.setForeground(Color.black);
        lblPlacaMadreColor.setForeground(Color.black);
        lblMemoriaRAMColor.setForeground(Color.black);
        lblAlmacenamientoColor.setForeground(Color.black);
        lblTarjetaDeVideoColor.setForeground(Color.black);
        lblGabineteColor.setForeground(Color.black);
        lblFuentePoderColor.setForeground(Color.black);
        lblSistemaEnfriamentoColor.setForeground(Color.black);
            
    }
    
    public void setCarrito(){
        this.carrito = carritoDAO.obtenerCarritoPorIdCliente(cliente.getId());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelComponentes;
    private javax.swing.JPanel PanelPagoPc;
    private javax.swing.JPanel PanelProductosArmarPC;
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JPanel btnAlmacenamiento;
    private javax.swing.JPanel btnEnfriamiento;
    private javax.swing.JPanel btnFuenteDePoder;
    private javax.swing.JPanel btnGabinete;
    private javax.swing.JPanel btnMemoriaRAM;
    private javax.swing.JPanel btnPlacaMadre;
    private javax.swing.JPanel btnProcesador;
    private javax.swing.JPanel btnTarjetaDeVideo;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAlmacenamientoColor;
    private javax.swing.JLabel lblComponentes;
    private javax.swing.JLabel lblComponentes1;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblEnfriamento;
    private javax.swing.JLabel lblFuenteDePoder;
    private javax.swing.JLabel lblFuentePoderColor;
    private javax.swing.JLabel lblGabinete;
    private javax.swing.JLabel lblGabineteColor;
    private javax.swing.JLabel lblMemoriaRAM;
    private javax.swing.JLabel lblMemoriaRAMColor;
    private javax.swing.JLabel lblPlacaMadre;
    private javax.swing.JLabel lblPlacaMadreColor;
    private javax.swing.JLabel lblProcesador;
    private javax.swing.JLabel lblProcesadorColor;
    private javax.swing.JLabel lblResumen;
    private javax.swing.JLabel lblSistemaEnfriamentoColor;
    private javax.swing.JLabel lblTarjetaDeVideo;
    private javax.swing.JLabel lblTarjetaDeVideoColor;
    private javax.swing.JPanel panelHeadComponentes;
    private javax.swing.JPanel panelHeadProductos;
    private javax.swing.JPanel panelHeadResumen;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
