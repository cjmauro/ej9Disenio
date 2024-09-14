package jdbc1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estudiante {

    @Id
    @Column(name = "LU", nullable = false)
    private int LU;
    
    @Column(name = "DNI", nullable = false)
    private int DNI;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Apellido", nullable = false)
    private String apellido;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "Ciudad_Residencia")
    private String ciudadResidencia;
    
    
    public Estudiante() {
        super();
    }

    public Estudiante(int numeroLibretaUniversitaria, int numeroDocumento, String nombre, String apellido, int edad, String genero, String ciudadResidencia) {
        this.LU = numeroLibretaUniversitaria;
        this.DNI = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getNumeroLibretaUniversitaria() {
        return LU;
    }

    public int getNumeroDocumento() {
        return DNI;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.DNI = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "Estudiante [numeroLibretaUniversitaria=" + LU + ", numeroDocumento=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia + "]";
    }
}
