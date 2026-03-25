package Pila;
class Pila{

    int n;
    int a[];

    // 1 Crear un metodo el cual se encargue del push
    // 2 Crear un metodo el cual se encargue del pop
    // 3 Crear un metodo el cual muestre la pila

    public Pila(){
        n = 0;
        a = new int[100];
    }

    public void pop(){
        n--;
    }

    public void push(int x){
        a[n] = x;
        n++;
    } 

    public void MostrarPila(){
        for(int i = n-1; i >= 0; i--){
            System.out.println(a[i]);
        }
    }
        
    // 4. Crar un metodo que segun x ecuacion revise si los corchetes, llaves, parentesis estan bien escritos. codigo aski

    public boolean Validar(String s){
        for(int i=0;i<s.length() ;i++){
            char c = s.charAt(i);
            if(c == '[' || c == '{' ||  c == '('){
                push(c);
            }else if(c == ')' || c == '}' ||  c == ']'){
                if(n == 0){
                    System.out.println("Error: No hay elementos en la pila para hacer pop");
                    return false;
                }
                char top = (char) a[n-1];
                if((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']')){
                    pop();
                }else{
                    System.out.println("Error: El caracter de cierre no coincide con el caracter de apertura en la pila");
                    return false;
                }
            }

        }
        System.out.println("La pila esta vacia: " + (n == 0));
        System.out.println("Todas las parejas de corchetes, llaves y parentesis estan bien escritos");
        return n == 0;
    }
        
}   