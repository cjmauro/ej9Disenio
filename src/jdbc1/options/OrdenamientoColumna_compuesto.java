package jdbc1.options;

import selectInterface.CriterioOrd;

public class OrdenamientoColumna_compuesto implements CriterioOrd{
	private String columna1;
	private boolean ascendente1;
	private String columna2;
	private boolean ascendente2;
	
	public OrdenamientoColumna_compuesto(String columna1, boolean ascendente1, String columna2, boolean ascendente2) {
		this.columna1 = columna1;
		this.ascendente1 = ascendente1;
		this.columna2 = columna2;
		this.ascendente2 = ascendente2;
	}

	public String getColumna1() {
		return columna1;
	}



	public void setColumna1(String columna1) {
		this.columna1 = columna1;
	}



	public boolean isAscendente1() {
		return ascendente1;
	}



	public void setAscendente1(boolean ascendente1) {
		this.ascendente1 = ascendente1;
	}



	public String getColumna2() {
		return columna2;
	}



	public void setColumna2(String columna2) {
		this.columna2 = columna2;
	}



	public boolean isAscendente2() {
		return ascendente2;
	}



	public void setAscendente2(boolean ascendente2) {
		this.ascendente2 = ascendente2;
	}

	public String applyOrdernamiento() {
		String operador1 = "DESC";
		if (ascendente1 == true) {
			operador1 = "ASC";
		}
		String operador2 = "DESC";
		if (ascendente2 == true) {
			operador2 = "ASC";
		}
		
		return columna1 + " " +  operador1 +", "+ columna2 + " " +  operador2;
	}

}