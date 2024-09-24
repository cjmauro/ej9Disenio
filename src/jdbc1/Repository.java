package jdbc1;

import java.io.Serializable;
import java.util.List;

public interface Repository<Entity, ID extends Serializable> {
    Entity findById(ID id);
    Entity persist(Entity entity);
    Entity delete(ID id);
    List<Entity> findAll();
}
