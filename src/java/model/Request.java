package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REQUEST")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(nullable = false, unique = false)
    @OneToOne(targetEntity = User.class)
    private User owner;

    @JoinColumn( nullable = false, unique = false)
    @OneToOne(targetEntity = User.class)
    private User manager;

    @Column(name = "DATETIMECREATED", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private java.sql.Timestamp dateTimeCreated;

    @Column(name = "DATEBEGIN", nullable = false, unique = false)
    private java.sql.Date dateBegin;

    @Column(name = "DATEEND", nullable = false, unique = false)
    private java.sql.Date dateEnd;

    @JoinColumn( nullable = false, unique = false)
    @OneToOne(targetEntity = RequestState.class)
    private RequestState requestState;

    @JoinColumn( nullable = false, unique = false)
    @OneToOne(targetEntity = VacationType.class)
    private VacationType vacationType;

    @Column(name = "OWNERCOMMENT", nullable = true, unique = false)
    private String ownerComment;

    @Column(name = "MANAGERCOMMENT", nullable = true, unique = false)
    private String managerComment;

    public Request() {
    }

    public Request(User owner, User manager, Date dateBegin, Date dateEnd, RequestState requestState, VacationType vacationType, String ownerComment, String managerComment) {
        this.owner = owner;
        this.manager = manager;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.requestState = requestState;
        this.vacationType = vacationType;
        this.ownerComment = ownerComment;
        this.managerComment = managerComment;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Request && obj.hashCode() == this.hashCode();
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Timestamp getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Timestamp dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public RequestState getRequestState() {
        return requestState;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    public String getOwnerComment() {
        return ownerComment;
    }

    public void setOwnerComment(String ownerComment) {
        this.ownerComment = ownerComment;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }
    
    public String getFormatedDateBegin() {
           return  formatDate(dateBegin);
    }
    
        
    public String getFormatedDateEnd() {          
         return  formatDate(dateEnd);  
    }
    
    public static String getNewRequestDefaultDate(){
           java.util.Date date =  java.util.Date.from(Instant.now());
           SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");             
           return formatter.format(date);            
    }
            
    private String formatDate(java.sql.Date date){
          SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");             
          String result = formatter.format(date);
         return result  ;
    }
    
    public void updateWithRequest(Request reqToClone){
        this.setDateBegin(reqToClone.getDateBegin());
        this.setDateEnd(reqToClone.getDateEnd());
        this.setManager(reqToClone.getManager());
        this.setOwner(reqToClone.getOwner());
        this.setRequestState(reqToClone.getRequestState());
        this.setVacationType(reqToClone.getVacationType());
        this.setOwnerComment(reqToClone.getOwnerComment());
        this.setManagerComment(reqToClone.getManagerComment());          
    }

}
