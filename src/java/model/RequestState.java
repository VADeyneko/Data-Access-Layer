
package model;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
    
    @JoinColumn(nullable = true, unique = false,name = "previousState_id")
    @OneToOne
    private RequestState previousState;
    
    @JoinColumn(nullable = true, unique = false,name = "nextState_id")
    @OneToOne
    private RequestState nextState;
    
    @Column(name = "name",unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RequestState getPreviousState() {
        return previousState;
    }

    public RequestState getNextState() {
        return nextState;
    }
    
    
    
}
