package PARTE3PGED;

import java.util.ArrayDeque;
import java.util.Queue;

public class ColaAtencion {

    Queue<Persona> cola = new ArrayDeque<>();

    public void agregarPersona(Persona p) {
        cola.offer(p);
        System.out.println("Agregado: " + p);
    }

    public void atenderPersona() {
        if (cola.isEmpty()) {
            System.out.println("No hay personas en espera.");
            return;
        }
        Persona atendida = cola.poll();
        System.out.println("Atendiendo: " + atendida);
    }

    
}