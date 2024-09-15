package jdbc1.options;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class query6 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // Consulta JPQL para contar la cantidad de inscriptos por carrera, filtrando solo las que tienen estudiantes
        String jpql = "SELECT e.carrera.nombre, COUNT(e.estudiante) AS inscriptos " +
                      "FROM Estudia e " +
                      "GROUP BY e.carrera.nombre " +
                      "HAVING COUNT(e.estudiante) > 0 " +  // Solo las carreras con estudiantes inscriptos
                      "ORDER BY inscriptos DESC";
        
        List<Object[]> resultados = em.createQuery(jpql, Object[].class).getResultList();
        
        // Mostrar resultados
        for (Object[] resultado : resultados) {
            String nombreCarrera = (String) resultado[0];
            Long cantidadInscriptos = (Long) resultado[1];
            
            System.out.println("Carrera: " + nombreCarrera + ", Cantidad de inscriptos: " + cantidadInscriptos);
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
