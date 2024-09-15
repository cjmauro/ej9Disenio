package jdbc1.options;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class query7 {
	    public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
	        EntityManager em = emf.createEntityManager();
	        
	        em.getTransaction().begin();
	        
	        // Definir los parámetros de búsqueda
	        String nombreCarrera = "alimentos";  // Carrera que quieres buscar
	        String ciudadResidencia = "Buenos Aires";  // Ciudad de residencia que quieres filtrar
	        
	        // Consulta JPQL para obtener estudiantes de una carrera específica y filtrados por ciudad de residencia
	        String jpql = "SELECT e.estudiante.nombre, e.estudiante.apellido, e.estudiante.ciudadResidencia " +
	                      "FROM Estudia e " +
	                      "WHERE e.carrera.nombre = :nombreCarrera " +
	                      "AND e.estudiante.ciudadResidencia = :ciudadResidencia";
	        
	        List<Object[]> resultados = em.createQuery(jpql, Object[].class)
	                                      .setParameter("nombreCarrera", nombreCarrera)
	                                      .setParameter("ciudadResidencia", ciudadResidencia)
	                                      .getResultList();
	        
	        // Mostrar resultados
	        for (Object[] resultado : resultados) {
	            String nombre = (String) resultado[0];
	            String apellido = (String) resultado[1];
	            String ciudad = (String) resultado[2];
	            
	            System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Ciudad de Residencia: " + ciudad);
	        }
	        
	        em.getTransaction().commit();
	        em.close();
	        emf.close();
	    }
	}
