package tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jdbc1.CarreraDao;

public class TestCarreraDao {

    private static EntityManager entityManager;
    private static CarreraDao carreraDao;

    public static void main(String[] args) {
    	
        setUp();
        
        testEjercicioC();
        testFindEstudiantesPorCarrera();

        tearDown();
    }

    public static void testEjercicioC() {
        System.out.println("Ejecutando testEjercicioC...");
        carreraDao.ejercicioC();
        System.out.println("Ejercicio C ejecutado.");
    }
    
    public static void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        entityManager = emf.createEntityManager();
        carreraDao = new CarreraDao();
        System.out.println("Configuración inicial completa.");
    }

    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        System.out.println("Pruebas finalizadas.");
    }

    public static void testFindEstudiantesPorCarrera() {
        System.out.println("Ejecutando testFindEstudiantesPorCarrera...");
        carreraDao.findEstudiantesPorCarrera();
        System.out.println("Consulta de estudiantes por carrera ejecutada.");
    }


}
