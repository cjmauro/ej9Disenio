package selectInterface;

public class FiltroNot implements FiltroBase{
	private FiltroBase filtro;
	
	public FiltroNot(FiltroBase filtro) {
		super();
		this.filtro = filtro;
	}
	
	public FiltroBase getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroBase filtro) {
		this.filtro = filtro;
	}
	

	@Override
	public String applyFiltro() {
		return "NOT " + filtro.applyFiltro();
	}
	


}
