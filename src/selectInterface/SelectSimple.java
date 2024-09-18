package selectInterface;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectSimple implements Select{
	
	private String tabla;
	private FiltroBase filtro;
	private CriterioOrd criterio;
	private Agrupamiento a;
	List<String> valores;
	
	public SelectSimple(String tabla, FiltroBase filtro, List<String> valores) {
		this.tabla = tabla;
		this.filtro = filtro;
		this.valores = valores;
		this.setCriterio(null);
		this.setAgrupamiento(null);
	}
	
	
	public String getTabla() {
		return tabla;
	}



	public void setTabla(String tabla) {
		this.tabla = tabla;
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
	public List<Object[]> execute() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
	    EntityManager em = emf.createEntityManager();
	    
	    em.getTransaction().begin();
	    
	    String selects = String.join(", ", valores);
	    
	    // HQL para obtener el nombre del estudiante, apellido, nombre de la carrera, antigüedad y si es graduado
	    String hql = "SELECT " + selects + " FROM " + tabla;
	    
	    if (filtro != null) {
	        hql += " WHERE " + filtro.applyFiltro();
	    }
	    
	    if (criterio != null) {
	        hql += criterio.applyOrdernamiento();
	    }
	    
	    if (a != null) {
	        hql += a.applyCriterio();
	    }
	    
	    Query query = em.createQuery(hql);
	    List<Object[]> resultList = query.getResultList();
	    
        for (Object[] result : resultList) {
            for (int i = 0; i < result.length; i++) {
            	
            	System.out.print(result[i]+ " "); 
            }
            System.out.println();
        }
	    
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	    
	    return resultList;
	}


	public Agrupamiento getAgrupamiento() {
		return a;
	}


	public void setAgrupamiento(Agrupamiento criterio) {
		this.a = criterio;
	}

	public String getSQL() {
		String selects = String.join(", ", valores);
		String hql = "SELECT " + selects + " FROM " + tabla;
	    if (filtro != null) {
	        hql += " WHERE " + filtro.applyFiltro();
	    }
	    
	    if (criterio != null) {
	        hql += criterio.applyOrdernamiento();
	    }
	    
	    if (a != null) {
	        hql += a.applyCriterio();
	    }
		return hql;
	}
	
}
