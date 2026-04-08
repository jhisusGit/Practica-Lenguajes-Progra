package PR3;

public class Main {
    public static void main(String[] args) {
        ColaImpresora impresora = new ColaImpresora();
        impresora.agregarTrabajo(new TrabajoImpresion("Informe.pdf", 10, "Luis"));
        impresora.agregarTrabajo(new TrabajoImpresion("Tarea.docx", 3, "Sofía"));
        impresora.agregarTrabajo(new TrabajoImpresion("Fotos.png", 1, "Pedro"));
        impresora.mostrarPendientes();
        impresora.imprimirSiguiente();
        impresora.imprimirSiguiente();
        impresora.imprimirSiguiente(); // Informe va primero
        impresora.mostrarPendientes();
    }
    
}
