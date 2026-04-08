package Problema;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Cola Cola3raEdad = new Cola();
        Cola ColaVip = new Cola();
        Cola ColaNormal = new Cola();

        String ultimoTipo = "";
        int consecutivo = 0;

        Ticket ticket1 = new Ticket("Juan", "3ra Edad");
        Ticket ticket2 = new Ticket("Maria", "VIP");
        Ticket ticket3 = new Ticket("Carlos", "Normal");
        Ticket ticket4 = new Ticket("Ana", "3ra Edad");
        Ticket ticket5 = new Ticket("Luis", "VIP");
        Ticket ticket6 = new Ticket("Sofia", "Normal");
        Ticket ticket7 = new Ticket("Pedro", "3ra Edad");
        Ticket ticket8 = new Ticket("Lucia", "VIP");
        Ticket ticket9 = new Ticket("Diego", "Normal");
        Ticket ticket10 = new Ticket("Marta", "3ra Edad");  
        Ticket ticket11 = new Ticket("Jorge", "3ra Edad");



        ArrayList<Ticket> tickets = new ArrayList<>();

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);
        tickets.add(ticket11);


        System.out.println("Agregando tickets a las colas...");

        for (Ticket ticket : tickets) {
            if (ticket.getTipo().equals("3ra Edad")) {
                Cola3raEdad.enqueue(ticket);
                
            } else if (ticket.getTipo().equals("VIP")) {
                ColaVip.enqueue(ticket);
                
            } else if (ticket.getTipo().equals("Normal")) {
                ColaNormal.enqueue(ticket);
                
            }
        }

        while (true) {            
            if (!Cola3raEdad.isEmpty() && (!ultimoTipo.equals("3ra Edad") || consecutivo < 4)) {
                Ticket atendido = Cola3raEdad.dequeue();
                System.out.println("Atendiendo a: " + atendido.getNombre() + " (3ra Edad)");
                  if (ultimoTipo.equals("3ra Edad")) {
                    consecutivo++;
                } else {
                    ultimoTipo = "3ra Edad";
                    consecutivo = 1;
                }
            }else if (!ColaVip.isEmpty() && (!ultimoTipo.equals("VIP") || consecutivo < 2)) {
                Ticket atendido = ColaVip.dequeue();
                System.out.println("Atendiendo a: " + atendido.getNombre() + " (VIP)");
                if (ultimoTipo.equals("VIP")) {
                    consecutivo++;
                } else {
                    ultimoTipo = "VIP";
                    consecutivo = 1;
                }
            }else if (!ColaNormal.isEmpty() && (!ultimoTipo.equals("Normal") || consecutivo < 3)) {
                Ticket atendido = ColaNormal.dequeue();
                System.out.println("Atendiendo a: " + atendido.getNombre() + " (Normal)");
                if (ultimoTipo.equals("Normal")) {
                    consecutivo++;
                } else {
                    ultimoTipo = "Normal";
                    consecutivo = 1;
                }
                
            }
        }



    }
}