package tests;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jdbc1.Estudiante;
import jdbc1.EstudianteDao;
public class TestEstudianteDao{

    private static EntityManager entityManager;
    private static EstudianteDao estudianteDao;

    public static void main(String[] args) {
        setUp();

        testPersist();
        testFindById();
        testDelete();
        testFindAll();
        testFindByLU();
        testFindByGenero();

        tearDown();
    }

    public static void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        entityManager = emf.createEntityManager();
        estudianteDao = new EstudianteDao();
        System.out.println("Configuración inicial completa.");
    }

    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        System.out.println("Pruebas finalizadas.");
    }

    public static void testPersist() {
        System.out.println("Ejecutando testPersist...");
        entityManager.getTransaction().begin();
        
        Estudiante nuevoEstudiante = new Estudiante(56433, 45345, "juan", "perez", 23, "masculino", "tandil");
        
        Estudiante resultado = (Estudiante) estudianteDao.persist(nuevoEstudiante);
        if (resultado != null) {
            System.out.println("Estudiante insertado correctamente.");
        } else {
            System.out.println("Error al persistir el estudiante.");
        }

        entityManager.getTransaction().commit();
    }

    public static void testFindById() {
        System.out.println("Ejecutando testFindById...");
        Estudiante estudiante = (Estudiante) estudianteDao.findById(12345);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante.getNombre() + " " + estudiante.getApellido());
        } else {
            System.out.println("No se encontro el estudiante con LU 12345.");
        }
    }

    public static void testDelete() {
        System.out.println("Ejecutando testDelete...");
        entityManager.getTransaction().begin();

        Estudiante estudianteTemp = new Estudiante(12345, 123456, "mauro", "belmonte", 22, "masculino", "tandil");
        estudianteDao.persist(estudianteTemp);

        estudianteDao.delete(67890);

        Estudiante estudianteEliminado = (Estudiante)estudianteDao.findById(67890);
        if (estudianteEliminado == null) {
            System.out.println("El estudiante fue eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el estudiante.");
        }

        entityManager.getTransaction().commit();
    }

    public static void testFindAll() {
        System.out.println("Ejecutando testFindAll...");
        List<Estudiante> estudiantes = estudianteDao.findAll();
        if (estudiantes != null && !estudiantes.isEmpty()) {
            System.out.println("Se encontraron " + estudiantes.size() + " estudiantes en la base de datos.");
        } else {
            System.out.println("No se encontraron estudiantes en la base de datos.");
        }
    }

    public static void testFindByLU() {
        System.out.println("Ejecutando testFindByLU...");
        estudianteDao.findByLU("12345");
        System.out.println("Busqueda por LU ejecutada.");
    }

    public static void testFindByGenero() {
        System.out.println("Ejecutando testFindByGenero...");
        estudianteDao.findByGenero("Masculino");
        System.out.println("Busqueda por genero ejecutada.");
    }
}
