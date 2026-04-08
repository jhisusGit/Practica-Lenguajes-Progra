package PARTE3PGED;

public class Main {
    public static void main(String[] args) {
        ColaAtencion consultorio = new ColaAtencion();
        
        consultorio.agregarPersona(new Persona("Ana", 1));
        consultorio.agregarPersona(new Persona("Carlos", 2));
        consultorio.agregarPersona(new Persona("María", 3));
        consultorio.atenderPersona(); // Ana sale primero
        consultorio.atenderPersona(); // Carlos después
    }
}
