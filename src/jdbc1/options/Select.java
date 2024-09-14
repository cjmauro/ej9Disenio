package jdbc1.options;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Select {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // HQL para obtener el nombre del estudiante, apellido, nombre de la carrera, antigüedad y si es graduado
        String hql = "SELECT e.estudiante.nombre, e.estudiante.apellido, e.carrera.nombre, e.antiguedad, e.graduado " +
                     "FROM Estudia e";
        Query query = em.createQuery(hql);
        List<Object[]> resultList = query.getResultList();
        
        // Mostrar los resultados
        for (Object[] result : resultList) {
            System.out.println("Nombre: " + result[0] + 
                               ", Apellido: " + result[1] + 
                               ", Carrera: " + result[2] + 
                               ", Antigüedad: " + result[3] + 
                               ", Graduado: " + result[4]);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
