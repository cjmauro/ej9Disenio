package jdbc1;

import java.io.Serializable;



public class CarreraDao <Entity, ID extends Serializable>  extends BaseJPARepository<Carrera,Integer>{

    public CarreraDao() {
    	super(Carrera.class , Integer.class);
    }


}