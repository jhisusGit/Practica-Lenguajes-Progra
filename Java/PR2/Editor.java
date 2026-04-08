package PR2;
import java.util.Stack;

public class Editor {
    Stack<Accion> historial = new Stack<>();
    

    public void realizarAccion(String descripcion) {
        Accion nueva = new Accion(descripcion);
        historial.push(nueva);
        System.out.println("Acción realizada: " + nueva);
    }

    public void deshacerAccion() {
        if (historial.isEmpty()) {
            System.out.println("Nada que deshacer.");
            return;
        }
        Accion deshecha = historial.pop();
        System.out.println("Deshacer: " + deshecha);
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("--- Historial (más reciente arriba) ---");
        // Stack permite iterar sin destruir el contenido
        for (int i = historial.size() - 1; i >= 0; i--) {
            System.out.println(historial.get(i));
        }
    }

   
}