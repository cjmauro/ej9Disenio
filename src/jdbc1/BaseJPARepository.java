package jdbc1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseJPARepository<Entity, ID extends Serializable> implements CustomerDAO<Entity, ID> {

    protected EntityManager entityManager;
    protected Class<Entity> entityClass;
    protected Class<ID> idClass;

    public BaseJPARepository(Class<Entity> entityClass, Class<ID> idClass) {
        this.entityClass = entityClass;
        this.idClass = idClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public Entity findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override 
    public Entity persist(Entity entity) {
    	entityManager.getTransaction().begin();
    	entityManager.persist(entity);
    	entityManager.getTransaction().commit(); 
        return entity;
    }

    @Override
    public void delete(ID id) {
        entityManager.getTransaction().begin(); 
        Entity entity = findById(id);          
        if (entity != null) {
            entityManager.remove(entity);     
        }
        entityManager.getTransaction().commit(); 
    }

    @Override
    public List<Entity> findAll() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(jpql, entityClass).getResultList();
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
