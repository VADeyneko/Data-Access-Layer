package dao;

import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Request;
import model.User;

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
        return super.find(id);
    }

    @Override
    public void delete(Request entity) {
        Request req = em.merge(entity);
        em.remove(req);
    }

    public List<Request> findByOwner(User owner) {
        TypedQuery<Request> query = em.createNamedQuery("get-request-list-by-owner", Request.class);
        query.setParameter("owner", owner);
        return query.getResultList();
    }
    
    
    public List<Request> findByManager(User manager) {
        TypedQuery<Request> query = em.createNamedQuery("get-request-list-by-manager", Request.class);
        query.setParameter("manager", manager);
        return query.getResultList();
    }
    
     public List<Request> findIntersections(Request req) {
        TypedQuery<Request> query = em.createNamedQuery("get-intersecting-requests", Request.class);
        query.setParameter("req", req);
        query.setParameter("dDateBegin", req.getDateBegin());
        query.setParameter("dDateEnd", req.getDateEnd());  
        
        return query.getResultList();
    }
     
     // Requests from one oner shouldn't intersect with each other
     public List<Request> findOwnerIntersections(java.sql.Date dBegin, java.sql.Date dEnd, User owner) {
        TypedQuery<Request> query = em.createNamedQuery("get-owner-intersecting-requests", Request.class);

        query.setParameter("owner", owner);
        query.setParameter("dDateBegin", dBegin);
        query.setParameter("dDateEnd", dEnd);  
        
        return query.getResultList();
    }
     
    // Requests from one oner shouldn't intersect with each other
     public List<Request> getReport(Long vacationTypeId, Long managerId, Long ownerId, Long requestStateId, Date dBegin, Date dEnd) {
        TypedQuery<Request> query = em.createNamedQuery("get-criteria-report", Request.class);

        query.setParameter("vacationTypeId",  vacationTypeId);
        query.setParameter("managerId",  managerId);
        query.setParameter("ownerId",  ownerId);
        query.setParameter("requestStateId",  requestStateId);
        query.setParameter("dBegin",  dBegin);
        query.setParameter("dEnd",  dEnd);
        
        
        return query.getResultList();
    }
}
