package jdbc1.options;

import javax.persistence.EntityManager;
import java.util.List;

public class query6 implements query {

	public List<Object[]> buscarEstudiantes(EntityManager em){
		String jpql = "SELECT e.carrera.nombre, COUNT(e.estudiante) AS inscriptos " +
                		"FROM Estudia e " +
                		"GROUP BY e.carrera.nombre " +
                		"ORDER BY inscriptos DESC";
  
		List<Object[]> resultados = em.createQuery(jpql, Object[].class).getResultList();
	  

		return resultados;
	}
}
