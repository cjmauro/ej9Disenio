package jdbc1;

import java.io.Serializable;
import java.util.List;

public interface CustomerDAO<Entity, ID extends Serializable> {

    Entity findById(ID id);

    Entity persist(Entity entity);

    void delete(ID id);

    List<Entity> findAll();
}

