package jdbc1.options;
import java.util.List;
import javax.persistence.EntityManager;

// recuperar un estudiante, en base a su número de libreta universitaria.
public class Query4 implements query{
	
	private String LU;

	public Query4(String LU) {
		this.LU = LU;
	}
	
	@Override
	public List<Object[]> buscarEstudiantes(EntityManager em) {

		String jpql = "SELECT e.estudiante.*"
				+ "FROM Estudiante e"
				+ "WHERE e.estudiante.LU = :LU";
		
		List<Object[]> res = em.createQuery(jpql, Object[].class)
				.setParameter("LU", LU).getResultList();
		
		return res;
	}
	
}
