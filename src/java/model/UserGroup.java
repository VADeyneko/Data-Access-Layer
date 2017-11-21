/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.ResourceBundle;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table (name = "UserGroup")
@NamedQueries({
    @NamedQuery(
        name = "get-menuItems-by-UserGroup",
        query = "SELECT bb  FROM UserGroup a INNER JOIN a.MenuItems  bb where a.id = :idUserGroup"
    )
     ,@NamedQuery(
        name = "find-group-by-id",
        query = "SELECT bb  FROM UserGroup bb where bb.id = :id"
    )
        
})
public class UserGroup implements Serializable {
    
    private static final ResourceBundle PREDEFINED_ELEMENTS;
    
    static {
        PREDEFINED_ELEMENTS = ResourceBundle.getBundle("resources.elements");
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false, unique = true)
    private String groupSystemName;
    
    @Column(nullable = false, unique = true)
    private String groupLabelName;
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true) 
    private Collection<MenuItem> MenuItems;
    
    private Integer bAdmin;
    private Integer bManager;
    private Integer bDefault;
            
    public Long getId() {
        return id;
    }

    public String getGroupSystemName() {
        return groupSystemName;
    }

    public String getGroupLabelName() {
        
        return PREDEFINED_ELEMENTS.getString(groupLabelName)   ;
    }

    public Collection<MenuItem> getMenuItems() {
        
        return MenuItems;
    }

    public void setMenuItems(Collection<MenuItem> MenuItems) {
        this.MenuItems = MenuItems;
    }
 
    
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UserGroup && equals((UserGroup)obj);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Integer getbAdmin() {
        return bAdmin;
    }

    public Integer getbManager() {
        return bManager;
    }

    public Integer getbDefault() {
        return bDefault;
    }

        
}
