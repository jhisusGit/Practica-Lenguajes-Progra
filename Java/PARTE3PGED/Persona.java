package PARTE3PGED;


public class Persona {
    String nombre;
    int numeroTurno;

    public Persona(String nombre, int numeroTurno) {
        this.nombre = nombre;
        this.numeroTurno = numeroTurno;
    }

    @Override
    public String toString() {
        return "Turno #" + numeroTurno + " - " + nombre;
    }
}