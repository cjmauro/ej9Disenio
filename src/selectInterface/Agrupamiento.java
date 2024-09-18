package selectInterface;

public class Agrupamiento {
	private String columna;
	
	public Agrupamiento(String columna) {
		this.columna = columna;
	}

	public String applyCriterio() {
		return " GROUP BY " + columna;
	}

}

