package jdbc1;

import java.io.Serializable;
import java.util.Objects;

public class EstudiaId implements Serializable {

    private int estudiante;
    private int carrera;

    public EstudiaId() {}

    public EstudiaId(int estudiante, int carrera) {
        this.estudiante = estudiante;
        this.carrera = carrera;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudiaId that = (EstudiaId) o;
        return estudiante == that.estudiante && carrera == that.carrera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudiante, carrera);
    }
}
