package selectInterface;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectCompuesto implements Select{
	
	private String tabla1;
	private String tabla2;
	private FiltroBase filtro;
	private CriterioOrd criterio;
	

	public SelectCompuesto(String tabla1, String tabla2, FiltroBase filtro, CriterioOrd criterio) {
		this.tabla1 = tabla1;
		this.tabla2 = tabla2;
		this.filtro = filtro;
		this.criterio = criterio;
	}

	public String getTabla1() {
		return tabla1;
	}

	public void setTabla1(String tabla1) {
		this.tabla1 = tabla1;
	}

	public String getTabla2() {
		return tabla2;
	}

	public void setTabla2(String tabla2) {
		this.tabla2 = tabla2;
	}

	public FiltroBase getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroBase filtro) {
		this.filtro = filtro;
	}

	public CriterioOrd getCriterio() {
		return criterio;
	}




	public void setCriterio(CriterioOrd criterio) {
		this.criterio = criterio;
	}
	
	@Override
	public void execute() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // HQL para obtener el nombre del estudiante, apellido, nombre de la carrera, antig�edad y si es graduado
        String hql = "SELECT * " +
                     "FROM " + tabla1 + " JOIN " + tabla2 +
                      "WHERE" + filtro.applyFiltro() +
                      criterio.applyOrdernamiento();
        Query query = em.createQuery(hql);
        List<Object[]> resultList = query.getResultList();
        
        // Mostrar los resultados
        for (Object[] result : resultList) {
            System.out.println("Nombre: " + result[0] + 
                               ", Apellido: " + result[1] + 
                               ", Carrera: " + result[2] + 
                               ", Antig�edad: " + result[3] + 
                               ", Graduado: " + result[4]);
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
	}



	

}
