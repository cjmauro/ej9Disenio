package jdbc1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import selectInterface.FiltroAnd;
import selectInterface.FiltroBase;
import selectInterface.FiltroIgual;
import selectInterface.SelectSimple;

public class EstudiaDao <Entity, ID extends Serializable> extends BaseJPARepository<Estudia,EstudiaId>{
    

    public EstudiaDao() {
    	super(Estudia.class , EstudiaId.class);
    }
	
    public void getQueryByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<String> valores = Arrays.asList("e.estudiante.nombre", "e.estudiante.apellido", "e.estudiante.ciudadResidencia");
        FiltroBase filtroCarrera = new FiltroIgual("e.carrera.nombre", "'" + nombreCarrera + "'");
        FiltroBase filtroCiudad = new FiltroIgual("e.estudiante.ciudadResidencia", "'" + ciudadResidencia + "'");
        FiltroBase filtroCombinado = new FiltroAnd(filtroCarrera, filtroCiudad);
        SelectSimple select = new SelectSimple("Estudia e", filtroCombinado, valores);
        select.execute();
    }

}