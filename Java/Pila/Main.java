package Pila;

public class Main {
    public static void main(String[] args) {
        
        Pila p = new Pila();
        Pila Str = new Pila();
        p.push(5);
        p.push(10);
        p.push(15);

        p.MostrarPila();
        p.pop();
        System.out.println("Despues del pop");
        p.MostrarPila();

        System.out.println("Validando la cadena ({[]})");
        Str.Validar("({[]})");
    }
}
