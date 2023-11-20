package dashboard;

import diseño.MenuCustom;
import diseño.ScrollBarCustom;
import clases.CarritoCompras;
import clases.Cliente;
import clases.PC;
import clases.Producto;
import conexionBD.CarritoDAO;
import conexionBD.PcDAO;
import conexionBD.ProductoDAO;
import java.awt.GridLayout;
import java.util.List;
import javaswingdev.MenuEvent;
import javax.swing.JPanel;

public class PanelProductos extends javax.swing.JPanel {
    PcDAO pcDAO = new PcDAO();
    ProductoDAO productoDAO = new ProductoDAO();
    CarritoDAO c = new CarritoDAO();
    CarritoCompras carrito;
    Cliente cliente;
    List<Producto> productos;

    public PanelProductos(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
        iniciar();
    }

    private void iniciar() {
        MenuCustom menu = new MenuCustom();
        menu.addItem("Periféricos", "Monitor", "Mouse", "Teclado", "Audifono", "Mousepad");
        menu.addItem("Componentes", "Procesador", "Tarjeta de Video", "Memoria RAM", "Placa Madre", "Almacenamiento", "Refrigeracion", "Fuente de poder", "Gabinete");
        menu.addItem("PC");
        //menu.setMenuHeight(40);
        menu.addEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex, boolean menuItem) {
                if(menuItem)
                    establecerItemsFiltrados(menu.getMenuNameAt(index, subIndex).trim().toUpperCase());
            }

        });
        menu.applay(this, panelAux);

        scrollPanePrincipal.setVerticalScrollBar(new ScrollBarCustom());
        GridLayout layout = new GridLayout(0, 4);
        layout.setHgap(5);
        layout.setVgap(5);
        panelPrincipal.setLayout(layout);
    }

    public void establecerItems() {
        setCarrito();
        panelPrincipal.removeAll();
        productos = productoDAO.listar();
        establecerProductos(productos);
    }

    public void establecerItemsFiltrados(String tipo) {
        if(tipo.equals("PC"))
            establecerPCS();
        else
            establecerProductos(filtrar(tipo));
    }

    private List<Producto> filtrar(String tipo) {
        //System.out.println("Nombre item seleccionado: " + tipo);
        return productos.stream()
                .filter(p -> p.getTipo().toUpperCase().equals(tipo)).toList();
    }

    private void establecerProductos(List<Producto> productosList) {
        panelPrincipal.removeAll();

        productosList.stream().forEach(p -> panelPrincipal.add(new PanelItem(p, carrito)));

        // Agregamos paneles ficticios vacíos para completar una fila
        int totalPaneles = productosList.size();
        int panelesFaltantes = 5 - totalPaneles;
        if (panelesFaltantes > 0) {
            for (int i = 0; i < panelesFaltantes; i++) {
                panelPrincipal.add(new JPanel());
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        }
    }
    
    private void establecerPCS(){
        panelPrincipal.removeAll();

        List<PC> listaPC = pcDAO.listar();
        listaPC.stream().forEach(p -> panelPrincipal.add(new PanelItem(p, carrito)));

        // Agregamos paneles ficticios vacíos para completar una fila
        int totalPaneles = listaPC.size();
        int panelesFaltantes = 5 - totalPaneles;
        if (panelesFaltantes > 0) {
            for (int i = 0; i < panelesFaltantes; i++) {
                panelPrincipal.add(new JPanel());
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        }
        
    }
    
    public void setCarrito(){
        this.carrito = c.obtenerCarritoPorIdCliente(cliente.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAux = new javax.swing.JPanel();
        scrollPanePrincipal = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        scrollPanePrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 2, 1, 1));

        panelPrincipal.setLayout(new java.awt.GridLayout(1, 0));
        scrollPanePrincipal.setViewportView(panelPrincipal);

        javax.swing.GroupLayout panelAuxLayout = new javax.swing.GroupLayout(panelAux);
        panelAux.setLayout(panelAuxLayout);
        panelAuxLayout.setHorizontalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuxLayout.createSequentialGroup()
                .addComponent(scrollPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        panelAuxLayout.setVerticalGroup(
            panelAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAuxLayout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addComponent(scrollPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelAux;
    public javax.swing.JPanel panelPrincipal;
    public javax.swing.JScrollPane scrollPanePrincipal;
    // End of variables declaration//GEN-END:variables
}