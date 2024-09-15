package jdbc1.options;
import javax.persistence.EntityManager;

import java.util.List;

public class query7 implements query {

    private String nombreCarrera;
    private String ciudadResidencia;


    public query7(String nombreCarrera, String ciudadResidencia) {
        this.nombreCarrera = nombreCarrera;
        this.ciudadResidencia = ciudadResidencia;
    }

    public List<Object[]> buscarEstudiantes(EntityManager em) {
        String jpql = "SELECT e.estudiante.nombre, e.estudiante.apellido, e.estudiante.ciudadResidencia " +
                      "FROM Estudia e " +
                      "WHERE e.carrera.nombre = :nombreCarrera " +
                      "AND e.estudiante.ciudadResidencia = :ciudadResidencia";
        
        List<Object[]> resultados = em.createQuery(jpql, Object[].class)
                                      .setParameter("nombreCarrera", nombreCarrera)
                                      .setParameter("ciudadResidencia", ciudadResidencia)
                                      .getResultList();
        
        return resultados;
    }
}
