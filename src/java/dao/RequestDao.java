 
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Request;

/**
 *
 * @author admin
 */
@Stateless
public class RequestDao extends AbstractDao<Request> {
    
    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequestDao() {
        super(Request.class);
    }
    
    
    @Override
    public Request find(Object id) {
        try {
            return super.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.find(id);
    }
    
    @Override
    public void delete(Request entity) {
        Request req = em.merge(entity);
        em.remove(req);
    }
}
