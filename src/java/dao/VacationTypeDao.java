 
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.VacationType;

 
@Stateless
public class VacationTypeDao   extends AbstractDao<VacationType> {
    
    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
       public VacationTypeDao() {
        super(VacationType.class);
    }

       
    @Override
    public VacationType find(Object id) {
        
        return super.find(id);
    }    
    
}
