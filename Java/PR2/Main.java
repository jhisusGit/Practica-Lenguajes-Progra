package PR2;

public class Main {
     public static void main(String[] args) {
        
        Editor editor = new Editor();
        editor.realizarAccion("Escribir título");
        editor.realizarAccion("Insertar imagen");
        editor.realizarAccion("Borrar párrafo");
        editor.mostrarHistorial();
        editor.deshacerAccion(); // Deshace "Borrar párrafo"
        editor.mostrarHistorial();
    }
}
