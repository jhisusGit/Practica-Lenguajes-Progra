package Problema;

public class Ticket {
    private String nombre;
    private String tipo;

    public Ticket(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String toString() {
		return "Ticket [nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Tipo: " + tipo);
    }

    
}
