package jdbc1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import selectInterface.FiltroAnd;
import selectInterface.FiltroBase;
import selectInterface.FiltroIgual;
import selectInterface.SelectCompuesto;

public class EstudiaDao <Entity, ID extends Serializable> extends BaseJPARepository<Estudia,EstudiaId>{
    

    public EstudiaDao() {
    	super(Estudia.class , EstudiaId.class);
    }

    public void getQueryByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<String> valores = Arrays.asList("e.nombre", "e.apellido", "e.ciudadResidencia");
        FiltroBase filtroCarrera = new FiltroIgual("c.nombre", "'" + nombreCarrera + "'");
        FiltroBase filtroCiudad = new FiltroIgual("e.ciudadResidencia", "'" + ciudadResidencia + "'");
        FiltroBase filtroCombinado = new FiltroAnd(filtroCarrera, filtroCiudad);
        
        List<String> tablasJoin = Arrays.asList("Estudiante e", "Carrera c");
        List<String> condicionesJoin = Arrays.asList("e.LU = es.estudiante", "c.id = es.carrera");

        SelectCompuesto select2 = new SelectCompuesto("Estudia es", tablasJoin, filtroCombinado, valores, condicionesJoin);
        
        
        select2.execute();
    }

}