package selectInterface;

public class FiltroAnd implements FiltroBase{
	FiltroBase filtro1;
	FiltroBase filtro2;
	
	public FiltroAnd(FiltroBase filtro1, FiltroBase filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	public FiltroBase getFiltro1() {
		return filtro1;
	}

	public void setFiltro1(FiltroBase filtro1) {
		this.filtro1 = filtro1;
	}

	public FiltroBase getFiltro2() {
		return filtro2;
	}

	public void setFiltro2(FiltroBase filtro2) {
		this.filtro2 = filtro2;
	}
	
	public String applyFiltro() {
		return filtro1.applyFiltro() + " AND " + filtro2.applyFiltro();
	}

}
