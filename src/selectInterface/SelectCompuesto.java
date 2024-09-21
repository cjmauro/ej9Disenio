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
	private Agrupamiento a;
	List<String> valores;
	
	
	public SelectCompuesto(String tabla1, String tabla2, FiltroBase filtro, List<String> valores) {
		this.tabla1 = tabla1;
		this.tabla2 = tabla2;
		this.filtro = filtro;
		this.valores = valores;
		this.setCriterio(null);
		this.setAgrupamiento(null);
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

	public String getTabla2() {
		return tabla2;
	}

	public void setTabla2(String tabla2) {
		this.tabla2 = tabla2;
	}

	public String getTabla1() {
		return tabla1;
	}

	public void setTabla1(String tabla1) {
		this.tabla1 = tabla1;
	}
	
	
	@Override
	public List<Object[]> execute() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
		String selects = String.join(", ", valores);
        // HQL para obtener el nombre del estudiante, apellido, nombre de la carrera, antig�edad y si es graduado
        String hql = "SELECT " + selects +
                     " FROM " + tabla1 + " JOIN " + tabla2;

        if (filtro != null) {
	    	
	        hql += " WHERE " + filtro.applyFiltro();
	    }
	    
	    if (a != null) {

	        hql += " GROUP BY " + a.applyCriterio();
	    }
	    
	    
	    if (criterio != null) {
	        hql += " ORDER BY " + criterio.applyOrdernamiento();
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
	
	public void setAgrupamiento(Agrupamiento criterio) {
		this.a = criterio;
	}

	public String getSQL() {
		String selects = String.join(", ", valores);
		String hql = "SELECT " + selects +
	                 " FROM " + tabla1 + " JOIN " + tabla2;
	
	    if (filtro != null) {
	    	
	        hql += " WHERE " + filtro.applyFiltro();
	    }
	    
	    if (a != null) {
	
	        hql += " GROUP BY " + a.applyCriterio();
	    }
	    
	    
	    if (criterio != null) {
	        hql += " ORDER BY " + criterio.applyOrdernamiento();
	    }

		return hql;
	}
	


	

}
