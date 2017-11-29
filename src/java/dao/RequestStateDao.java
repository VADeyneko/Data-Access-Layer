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

    ///////////убрать   
    @Override
    public RequestState find(Object id) {
        try {
            return super.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
