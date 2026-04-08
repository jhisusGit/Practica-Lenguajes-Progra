package PR2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Accion {
    String descripcion;
    String hora;

    public Accion(String descripcion) {
        this.descripcion = descripcion;
        this.hora = LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "[" + hora + "] " + descripcion;
    }
}