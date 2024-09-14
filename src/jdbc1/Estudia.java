package jdbc1;

import javax.persistence.*;

@Entity
@IdClass(EstudiaId.class)
@Table(name = "Estudia")
public class Estudia {

    @Id
    @ManyToOne
    @JoinColumn(name = "LU", referencedColumnName = "LU")
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_Carrera", referencedColumnName = "ID_Carrera")
    private Carrera carrera;

    @Column(name = "Antiguedad", nullable = false)
    private int antiguedad;

    @Column(name = "Graduado", nullable = false)
    private boolean graduado;

    // Constructors, getters, setters
    public Estudia() {}

    public Estudia(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "Estudia [estudiante=" + estudiante + ", carrera=" + carrera + ", antiguedad=" + antiguedad + ", graduado=" + graduado + "]";
    }
}
