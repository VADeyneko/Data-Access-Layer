
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 Класс хранит состояния заявки, а также карту перехода между состояниями 
 * (через ссылку на прошлое и следующее состояние, кот. может быть пустой)
 * сделано в виде сущности с хренением в БД (целостность данных, удобство добавления и настройки)
 */
@Entity
@NamedQueries({
@NamedQuery(name = "find-initial-state-list",query = "select s from RequestState s where s.id < 3")   
, @NamedQuery(name = "find-approve-state-list",query = "select s from RequestState s where s.id >2 ")    
})
public class RequestState implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final ResourceBundle PREDEFINED_ELEMENTS;
    static {
        PREDEFINED_ELEMENTS = ResourceBundle.getBundle("resources.elements");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    @Column(name = "name",unique = true)
    private String name;
    
    @Column(name = "isManagerState",unique = false)
    private int isManagerState;
    
   @Column(name = "glyphoiconName",unique = false)
    private String  glyphoiconName;
    
   @ManyToMany(cascade = CascadeType.ALL ) 
    private Collection<RequestState> possibleStates;

    public Collection<RequestState> getPossibleStates() {
        return possibleStates;
    } 

    /*method is overloaded for getting manager-only or user-only states*/
    public Collection<RequestState> getPossibleStates(boolean byManager) {
       Collection<RequestState> stateList = new LinkedList<>();
       
       if(byManager)
            for(RequestState s : possibleStates){
                if(s.isManagerState == 1 ||possibleStates.size() == 1)  //для менеджера - минимум 1 состояние доступно
                     stateList.add(s);
           
        } else {
            for(RequestState s : possibleStates){
                 if(s.isManagerState == 0 && this.isManagerState == 0)  //для не менджера - более 2х состояний только в черновике
                      stateList.add(s);                                              
             }       
       } 
       return stateList;
    }
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIsManagerState() {
        return isManagerState;
    }

    public String getGlyphoiconName() {
        return glyphoiconName;
    }
        
    

    public String getName() {
        return PREDEFINED_ELEMENTS.getString(name)   ;   
    }
 
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {         
        if (!(object instanceof RequestState)) {
            return false;
        }
        RequestState other = (RequestState) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RequestState[ id=" + id + " ]";
    }

 
    
}
