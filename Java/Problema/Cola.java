package Problema;
import java.util.ArrayList;

public class Cola {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void enqueue(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket dequeue() {
        if (tickets.isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return tickets.remove(0);
    }

    public void mostrar() {
        if (tickets.isEmpty()) {
            System.out.println("La cola está vacía");
        } else {

            for (Ticket ticket : tickets) {
                ticket.mostrar();
            }
        }
    }

    public boolean isEmpty() {
        return tickets.isEmpty();
    }
}