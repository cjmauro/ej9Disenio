package jdbc1.options;

import java.util.List;

import javax.persistence.EntityManager;

public interface query {
    abstract List<Object[]> EjecutarQuery(EntityManager em);
}
