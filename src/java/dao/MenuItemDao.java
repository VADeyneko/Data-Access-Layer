 
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.MenuItem;
 
 

@Stateless
public class MenuItemDao  extends AbstractDao<MenuItem>{
    
    
    
    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;
    
    public MenuItemDao() {
        super(MenuItem.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
  
    @Override
    public List<MenuItem> all() {
        return super.all(); 
    }

    @Override
    public MenuItem find(Object id) {        
         return super.find(id);
    }
    
    
}
