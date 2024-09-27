package cl.ucn.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="recursos")
public class RecursosMultimedia implements MultimediaInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String tipo;
    private boolean protegido;
    @OneToMany(mappedBy = "recursosMultimedia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios;

    public void cargar() {
        // Simula la carga de un archivo grande en memoria
        System.out.println("Cargando el archivo: " + nombre + " (" + tipo + ")");
    }

    public void mostrar() {
        System.out.println("Mostrando el archivo: " + nombre + " (" + tipo + ")");
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isProtegido() {
        return protegido;
    }

    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }
}
