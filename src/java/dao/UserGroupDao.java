 
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.MenuItem;
 
import model.UserGroup;

@Stateless
public class UserGroupDao  extends AbstractDao<UserGroup>{
    
    
    
    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;
    
    public UserGroupDao() {
        super(UserGroup.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
  
    @Override
    public List<UserGroup> all() {
        return super.all(); 
    }

    @Override
    public UserGroup find(Object id) {
        try{
        return super.find(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
         return super.find(id);
    }
    
    
}
