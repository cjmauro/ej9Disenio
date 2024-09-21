package jdbc1.options;

import java.util.Arrays;
import java.util.List;

import selectInterface.*;

public class QueryFactory {

    public void getQueryByLU(String LU) {
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroLU = new FiltroIgual("e.LU", "'" + LU + "'");
        //return new BaseQuery("Estudiante e", filtroLU, valores);
        
        
        SelectSimple select = new SelectSimple("Estudiante e", filtroLU, valores);
        

        select.execute();
        
    }

    public void getQueryByGenero(String genero) {
        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");
        FiltroBase filtroGenero = new FiltroIgual("e.genero", "'" + genero + "'");
        SelectSimple select = new SelectSimple("Estudiante e", filtroGenero, valores);
        select.execute();
    }
    
    
    
    public void getQueryByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<String> valores = Arrays.asList("e.estudiante.nombre", "e.estudiante.apellido", "e.estudiante.ciudadResidencia");
        FiltroBase filtroCarrera = new FiltroIgual("e.carrera.nombre", "'" + nombreCarrera + "'");
        FiltroBase filtroCiudad = new FiltroIgual("e.estudiante.ciudadResidencia", "'" + ciudadResidencia + "'");
        FiltroBase filtroCombinado = new FiltroAnd(filtroCarrera, filtroCiudad);
        SelectSimple select = new SelectSimple("Estudia e", filtroCombinado, valores);
        select.execute();
    }

    


    public void getQueryCountEstudiantesPorCarrera() {
        FiltroBase filtroCombinado = null;
        List<String> valores = Arrays.asList("e.nombre", "COUNT(e) AS inscriptos");
        OrdenamientoColumna criterioOrden = new OrdenamientoColumna("inscriptos", false); // Orden descendente

        Agrupamiento agrupamiento = new Agrupamiento("e.nombre");
        SelectSimple select = new SelectSimple("Estudiante e", filtroCombinado, valores);
        select.setCriterio(criterioOrden);
        select.setAgrupamiento(agrupamiento);
        select.execute();
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
    
    
    public void getQueryAllEstudiantes(String columnaOrden, boolean ascendente) {
        FiltroBase filtroCombinado = null;

        List<String> valores = Arrays.asList("e.LU", "e.DNI", "e.nombre", "e.apellido", "e.ciudadResidencia", "e.edad", "e.genero");

        OrdenamientoColumna criterioOrden = new OrdenamientoColumna(columnaOrden, ascendente);
        
        SelectSimple select = new SelectSimple("Estudiante e", filtroCombinado, valores);
        select.setCriterio(criterioOrden);
        System.out.println(select.getSQL());

  
        select.execute();
    }
    
    
    
    
    public void ejercicioC() {
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
        OrdenamientoColumna_compuesto criterioOrden = new OrdenamientoColumna_compuesto("c.nombre", true, "e.anioIngreso", true);

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
    
 
}