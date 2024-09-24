package jdbc1;

public abstract class DAOFactory {
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;
	public static final int JPA_HIBERNATE = 3;
	
    public static CustomerDAO createEstudianteDao;
    public static CustomerDAO createCarreraDao;
    public static CustomerDAO createEstudiaDao;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			//case MYSQL_JDBC : return new MySqlJDBCDAOFactory();
			//case DERBY_JDBC: return new DerbyJDBCDAOFactory();
			case JPA_HIBERNATE: return new JpaHibernateFactory();
			default: return null;
		}
	}
}


