package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDao<E> {

    private final Class<E> cls;

    public AbstractDao(Class<E> cls) {
        this.cls = cls;
    }
    
    protected abstract EntityManager getEntityManager();

    public void create(E entity) {
        getEntityManager().persist(entity);
    }

    public void update(E entity) {
        getEntityManager().merge(entity);
    }

    public void delete(E entity) {
        getEntityManager().remove(entity);
    }
    
    public E find(Object id) {
        return getEntityManager().find(cls, id);
    }
    
    public List<E> all() {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(cls);
        Root<E> root = query.from(cls);
        query = query.select(root);
        return em.createQuery(query).getResultList();
    }

} 