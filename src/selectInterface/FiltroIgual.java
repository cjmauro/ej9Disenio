package selectInterface;

public class FiltroIgual implements FiltroBase{
	private String columna;
	private Object valor;
	
	public FiltroIgual(String columna, Object valor) {
		super();
		this.columna = columna;
		this.valor = valor;
	}
	
	public String getColumna() {
		return columna;
	}
	public void setColumna(String columna) {
		this.columna = columna;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}

	@Override
	public String applyFiltro() {
		return  columna + " = " + valor;
	}


}
