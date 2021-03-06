/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "MenuItem")
 
public class MenuItem implements Serializable {
    
   private static final ResourceBundle PREDEFINED_ELEMENTS;
    
    static {
        PREDEFINED_ELEMENTS = ResourceBundle.getBundle("resources.elements");
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false,unique = true)
    private String labelName;
    
    @Column(nullable = false,unique = true)
    private String menuPath;

    public Integer getId() {
        return id;
    }

    public String getMenuPath() {
        return menuPath;
    }
     

    public String getLabelName() {
        return PREDEFINED_ELEMENTS.getString(labelName)   ;     
    }
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

  
}
