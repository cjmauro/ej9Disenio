package jdbc1;

import java.io.Serializable;

public class EstudiaDao <Entity, ID extends Serializable> extends BaseJPARepository<Estudia,EstudiaId>{
    

    public EstudiaDao() {
    	super(Estudia.class , EstudiaId.class);
    }
	
	
}