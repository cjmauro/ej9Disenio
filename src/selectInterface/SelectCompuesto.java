package selectInterface;

public class SelectCompuesto implements Select{
	
	private Tabla tabla1;
	private Tabla tabla2;
	private FiltroBase filtro;
	private CriterioOrd criterio;
	

	public SelectCompuesto(Tabla tabla1, Tabla tabla2, FiltroBase filtro, CriterioOrd criterio) {
		this.tabla1 = tabla1;
		this.tabla2 = tabla2;
		this.filtro = filtro;
		this.criterio = criterio;
	}

	public Tabla getTabla1() {
		return tabla1;
	}

	public void setTabla1(Tabla tabla1) {
		this.tabla1 = tabla1;
	}

	public Tabla getTabla2() {
		return tabla2;
	}

	public void setTabla2(Tabla tabla2) {
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
		// TODO Auto-generated method stub
		
	}
	

}
