package jdbc1;

public class JpaHibernateFactory extends DAOFactory {
    public static CustomerDAO createEstudianteDao() {
        return new EstudianteDao();
    }

    public static CustomerDAO createCarreraDao() {
        return new CarreraDao();
    }

    public static CustomerDAO createEstudiaDao() {
        return new EstudiaDao();
    }


}
