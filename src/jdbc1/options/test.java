package jdbc1.options;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {
	  public static void main(String[] args) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
	        EntityManager em = emf.createEntityManager();

	        System.out.println("Resultados de query6 - Cantidad de inscriptos por carrera:");
	        query6 consulta6 = new query6();
	        List<Object[]> resultados6 = consulta6.buscarEstudiantes(em);
			for (Object[] fila : resultados6) {
	            for (Object valor : fila) {
	                System.out.print(valor + " ");  
	            }
	            System.out.println();
		    }
			
	        System.out.println("\n"); 

	        System.out.println("Resultados de query7 - Estudiantes de 'alimentos' en Buenos Aires:");
	        query7 consulta7 = new query7("alimentos", "Buenos Aires");
	        List<Object[]> resultados7 = consulta7.buscarEstudiantes(em);
	        for (Object[] fila : resultados7) {
	            for (Object valor : fila) {
	                System.out.print(valor + " ");  
	            }
	            System.out.println();
		    }
	        
	        
	        em.close();
	        emf.close();
	    }
}
