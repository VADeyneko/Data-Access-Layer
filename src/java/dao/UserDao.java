package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Credentials;
import model.User;

@Stateless
public class UserDao extends AbstractDao<User> {

    @PersistenceContext(unitName = "Data_Access_LayerPU")
    private EntityManager em;

    public UserDao() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private User findByEmail(String email) {
        try {
            TypedQuery<User> query = em.createNamedQuery("find-user-by-email", User.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User find(Object id) {
        try {
            return super.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.find(id);
    }

    public boolean exists(Credentials credentials) {
        User user = findByEmail(credentials.getEmail());
        return user != null && user.getCredentials().equals(credentials);
    }

    public User getExistingUser(Credentials credentials) {
        User user = findByEmail(credentials.getEmail());
        if (exists(user.getCredentials())) {
            return user;
        } else {
            throw new NoResultException("User not found!!!");
        }
    }

    @Override
    public void delete(User entity) {
        User userToDelete = em.merge(entity);
        em.remove(userToDelete);
    }

    

}
