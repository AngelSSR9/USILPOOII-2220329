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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class PanelArmarPC extends javax.swing.JPanel {

    ProductoDAO productoDAO = new ProductoDAO();
    CarritoDAO c = new CarritoDAO();
    CarritoCompras carrito;
    List<Producto> productosElegidos = new ArrayList<>();
    
    String componenteVar;
    JLabel nombreVar;
    
    
    
    public PanelArmarPC(Cliente cliente) {
        initComponents();
        this.carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        iniciar();
        
    }
    
    private void iniciar(){
        scrollPanePrincipal.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(5);
        layout.setVgap(5);
        panelPrincipal.setLayout(layout);
    }
    
    public void establecerItems() throws IOException, SQLException {
        panelPrincipal.removeAll();
        List<Producto> productos = productoDAO.listar();
        for (Producto p : productos) {
            if(p.getTipo().equals(componenteVar)){
                ProductoItemArmarPC panel = new ProductoItemArmarPC(p,carrito,productosElegidos);
                panel.setInformacion();
                System.out.println(p.toString());
                panelPrincipal.add(panel);
                productosElegidos = panel.cambiarColor(nombreVar);
            }
        }

        for (int i = 0; i < 5; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.white);
                panelPrincipal.add(panel);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                System.out.println(i);
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

        PanelComponentes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblComponentes = new javax.swing.JLabel();
        btnProcesador = new javax.swing.JPanel();
        lblProcesador = new javax.swing.JLabel();
        lblInfoProcesador = new javax.swing.JLabel();
        btnPlacaMadre = new javax.swing.JPanel();
        lblInfoPlacaMadre = new javax.swing.JLabel();
        lblPlacaMadre = new javax.swing.JLabel();
        btnMemoriaRAM = new javax.swing.JPanel();
        lblMemoriaRAM = new javax.swing.JLabel();
        lblInfoMemoriaRAM = new javax.swing.JLabel();
        btnAlmacenamiento = new javax.swing.JPanel();
        lblAlmacenamiento = new javax.swing.JLabel();
        lblInfoAlmacenamiento = new javax.swing.JLabel();
        btnTarjetaDeVideo = new javax.swing.JPanel();
        lblInfoTarjetaDeVideo = new javax.swing.JLabel();
        lblTarjetaDeVideo = new javax.swing.JLabel();
        btnGabinete = new javax.swing.JPanel();
        lblInfoGabinete = new javax.swing.JLabel();
        lblGabinete = new javax.swing.JLabel();
        btnFuenteDePoder = new javax.swing.JPanel();
        lblFuenteDePoder = new javax.swing.JLabel();
        lblInfoFuenteDePoder = new javax.swing.JLabel();
        btnEnfriamiento = new javax.swing.JPanel();
        lblEnfriamento = new javax.swing.JLabel();
        lblInfoEnfriamento = new javax.swing.JLabel();
        PanelProductosArmarPC = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        scrollPanePrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();
        PanelPagoPc = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
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

        PanelComponentes.setBackground(new java.awt.Color(255, 255, 255));
        PanelComponentes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblComponentes.setForeground(new java.awt.Color(255, 255, 255));
        lblComponentes.setText("COMPONENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(lblComponentes)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(lblComponentes)
                .addContainerGap())
        );

        PanelComponentes.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 30));

        btnProcesador.setBackground(new java.awt.Color(255, 255, 255));
        btnProcesador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcesadorMouseClicked(evt);
            }
        });

        lblProcesador.setBackground(new java.awt.Color(0, 0, 0));
        lblProcesador.setForeground(new java.awt.Color(0, 0, 0));
        lblProcesador.setText("Procesador");

        javax.swing.GroupLayout btnProcesadorLayout = new javax.swing.GroupLayout(btnProcesador);
        btnProcesador.setLayout(btnProcesadorLayout);
        btnProcesadorLayout.setHorizontalGroup(
            btnProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProcesadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProcesador)
                    .addComponent(lblInfoProcesador, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnProcesadorLayout.setVerticalGroup(
            btnProcesadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProcesadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProcesador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoProcesador, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelComponentes.add(btnProcesador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 240, 50));

        btnPlacaMadre.setBackground(new java.awt.Color(255, 255, 255));
        btnPlacaMadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlacaMadreMouseClicked(evt);
            }
        });

        lblPlacaMadre.setBackground(new java.awt.Color(0, 0, 0));
        lblPlacaMadre.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacaMadre.setText("PlacaMadre");

        javax.swing.GroupLayout btnPlacaMadreLayout = new javax.swing.GroupLayout(btnPlacaMadre);
        btnPlacaMadre.setLayout(btnPlacaMadreLayout);
        btnPlacaMadreLayout.setHorizontalGroup(
            btnPlacaMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPlacaMadreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPlacaMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoPlacaMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlacaMadre))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnPlacaMadreLayout.setVerticalGroup(
            btnPlacaMadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPlacaMadreLayout.createSequentialGroup()
                .addComponent(lblPlacaMadre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoPlacaMadre, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelComponentes.add(btnPlacaMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, -1));

        btnMemoriaRAM.setBackground(new java.awt.Color(255, 255, 255));
        btnMemoriaRAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMemoriaRAMMouseClicked(evt);
            }
        });

        lblMemoriaRAM.setBackground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAM.setForeground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAM.setText("MemoriaRAM");

        javax.swing.GroupLayout btnMemoriaRAMLayout = new javax.swing.GroupLayout(btnMemoriaRAM);
        btnMemoriaRAM.setLayout(btnMemoriaRAMLayout);
        btnMemoriaRAMLayout.setHorizontalGroup(
            btnMemoriaRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMemoriaRAMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnMemoriaRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoMemoriaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMemoriaRAM))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnMemoriaRAMLayout.setVerticalGroup(
            btnMemoriaRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMemoriaRAMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMemoriaRAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoMemoriaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelComponentes.add(btnMemoriaRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, -1));

        btnAlmacenamiento.setBackground(new java.awt.Color(255, 255, 255));
        btnAlmacenamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlmacenamientoMouseClicked(evt);
            }
        });

        lblAlmacenamiento.setBackground(new java.awt.Color(0, 0, 0));
        lblAlmacenamiento.setForeground(new java.awt.Color(0, 0, 0));
        lblAlmacenamiento.setText("Almacenamiento");

        javax.swing.GroupLayout btnAlmacenamientoLayout = new javax.swing.GroupLayout(btnAlmacenamiento);
        btnAlmacenamiento.setLayout(btnAlmacenamientoLayout);
        btnAlmacenamientoLayout.setHorizontalGroup(
            btnAlmacenamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAlmacenamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnAlmacenamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoAlmacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlmacenamiento))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnAlmacenamientoLayout.setVerticalGroup(
            btnAlmacenamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAlmacenamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlmacenamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoAlmacenamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        PanelComponentes.add(btnAlmacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 186, 240, 50));

        btnTarjetaDeVideo.setBackground(new java.awt.Color(255, 255, 255));
        btnTarjetaDeVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTarjetaDeVideoMouseClicked(evt);
            }
        });

        lblTarjetaDeVideo.setBackground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideo.setForeground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideo.setText("Tarjeta de video");

        javax.swing.GroupLayout btnTarjetaDeVideoLayout = new javax.swing.GroupLayout(btnTarjetaDeVideo);
        btnTarjetaDeVideo.setLayout(btnTarjetaDeVideoLayout);
        btnTarjetaDeVideoLayout.setHorizontalGroup(
            btnTarjetaDeVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTarjetaDeVideoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnTarjetaDeVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoTarjetaDeVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTarjetaDeVideo))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnTarjetaDeVideoLayout.setVerticalGroup(
            btnTarjetaDeVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTarjetaDeVideoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTarjetaDeVideo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoTarjetaDeVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelComponentes.add(btnTarjetaDeVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 240, -1));

        btnGabinete.setBackground(new java.awt.Color(255, 255, 255));
        btnGabinete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGabineteMouseClicked(evt);
            }
        });

        lblGabinete.setBackground(new java.awt.Color(0, 0, 0));
        lblGabinete.setForeground(new java.awt.Color(0, 0, 0));
        lblGabinete.setText("Gabinete");

        javax.swing.GroupLayout btnGabineteLayout = new javax.swing.GroupLayout(btnGabinete);
        btnGabinete.setLayout(btnGabineteLayout);
        btnGabineteLayout.setHorizontalGroup(
            btnGabineteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGabineteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnGabineteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGabinete))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnGabineteLayout.setVerticalGroup(
            btnGabineteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGabineteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGabinete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelComponentes.add(btnGabinete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 240, -1));

        btnFuenteDePoder.setBackground(new java.awt.Color(255, 255, 255));
        btnFuenteDePoder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFuenteDePoderMouseClicked(evt);
            }
        });

        lblFuenteDePoder.setBackground(new java.awt.Color(0, 0, 0));
        lblFuenteDePoder.setForeground(new java.awt.Color(0, 0, 0));
        lblFuenteDePoder.setText("Fuente de poder");

        javax.swing.GroupLayout btnFuenteDePoderLayout = new javax.swing.GroupLayout(btnFuenteDePoder);
        btnFuenteDePoder.setLayout(btnFuenteDePoderLayout);
        btnFuenteDePoderLayout.setHorizontalGroup(
            btnFuenteDePoderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnFuenteDePoderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnFuenteDePoderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuenteDePoder)
                    .addComponent(lblInfoFuenteDePoder, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnFuenteDePoderLayout.setVerticalGroup(
            btnFuenteDePoderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnFuenteDePoderLayout.createSequentialGroup()
                .addComponent(lblFuenteDePoder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoFuenteDePoder, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        PanelComponentes.add(btnFuenteDePoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 240, -1));

        btnEnfriamiento.setBackground(new java.awt.Color(255, 255, 255));
        btnEnfriamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnfriamientoMouseClicked(evt);
            }
        });

        lblEnfriamento.setBackground(new java.awt.Color(0, 0, 0));
        lblEnfriamento.setForeground(new java.awt.Color(0, 0, 0));
        lblEnfriamento.setText("Sistema de enfriamento");

        javax.swing.GroupLayout btnEnfriamientoLayout = new javax.swing.GroupLayout(btnEnfriamiento);
        btnEnfriamiento.setLayout(btnEnfriamientoLayout);
        btnEnfriamientoLayout.setHorizontalGroup(
            btnEnfriamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEnfriamientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnEnfriamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnfriamento)
                    .addComponent(lblInfoEnfriamento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnEnfriamientoLayout.setVerticalGroup(
            btnEnfriamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEnfriamientoLayout.createSequentialGroup()
                .addComponent(lblEnfriamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfoEnfriamento, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        PanelComponentes.add(btnEnfriamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, -1));

        PanelProductosArmarPC.setBackground(new java.awt.Color(255, 255, 255));
        PanelProductosArmarPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        lblProductos.setForeground(new java.awt.Color(255, 255, 255));
        lblProductos.setText("PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(lblProductos)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblProductos)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        PanelProductosArmarPC.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        scrollPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanePrincipal.setForeground(new java.awt.Color(255, 255, 255));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPrincipalMouseClicked(evt);
            }
        });
        panelPrincipal.setLayout(new java.awt.GridLayout(1, 0));
        scrollPanePrincipal.setViewportView(panelPrincipal);

        PanelProductosArmarPC.add(scrollPanePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 400));

        PanelPagoPc.setBackground(new java.awt.Color(255, 255, 255));
        PanelPagoPc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        lblResumen.setForeground(new java.awt.Color(255, 255, 255));
        lblResumen.setText("RESUMEN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(lblResumen)
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        PanelPagoPc.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, -1));

        btnAgregarCarrito.setText("Agregar al carrito");
        btnAgregarCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarCarritoMouseClicked(evt);
            }
        });
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });
        PanelPagoPc.add(btnAgregarCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 150, 40));

        lblSistemaEnfriamentoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblSistemaEnfriamentoColor.setText("SISTEMA DE ENFRIAMIENTO");
        PanelPagoPc.add(lblSistemaEnfriamentoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        lblProcesadorColor.setForeground(new java.awt.Color(0, 0, 0));
        lblProcesadorColor.setText("PROCESADOR");
        PanelPagoPc.add(lblProcesadorColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblPlacaMadreColor.setForeground(new java.awt.Color(0, 0, 0));
        lblPlacaMadreColor.setText("PLACA MADRE");
        PanelPagoPc.add(lblPlacaMadreColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lblMemoriaRAMColor.setForeground(new java.awt.Color(0, 0, 0));
        lblMemoriaRAMColor.setText("MEMORIA RAM");
        PanelPagoPc.add(lblMemoriaRAMColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lblAlmacenamientoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblAlmacenamientoColor.setText("ALMACENAMIENTO");
        PanelPagoPc.add(lblAlmacenamientoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        lblTarjetaDeVideoColor.setForeground(new java.awt.Color(0, 0, 0));
        lblTarjetaDeVideoColor.setText("TARJETA DE VIDEO");
        PanelPagoPc.add(lblTarjetaDeVideoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lblGabineteColor.setForeground(new java.awt.Color(0, 0, 0));
        lblGabineteColor.setText("GABINETE");
        PanelPagoPc.add(lblGabineteColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lblFuentePoderColor.setForeground(new java.awt.Color(0, 0, 0));
        lblFuentePoderColor.setText("FUENTE DE PODER");
        PanelPagoPc.add(lblFuentePoderColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProductosArmarPC, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPagoPc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelProductosArmarPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPagoPc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

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
        clasificarItems(lblAlmacenamiento, lblAlmacenamientoColor);
    }//GEN-LAST:event_btnAlmacenamientoMouseClicked

    private void btnTarjetaDeVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTarjetaDeVideoMouseClicked
        clasificarItems(lblTarjetaDeVideo, lblTarjetaDeVideoColor);
    }//GEN-LAST:event_btnTarjetaDeVideoMouseClicked

    private void btnGabineteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGabineteMouseClicked
        clasificarItems(lblGabinete, lblGabineteColor);
    }//GEN-LAST:event_btnGabineteMouseClicked

    private void btnFuenteDePoderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFuenteDePoderMouseClicked
        clasificarItems(lblFuenteDePoder, lblFuentePoderColor);
    }//GEN-LAST:event_btnFuenteDePoderMouseClicked

    private void btnEnfriamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnfriamientoMouseClicked
        clasificarItems(lblEnfriamento, lblSistemaEnfriamentoColor);
    }//GEN-LAST:event_btnEnfriamientoMouseClicked

    private void panelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPrincipalMouseClicked

    }//GEN-LAST:event_panelPrincipalMouseClicked

    private void btnAgregarCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarCarritoMouseClicked
        
        for(Producto producto : productosElegidos){
            Object o[] = new Object[3];
            o[0] = carrito.getIdCarrito();
            o[1] = producto.getId();
            o[2] = 1;
            DetalleCarritoDAO d =  new DetalleCarritoDAO();
            d.agregar(o);
            int stockActualizado = producto.getStock() - 1 ;
            producto.setStock(stockActualizado);
            ProductoDAO p = new ProductoDAO();
            p.actualizarStock(producto.getId(), stockActualizado);
        }
        JOptionPane.showMessageDialog(null, "Productos en el carrito");
    }//GEN-LAST:event_btnAgregarCarritoMouseClicked

    public void clasificarItems(JLabel name, JLabel nameColor){
        this.componenteVar = name.getText();
        this.nombreVar = nameColor;
        try {
           establecerItems();
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAlmacenamiento;
    private javax.swing.JLabel lblAlmacenamientoColor;
    private javax.swing.JLabel lblComponentes;
    private javax.swing.JLabel lblEnfriamento;
    private javax.swing.JLabel lblFuenteDePoder;
    private javax.swing.JLabel lblFuentePoderColor;
    private javax.swing.JLabel lblGabinete;
    private javax.swing.JLabel lblGabineteColor;
    private javax.swing.JLabel lblInfoAlmacenamiento;
    private javax.swing.JLabel lblInfoEnfriamento;
    private javax.swing.JLabel lblInfoFuenteDePoder;
    private javax.swing.JLabel lblInfoGabinete;
    private javax.swing.JLabel lblInfoMemoriaRAM;
    private javax.swing.JLabel lblInfoPlacaMadre;
    private javax.swing.JLabel lblInfoProcesador;
    private javax.swing.JLabel lblInfoTarjetaDeVideo;
    private javax.swing.JLabel lblMemoriaRAM;
    private javax.swing.JLabel lblMemoriaRAMColor;
    private javax.swing.JLabel lblPlacaMadre;
    private javax.swing.JLabel lblPlacaMadreColor;
    private javax.swing.JLabel lblProcesador;
    private javax.swing.JLabel lblProcesadorColor;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblResumen;
    private javax.swing.JLabel lblSistemaEnfriamentoColor;
    private javax.swing.JLabel lblTarjetaDeVideo;
    private javax.swing.JLabel lblTarjetaDeVideoColor;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollPanePrincipal;
    // End of variables declaration//GEN-END:variables
}
