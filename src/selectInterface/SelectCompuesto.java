package selectInterface;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectCompuesto implements Select {
    
    private String tabla1;
    private List<String> tablasJoin;    
    private FiltroBase filtro;
    private CriterioOrd criterio;
    private List<String> condicionesJoin;
    private Agrupamiento a;
    List<String> valores;

    public SelectCompuesto(String tabla1, List<String> tablasJoin, FiltroBase filtro, List<String> valores, List<String> condicionesJoin) {
        this.tabla1 = tabla1;
        this.tablasJoin = tablasJoin;
        this.filtro = filtro;
        this.condicionesJoin = condicionesJoin;
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
        
        StringBuilder hql = new StringBuilder("SELECT " + selects + " FROM " + tabla1);
        
        for (int i = 0; i < tablasJoin.size(); i++) {
            hql.append(" JOIN ").append(tablasJoin.get(i)).append(" ON ").append(condicionesJoin.get(i));
        }

        if (filtro != null) {
            hql.append(" WHERE ").append(filtro.applyFiltro());
        }
        if (a != null) {
            hql.append(" GROUP BY ").append(a.applyCriterio());
        }
        if (criterio != null) {
            hql.append(" ORDER BY ").append(criterio.applyOrdernamiento());
        }

        Query query = em.createQuery(hql.toString());
        List<Object[]> resultList = query.getResultList();

        for (Object[] result : resultList) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
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
        StringBuilder hql = new StringBuilder("SELECT " + selects + " FROM " + tabla1);
        
        for (int i = 0; i < tablasJoin.size(); i++) {
            hql.append(" JOIN ").append(tablasJoin.get(i)).append(" ON ").append(condicionesJoin.get(i));
        }

        if (filtro != null) {
            hql.append(" WHERE ").append(filtro.applyFiltro());
        }
        if (a != null) {
            hql.append(" GROUP BY ").append(a.applyCriterio());
        }
        if (criterio != null) {
            hql.append(" ORDER BY ").append(criterio.applyOrdernamiento());
        }

        return hql.toString();
    }
}
