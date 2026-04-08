package PR4;
public class PaginaWeb {
    String url;
    String titulo;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo + " (" + url + ")";
    }
}