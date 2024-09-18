package jdbc1.options;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {
	  public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
	        EntityManager em = emf.createEntityManager();

	        query queryLU = QueryFactory.getQueryByLU("3");
	        queryLU.EjecutarQuery(em);

	        query queryGenero = QueryFactory.getQueryByGenero("Masculino");
	        queryGenero.EjecutarQuery(em);

	        query queryCarreraCiudad = QueryFactory.getQueryByCarreraAndCiudad("alimentos", "Buenos Aires");
	        queryCarreraCiudad.EjecutarQuery(em);
	        
            query query = QueryFactory.getQueryCountEstudiantesPorCarrera();
            query.EjecutarQuery(em);
	        
	        em.close();
	        emf.close();
	    }
}



