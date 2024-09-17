package jdbc1.options;
import java.util.List;
import javax.persistence.EntityManager;

//	recuperar todos los estudiantes, en base a su género. 
public class Query5 implements query{

	private String genero;
	
	public Query5(String genero) {
		this.genero = genero;
	}

	@Override
	public List<Object[]> buscarEstudiantes(EntityManager em) {
		String jpql = "SELECT e.estudiante.*"
				+ "FROM Estudiante e"
				+ "WHERE e.genero = :genero";
		
		List<Object[]> res = em.createQuery(jpql, Object[].class)
				.setParameter("genero", genero).getResultList();
		
		return res;
	}
}
