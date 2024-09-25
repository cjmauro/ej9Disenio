package selectInterface;

public class OrdenamientoColumna implements CriterioOrd{
	private String columna;
	private boolean ascendente;
	
	public OrdenamientoColumna(String columna, boolean ascendente) {
		this.columna = columna;
		this.ascendente = ascendente;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}
	
	public String applyOrdernamiento() {
		String operador = "DESC";
		if (ascendente == true) {
			operador = "ASC";
		}
		return columna + " " +  operador;
	}

}
