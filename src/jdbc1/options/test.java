package jdbc1.options;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {
	  public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
	        EntityManager em = emf.createEntityManager();

	        QueryFactory a = new QueryFactory();
	        a.getQueryByLU("3");
	        
	        System.out.println("///////////////////////////////////////////////////////////");
	        a.getQueryByGenero("Masculino");
	        System.out.println("///////////////////////////////////////////////////////////");

	        a.getQueryByCarreraAndCiudad("Ingenieria de Sistemas", "Buenos Aires");
	       
	        System.out.println("///////////////////////////////////////////////////////////");

	        a.getQueryCountEstudiantesPorCarrera();
          	
	        System.out.println("///////////////////////////////////////////////////////////");

          
	        a.getQueryAllEstudiantes("apellido", true);
	        
	        System.out.println("///////////////////////////////////////////////////////////");
	        
	        a.ejercicioC();
	        
	        em.close();
	        emf.close();
	    }
}



