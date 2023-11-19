package diseño;

/**
 *
 * @author david
 */

import dashboard.NewMenuCliente;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AnimateBTT {

    private void mostrarColor(RoundedPanelGradient paneX, RoundedPanelGradient paneZ, JLabel lblx, String url) {
        paneX.setBackground(new Color(0,0,255));//Color a mostrar
        paneZ.setColorGradient(new Color(255,0,255));//Color a mostrar
        lblx.setForeground(Color.WHITE);//Color de texto a mostrar

        lblx.setIcon(new ImageIcon(getClass().getResource(url)));//Cambiar icono a blanco
    }

    private void establecColor(RoundedPanelGradient paneX, RoundedPanelGradient paneZ, JLabel lblx, String url) {
        paneX.setBackground(new Color(23, 27, 36));//Color por defecto
        paneZ.setColorGradient(new Color(23, 27, 36));//Color por defecto
        lblx.setForeground(new Color(166, 166, 166));//Color de texto por defecto

        lblx.setIcon(new ImageIcon(getClass().getResource(url)));//Cambiar icono a gris
    }

    public void AnimattCarrito() {
        mostrarColor(NewMenuCliente.btnCarritoCompras, NewMenuCliente.btnCarritoCompras, NewMenuCliente.txtCarrito, "/dashboardimg/carro.png");
        establecColor(NewMenuCliente.btnProductos, NewMenuCliente.btnProductos, NewMenuCliente.txtProductos, "/dashboardimg/producto.png");
        establecColor(NewMenuCliente.btnArmarPc, NewMenuCliente.btnArmarPc, NewMenuCliente.txtArmarPC, "/dashboardimg/armar.png");
        establecColor(NewMenuCliente.btnHistorial, NewMenuCliente.btnHistorial, NewMenuCliente.txtHistorial, "/dashboardimg/historial.png");
        establecColor(NewMenuCliente.btnAjustes, NewMenuCliente.btnAjustes, NewMenuCliente.txtAjustes, "/dashboardimg/ajuste.png");
    }

    public void AnimattProductos() {
        mostrarColor(NewMenuCliente.btnProductos, NewMenuCliente.btnProductos, NewMenuCliente.txtProductos, "/dashboardimg/producto.png");
        establecColor(NewMenuCliente.btnCarritoCompras, NewMenuCliente.btnCarritoCompras, NewMenuCliente.txtCarrito, "/dashboardimg/carro.png");
        establecColor(NewMenuCliente.btnArmarPc, NewMenuCliente.btnArmarPc, NewMenuCliente.txtArmarPC, "/dashboardimg/armar.png");
        establecColor(NewMenuCliente.btnHistorial, NewMenuCliente.btnHistorial, NewMenuCliente.txtHistorial, "/dashboardimg/historial.png");
        establecColor(NewMenuCliente.btnAjustes, NewMenuCliente.btnAjustes, NewMenuCliente.txtAjustes, "/dashboardimg/ajuste.png");
    }

    public void AnimattArmarPC() {
        mostrarColor(NewMenuCliente.btnArmarPc, NewMenuCliente.btnArmarPc, NewMenuCliente.txtArmarPC, "/dashboardimg/armar.png");
        establecColor(NewMenuCliente.btnProductos, NewMenuCliente.btnProductos, NewMenuCliente.txtProductos, "/dashboardimg/producto.png");
        establecColor(NewMenuCliente.btnCarritoCompras, NewMenuCliente.btnCarritoCompras, NewMenuCliente.txtCarrito, "/dashboardimg/carro.png");
        establecColor(NewMenuCliente.btnHistorial, NewMenuCliente.btnHistorial, NewMenuCliente.txtHistorial, "/dashboardimg/historial.png");
        establecColor(NewMenuCliente.btnAjustes, NewMenuCliente.btnAjustes, NewMenuCliente.txtAjustes, "/dashboardimg/ajuste.png");
    }
    
    public void AnimattHistorial() {
        mostrarColor(NewMenuCliente.btnHistorial, NewMenuCliente.btnHistorial, NewMenuCliente.txtHistorial, "/dashboardimg/historial.png");
        establecColor(NewMenuCliente.btnArmarPc, NewMenuCliente.btnArmarPc, NewMenuCliente.txtArmarPC, "/dashboardimg/armar.png");
        establecColor(NewMenuCliente.btnProductos, NewMenuCliente.btnProductos, NewMenuCliente.txtProductos, "/dashboardimg/producto.png");
        establecColor(NewMenuCliente.btnCarritoCompras, NewMenuCliente.btnCarritoCompras, NewMenuCliente.txtCarrito, "/dashboardimg/carro.png");
        establecColor(NewMenuCliente.btnAjustes, NewMenuCliente.btnAjustes, NewMenuCliente.txtAjustes, "/dashboardimg/ajuste.png");
    }
    
    public void AnimattAjustes() {
        mostrarColor(NewMenuCliente.btnAjustes, NewMenuCliente.btnAjustes, NewMenuCliente.txtAjustes, "/dashboardimg/ajuste.png");
        establecColor(NewMenuCliente.btnHistorial, NewMenuCliente.btnHistorial, NewMenuCliente.txtHistorial, "/dashboardimg/historial.png");
        establecColor(NewMenuCliente.btnArmarPc, NewMenuCliente.btnArmarPc, NewMenuCliente.txtArmarPC, "/dashboardimg/armar.png");
        establecColor(NewMenuCliente.btnProductos, NewMenuCliente.btnProductos, NewMenuCliente.txtProductos, "/dashboardimg/producto.png");
        establecColor(NewMenuCliente.btnCarritoCompras, NewMenuCliente.btnCarritoCompras, NewMenuCliente.txtCarrito, "/dashboardimg/carro.png");
    }
}