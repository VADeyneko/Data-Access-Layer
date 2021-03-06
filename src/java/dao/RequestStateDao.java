package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.RequestState;
import model.User;

@Stateless
public class RequestStateDao   extends AbstractDao<RequestState> {
    
    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
       public RequestStateDao() {
        super(RequestState.class);
    }

    
    @Override
    public RequestState find(Object id) {
            return super.find(id); 
    }    
    
     public List<RequestState> getInitialStateList () {
        try {
            TypedQuery<RequestState> query = em.createNamedQuery("find-initial-state-list", RequestState.class);           
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
