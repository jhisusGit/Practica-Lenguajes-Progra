package PR3;

public class TrabajoImpresion {
    String nombreDocumento;
    int numeroPaginas;
    String remitente;

    public TrabajoImpresion(String nombreDocumento, int numeroPaginas, String remitente) {
        this.nombreDocumento = nombreDocumento;
        this.numeroPaginas = numeroPaginas;
        this.remitente = remitente;
    }

    @Override
    public String toString() {
        return "\"" + nombreDocumento + "\" (" + numeroPaginas + " págs) de " + remitente;
    }
}