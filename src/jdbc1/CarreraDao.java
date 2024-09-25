package jdbc1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import selectInterface.Agrupamiento;
import selectInterface.FiltroBase;
import selectInterface.OrdenamientoColumna;
import selectInterface.OrdenamientoColumna_compuesto;
import selectInterface.SelectCompuesto;


public class CarreraDao <Entity, ID extends Serializable>  extends BaseJPARepository<Carrera,Integer>{

    public CarreraDao() {
    	super(Carrera.class , Integer.class);
    }
    
    public void findEstudiantesPorCarrera() { 
        List<String> tablasJoin = Arrays.asList("Estudia e");
        List<String> condicionesJoin = Arrays.asList("c.id = e.carrera");
        FiltroBase filtro = null;
        List<String> valores = Arrays.asList("c.nombre", "COUNT(e.estudiante) AS inscriptos");
        OrdenamientoColumna criterioOrden = new OrdenamientoColumna("inscriptos", false); // Orden descendente

        Agrupamiento agrupamiento = new Agrupamiento("c.nombre");
        SelectCompuesto select = new SelectCompuesto("Carrera c", tablasJoin, filtro, valores, condicionesJoin);
        select.setCriterio(criterioOrden);
        select.setAgrupamiento(agrupamiento);
        select.execute();
    }
    
    public void ejercicioC() { 
        List<String> tablasJoin = Arrays.asList("Estudia e");
        List<String> condicionesJoin = Arrays.asList("c.id = e.carrera");

        List<String> valores = Arrays.asList("c.nombre AS Carrera", "COUNT(CASE WHEN e.graduado = 'false' THEN 1 END) AS inscriptos", "COUNT(CASE WHEN e.graduado = 'true' THEN 1 END) AS egresados", "e.antiguedad AS anio");
        Agrupamiento agrupamiento = new Agrupamiento("c.nombre, e.antiguedad");
        OrdenamientoColumna_compuesto criterioOrden = new OrdenamientoColumna_compuesto("c.nombre", true, "e.antiguedad", true);
        FiltroBase filtro = null;
        SelectCompuesto select2 = new SelectCompuesto("Carrera c", tablasJoin, filtro, valores, condicionesJoin);
        
        select2.setCriterio(criterioOrden);
        select2.setAgrupamiento(agrupamiento);
        
        System.out.println(select2.getSQL());
        
        select2.execute();

    }
    
  

}