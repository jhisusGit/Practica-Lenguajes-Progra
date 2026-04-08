package PR3;

import java.util.ArrayDeque;
import java.util.Queue;

public class ColaImpresora {
    Queue<TrabajoImpresion> cola = new ArrayDeque<>();

    public void agregarTrabajo(TrabajoImpresion trabajo) {
        cola.offer(trabajo);
        System.out.println("En cola: " + trabajo);
    }

    public void imprimirSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("No hay trabajos pendientes.");
            return;
        }
        TrabajoImpresion actual = cola.poll();
        System.out.println("Imprimiendo: " + actual);
    }

    public void mostrarPendientes() {
        if (cola.isEmpty()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.println("Trabajos pendientes: " + cola.size());
        for (TrabajoImpresion t : cola) {
            System.out.println("  - " + t);
        }
    }

    
}