package jdbc1.options;

import java.util.Arrays;
import java.util.List;

import selectInterface.*;

public class QueryFactory {

    public static query getQueryByLU(String LU) {
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroLU = new FiltroIgual("e.LU", "'" + LU + "'");
        return new BaseQuery("Estudiante e", filtroLU, valores);
    }

    public static query getQueryByGenero(String genero) {
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroGenero = new FiltroIgual("e.genero", "'" + genero + "'");
        return new BaseQuery("Estudiante e", filtroGenero, valores);
    }

    public static query getQueryByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<String> valores = Arrays.asList("e.estudiante.nombre", "e.estudiante.apellido", "e.estudiante.ciudadResidencia");
        FiltroBase filtroCarrera = new FiltroIgual("e.carrera.nombre", "'" + nombreCarrera + "'");
        FiltroBase filtroCiudad = new FiltroIgual("e.estudiante.ciudadResidencia", "'" + ciudadResidencia + "'");
        FiltroBase filtroCombinado = new FiltroAnd(filtroCarrera, filtroCiudad);
        return new BaseQuery("Estudia e", filtroCombinado, valores);
    }
    
    public static query getQueryCountEstudiantesPorCarrera() {
        FiltroBase filtroCombinado = null;
        List<String> valores = Arrays.asList("e.carrera.nombre", "COUNT(e.estudiante) AS inscriptos");
        OrdenamientoColumna criterioOrden = new OrdenamientoColumna("inscriptos", false); // Orden descendente
        Agrupamiento agrupamiento = new Agrupamiento("e.carrera.nombre");
        BaseQuery bq = new BaseQuery("Estudia e", filtroCombinado, valores);
        bq.setCriterioOrden(criterioOrden);
        bq.setAgrupamiento(agrupamiento);
        return bq;
        
    }
    

    
    
/* SELECT c.nombre AS carrera, e.anioIngreso AS anio, COUNT(e.id) AS inscriptos, (SELECT COUNT(*)
																			     FROM Estudiante e2
																			     WHERE e2.carrera_id = c.id
																			     AND e2.antiguedad = e.antiguedad
																			     AND e2.graduado = true) AS egresados
	FROM Estudiante e
	JOIN Carrera c ON e.carrera_id = c.id
	GROUP BY c.nombre, e.anioIngreso
	ORDER BY c.nombre ASC, e.anioIngreso ASC;
*/ 
    
    
    public static query getQueryAllEstudiantes(String columnaOrden, boolean ascendente) {
        FiltroBase filtroCombinado = null;

        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");

        OrdenamientoColumna criterioOrden = new OrdenamientoColumna(columnaOrden, ascendente);
        BaseQuery bq = new BaseQuery("Estudiante e", filtroCombinado, valores);
        bq.setCriterioOrden(criterioOrden);
        
        return bq;
    }
    
    
    
    
    public static query ejercicioC(OrdenamientoColumna criterioOrden) {
        FiltroBase filtro1 = new FiltroIgual("e2,antiguedad", "'e.antiguedad'") ;
        
        
        SelectSimple select = new SelectSimple("Estudiante e2", filtro1, Arrays.asList("COUNT(*)"));
        
        select.getSQL();
        List<String> valores = Arrays.asList("c.nombre AS carrera", "e.anioIngreso AS anio", "COUNT(e.id) AS inscriptos", select.getSQL());
        
        BaseQuery bq = new BaseQuery("Estudia e", null, valores);
   
       NO TERMINADOOOOOOOOOOOO
        bq.setCriterioOrden(criterioOrden);
        
        return bq;
    }
    
 
}