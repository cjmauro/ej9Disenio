package jdbc1.options;

import java.util.List;

import selectInterface.Agrupamiento;
import selectInterface.FiltroBase;
import selectInterface.OrdenamientoColumna;
import selectInterface.SelectSimple;
import javax.persistence.EntityManager;

public class BaseQuery implements query {

	private String entidad;
    private FiltroBase filtro;
    private List<String> valores;
    private Agrupamiento agrupamiento;
    private OrdenamientoColumna criterioOrden;

    public BaseQuery(String entidad, FiltroBase filtro, List<String> valores) {
        this.entidad = entidad;
        this.filtro = filtro;
        this.valores = valores;
        this.agrupamiento = null;
        this.criterioOrden = null;
    }

    @Override
    public List<Object[]> EjecutarQuery(EntityManager em) {
        SelectSimple select = new SelectSimple(entidad, filtro, valores);
          
        if(agrupamiento != null)
        	select.setAgrupamiento(agrupamiento);
        if(criterioOrden != null)
        	select.setCriterio(criterioOrden);
        
        select.execute();

        return null;
    }

	public Agrupamiento getAgrupamiento() {
		return agrupamiento;
	}

	public void setAgrupamiento(Agrupamiento agrupamiento) {
		this.agrupamiento = agrupamiento;
	}

	public OrdenamientoColumna getCriterioOrden() {
		return criterioOrden;
	}

	public void setCriterioOrden(OrdenamientoColumna criterioOrden) {
		this.criterioOrden = criterioOrden;
	}
    
    
    
    
}
