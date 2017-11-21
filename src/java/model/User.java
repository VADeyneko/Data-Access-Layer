package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@NamedQueries({
    @NamedQuery(
        name = "find-user-by-email",
        query = "SELECT u FROM User u WHERE u.credentials.email = :email"
    )
})
public class User extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Credentials credentials;
          
    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private UserGroup userGroup;
    
    @OneToOne(optional = true)
    @JoinColumn(name = "manager_id", nullable = true)    
    private User manager;
    
    
    protected User() {
    }

    public User(Credentials credentials, String name, String lastname, UserGroup userGroup) {
        super(name, lastname);
        this.credentials = credentials;
        this.userGroup = userGroup;
    }
   
  
    public Credentials getCredentials() {
        return credentials;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public User getManager() {
        return manager;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
    
    
    @Override
    public int hashCode() {
        return credentials.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && obj.hashCode() == hashCode();
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    
    
} 