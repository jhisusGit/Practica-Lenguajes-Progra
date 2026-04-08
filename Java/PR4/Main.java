package PR4;

public class Main {

     public static void main(String[] args) {
        Navegador nav = new Navegador();
        nav.visitarPagina("https://google.com", "Google");
        nav.visitarPagina("https://wikipedia.org", "Wikipedia");
        nav.visitarPagina("https://github.com", "GitHub");
        nav.mostrarHistorial();
        nav.retroceder(); 
        nav.retroceder(); 
        nav.retroceder(); 
        nav.mostrarHistorial();
    }
    
}
