public class PC {
    private MotherBoard motherBoard;
    private Componente procesador;
    private TarjetaGrafica tarjetaGrafica;
    private MemoriaRAM memoriaRAM;
    private MemoriaROM memoriaROM;
    private Refrigeracion refrigeracion;
    
    public MotherBoard getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(MotherBoard motherBoard) {
        this.motherBoard = motherBoard;
    }

    public Componente getProcesador() {
        return procesador;
    }

    public void setProcesador(Componente procesador) {
        this.procesador = procesador;
    }

    public TarjetaGrafica getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public MemoriaRAM getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(MemoriaRAM memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public MemoriaROM getMemoriaROM() {
        return memoriaROM;
    }

    public void setMemoriaROM(MemoriaROM memoriaROM) {
        this.memoriaROM = memoriaROM;
    }

    public Refrigeracion getRefrigeracion() {
        return refrigeracion;
    }

    public void setRefrigeracion(Refrigeracion refrigeracion) {
        this.refrigeracion = refrigeracion;
    }
    
    
    
}
