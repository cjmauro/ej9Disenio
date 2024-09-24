package jdbc1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import selectInterface.Agrupamiento;
import selectInterface.FiltroAnd;
import selectInterface.FiltroBase;
import selectInterface.FiltroIgual;
import selectInterface.OrdenamientoColumna;
import selectInterface.OrdenamientoColumna_compuesto;
import selectInterface.SelectCompuesto;
import selectInterface.SelectSimple;



public class CarreraDao <Entity, ID extends Serializable>  extends BaseJPARepository<Carrera,Integer>{

    public CarreraDao() {
    	super(Carrera.class , Integer.class);
    }
    
    
    
    
    
    SELECT c.Nombre, COUNT(e.Numero_Libreta_Universitaria) AS Cantidad_Inscriptos
    FROM Carrera c
    JOIN Estudia e ON c.ID_Carrera = e.ID_Carrera
    GROUP BY c.Nombre
    ORDER BY Cantidad_Inscriptos DESC;
    
    public void findEstudiantesPorCarrera() { MALLLLLLLLL
        FiltroBase filtroCombinado = null;
        List<String> valores = Arrays.asList("c.Nombre", "COUNT(e.Numero_Libreta_Universitaria) AS Cantidad_Inscriptos");
        OrdenamientoColumna criterioOrden = new OrdenamientoColumna("inscriptos", false); // Orden descendente

        Agrupamiento agrupamiento = new Agrupamiento("e.nombre");
        SelectCompuesto select = new SelectCompuesto("Carrera c", "Estudia e", filtroCombinado, valores, "");
        select.setCriterio(criterioOrden);
        select.setAgrupamiento(agrupamiento);
        select.execute();
    }
    
    public void ejercicioC() { terminarrrrrrr
        FiltroBase filtro1 = new FiltroIgual("e2.antiguedad", "e.antiguedad");
        FiltroBase filtro2 = new FiltroIgual("e2.carrera_id", "c.id");
        FiltroBase filtroand1 = new FiltroAnd(filtro1, filtro2);
        FiltroBase filtro3 = new FiltroIgual("e2.graduado", "true");
        FiltroBase filtroand2 = new FiltroAnd(filtroand1, filtro3);
        SelectSimple select = new SelectSimple("Estudiante e2", filtroand2, Arrays.asList("COUNT(*)"));

        
        System.out.println(select.getSQL());
        String subconsulta = "(" + select.getSQL() + ") AS egresados";
        List<String> valores = Arrays.asList("c.nombre AS carrera", "e.anioIngreso AS anio", "COUNT(e.id) AS inscriptos", subconsulta);
        Agrupamiento agrupamiento = new Agrupamiento("c.nombre, e.anioIngreso");
        OrdenamientoColumna_compuesto criterioOrden = new OrdenamientoColumna_compuesto("c.nombre", true, "e.anioIngreso", true, ON);

        SelectCompuesto select2 = new SelectCompuesto("Estudiante e", "Carrera c", null, valores );
        
        select2.setCriterio(criterioOrden);
        select2.setAgrupamiento(agrupamiento);
        
        System.out.println(select2.getSQL());
        
        select2.execute();
        
 
        //BaseQuery bq = new BaseQuery("Estudia e", null, valores);
   
       //NO TERMINADOOOOOOOOOOOO
       // bq.setCriterioOrden(criterioOrden);
        
        //return bq;
    }
    
    
    /* SELECT 
    c.nombre AS carrera, 
    e.anioIngreso AS anio, 
    COUNT(e.id) AS inscriptos, 
    (SELECT COUNT(*) 
     FROM Estudiante e2 
     JOIN Estudia es ON e2.id = es.estudiante_id 
     WHERE es.carrera_id = c.id 
       AND e2.graduado = true 
       AND es.antiguedad = e.antiguedad) AS egresados
FROM 
    Carrera c 
JOIN 
    Estudia es ON c.id = es.carrera_id 
JOIN 
    Estudiante e ON es.estudiante_id = e.id 
GROUP BY 
    c.nombre, e.anioIngreso 
ORDER BY 
    c.nombre ASC, e.anioIngreso ASC;
*/ 
    
    
    
    

}