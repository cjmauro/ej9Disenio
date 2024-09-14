package jdbc1.options;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jdbc1.Carrera;
import jdbc1.Estudiante;
import jdbc1.Estudia;

public class Insert {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
       
        // Insertar estudiantes
        Estudiante estudiante1 = new Estudiante(2, 12345678, "valen", "leiba", 20, "Masculino", "Buenos Aires");
        Estudiante estudiante2 = new Estudiante(1, 87654321, "Laura", "Gómez", 22, "Femenino", "Córdoba");
        em.merge(estudiante1);
        em.merge(estudiante2);
        
        
        
        Carrera c1 = new Carrera(2, "alimentos");
        em.merge(c1);
        
        Estudia e = new Estudia(estudiante1, c1, 10, false);
        em.merge(e);
   
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
