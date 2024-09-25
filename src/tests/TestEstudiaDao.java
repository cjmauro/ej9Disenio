package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jdbc1.Estudia;
import jdbc1.EstudiaDao;

public class TestEstudiaDao {

    private static EntityManager entityManager;
    private static EstudiaDao estudiaDao;

    public static void main(String[] args) {
        setUp();
        
        persist();
        testQueryByCarreraAndCiudad();

        tearDown();
    }

    public static void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        entityManager = emf.createEntityManager();
        estudiaDao = new EstudiaDao();
        System.out.println("Configuración inicial completa.");
    }
    
    
    public static void persist() {
        System.out.println("Ejecutando testInsertEstudia...");
        Estudia nuevoEstudia = new Estudia(12345, 1, 3, true); // Ejemplo de datos: estudiante, carrera, antigüedad, graduado
        
        Estudia resultado = (Estudia) estudiaDao.persist(nuevoEstudia);
        
        

        if (resultado != null) {
            System.out.println("Estudia insertado correctamente:");
        } else {
            System.out.println("Error al persistir el estudio.");
        }
    }


    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        System.out.println("Pruebas finalizadas.");
    }

    public static void testQueryByCarreraAndCiudad() {
        System.out.println("Ejecutando testQueryByCarreraAndCiudad...");
        estudiaDao.getQueryByCarreraAndCiudad("Ingenieria de Sistemas", "Buenos Aires");
        System.out.println("Consulta por carrera y ciudad ejecutada.");
    }
    
    
    
    
}
