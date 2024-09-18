package jdbc1.options;

import javax.persistence.EntityManager;

import jdbc1.Carrera;
import jdbc1.Estudia;
import jdbc1.Estudiante;

public class InsertFactory {

    public void insertarEstudiante(EntityManager em, Estudiante estudiante) {
        em.getTransaction().begin();
        
        em.merge(estudiante);
    
        em.getTransaction().commit();
    }
    
    public void insertarCarrera(EntityManager em, Carrera c1) {
            em.getTransaction().begin();
            em.merge(c1);
            em.getTransaction().commit();
    }
    
    public void InsertarEstudia(EntityManager em, Estudia e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }
}
   