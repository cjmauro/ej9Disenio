package jdbc1;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import selectInterface.FiltroBase;
import selectInterface.FiltroIgual;
import selectInterface.SelectSimple;

public class EstudianteDao<Entity, ID extends Serializable> extends BaseJPARepository<Estudiante,Integer>{
    

    public EstudianteDao() {
    	super(Estudiante.class , Integer.class);
    }
	
    void findByLU(String LU){
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroLU = new FiltroIgual("e.LU", "'" + LU + "'");
        SelectSimple select = new SelectSimple("Estudiante e", filtroLU, valores);
        select.execute();
    }
    
    
    void findByGenero(String genero) {
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroGenero = new FiltroIgual("e.genero", "'" + genero + "'");
        SelectSimple select = new SelectSimple("Estudiante e", filtroGenero, valores);
        select.execute();
    }
    
}
