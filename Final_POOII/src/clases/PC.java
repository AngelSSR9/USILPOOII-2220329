package clases;

import java.util.List;

public class PC {
    private int id;
    private List<Producto> partes;

    public PC(List<Producto> partes) {
        this.partes = partes;
    }
    
    public void add(Producto p){
        partes.add(p);
    }


    
    
    
    
}
