package PracticaGuiada;

public class Main {
    public static void main(String[] args) {

        /*numerosNaturales(0, 1);*/
        SumaCubos(5, 1, 0);
        InversionNumeros(123, 3, 0);
    }


    public static void numerosNaturales(int n, int i) {
        if(n == 0){
            System.out.println(n);
        }else if(i<=n){
            System.out.println(i);
            numerosNaturales(n, i+1);
        }
    }

    public static void SumaCubos(int n, int i, int suma) {
        if(n==0){
            System.out.println(n);
        }else if(i<=n){
            suma += Math.pow(i, 3);
            SumaCubos(n, i+1, suma);
        }else{
            System.out.println("La suma: " + suma);
        }
    }

    public static void InversionNumeros(int n, int i, int inversion) {
        if(n==0){
            System.out.println(n);
        }else if(i<=n){
            inversion += (n%10)*Math.pow(10, i-1);
            InversionNumeros(n/10, i+1, inversion);
        }else{
            System.out.println("La inversion: " + inversion);
        }
    }
    


}