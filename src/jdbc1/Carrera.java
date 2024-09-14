package jdbc1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carrera")
public class Carrera {

    @Id
    @Column(name = "ID_Carrera")
    private int id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    public Carrera() {}

    public Carrera(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera [id=" + id + ", nombre=" + nombre + "]";
    }
}
