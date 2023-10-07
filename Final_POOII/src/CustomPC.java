public class CustomPC extends PC {

    public static class Builder {

        private MotherBoard motherBoard;
        private Componente procesador;
        private TarjetaGrafica tarjetaGrafica;
        private MemoriaRAM memoriaRAM;
        private MemoriaROM memoriaROM;
        private Refrigeracion refrigeracion;

        public MotherBoard getMotherBoard() {
            return motherBoard;
        }

        public CustomPC.Builder setMotherBoard(MotherBoard motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        public Componente getProcesador() {
            return procesador;
        }

        public CustomPC.Builder setProcesador(Componente procesador) {
            this.procesador = procesador;
            return this;
        }

        public TarjetaGrafica getTarjetaGrafica() {
            return tarjetaGrafica;
        }

        public CustomPC.Builder setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public MemoriaRAM getMemoriaRAM() {
            return memoriaRAM;
        }

        public CustomPC.Builder setMemoriaRAM(MemoriaRAM memoriaRAM) {
            this.memoriaRAM = memoriaRAM;
            return this;
        }

        public MemoriaROM getMemoriaROM() {
            return memoriaROM;
        }

        public CustomPC.Builder setMemoriaROM(MemoriaROM memoriaROM) {
            this.memoriaROM = memoriaROM;
            return this;
        }

        public Refrigeracion getRefrigeracion() {
            return refrigeracion;
        }

        public CustomPC.Builder setRefrigeracion(Refrigeracion refrigeracion) {
            this.refrigeracion = refrigeracion;
            return this;
        }
        
        
    }
}
