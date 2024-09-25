package jdbc1;

import javax.persistence.*;

@Entity
@IdClass(EstudiaId.class)
@Table(name = "Estudia")
public class Estudia {

    @Id
    @Column(name = "LU", nullable = false)
    private int estudiante;

    @Id
    @Column(name = "ID_Carrera", nullable = false)
    private int carrera; 

    @Column(name = "Antiguedad", nullable = false)
    private int antiguedad;

    @Column(name = "Graduado", nullable = false)
    private boolean graduado;

    public Estudia() {}

    public Estudia(int estudiante, int carrera, int antiguedad, boolean graduado) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
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
