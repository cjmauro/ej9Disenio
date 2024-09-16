package selectInterface;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectSimple implements Select{
	
	private Tabla tabla;
	private FiltroBase filtro;
	private CriterioOrd criterio;
	
	
	public SelectSimple(Tabla tabla, FiltroBase filtro, CriterioOrd criterio) {
		this.tabla = tabla;
		this.filtro = filtro;
		this.criterio = criterio;
		
	}
	
	

	public Tabla getTabla() {
		return tabla;
	}



	public void setTabla(Tabla tabla) {
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
	public void execute() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        // HQL para obtener el nombre del estudiante, apellido, nombre de la carrera, antig�edad y si es graduado
        String hql = "SELECT * " +
                     "FROM " + tabla +
                      filtro.applyFiltro() +
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
