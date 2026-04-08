package PR4;
import java.util.Stack;

public class Navegador {
    Stack<PaginaWeb> historial = new Stack<>();

    public void visitarPagina(String url, String titulo) {
        PaginaWeb pagina = new PaginaWeb(url, titulo);
        historial.push(pagina);
        System.out.println("Visitando: " + pagina);
    }

    public void retroceder() {
        if (historial.size() <= 1) {
            System.out.println("No hay página anterior.");
            return;
        }
        PaginaWeb salida = historial.pop();
        System.out.println("Saliendo de: " + salida);
        System.out.println("Volviendo a: " + historial.peek());
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Sin historial.");
            return;
        }
        System.out.println("--- Historial del navegador ---");
        for (int i = historial.size() - 1; i >= 0; i--) {
            String marcador = (i == historial.size() - 1) ? " ← actual" : "";
            System.out.println("  " + historial.get(i) + marcador);
        }
    }

   
}