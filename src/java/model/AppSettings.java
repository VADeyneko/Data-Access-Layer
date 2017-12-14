/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Victor Deyneko <VADeyneko@gmail.com>
 */
@Entity
public class AppSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date dPeriodBegin;
    
    @Column
    private Date dPeriodEnd;
    
    @Column
    private int maxDaysAllowed;

    @Column
    private int minDaysAllowed;
    
    public Long getId() {
        return id;
    }
       

    public void setId(Long id) {
        this.id = id;
    }

    public Date getdPeriodBegin() {
        return dPeriodBegin;
    }
    
    public String getFormatteddPeriodBegin(){
       return formatDate(dPeriodBegin);
}

    public void setdPeriodBegin(Date dPeriodBegin) {
        this.dPeriodBegin = dPeriodBegin;
    }

    public Date getdPeriodEnd() {
        return dPeriodEnd;
    }
    
    public String getFormatteddPeriodEnd(){
       return formatDate(dPeriodEnd);
}


    public void setdPeriodEnd(Date dPeriodEnd) {
        this.dPeriodEnd = dPeriodEnd;
    }

    public int getMaxDaysAllowed() {
        return maxDaysAllowed;
    }

    public void setMaxDaysAllowed(int maxDaysAllowed) {
        this.maxDaysAllowed = maxDaysAllowed;
    }

    public int getMinDaysAllowed() {
        return minDaysAllowed;
    }

    public void setMinDaysAllowed(int minDaysAllowed) {
        this.minDaysAllowed = minDaysAllowed;
    }

    
    private String formatDate(java.sql.Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String result = formatter.format(date);
        return result;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AppSettings && equals((AppSettings)obj);
    }

    @Override
    public String toString() {
        return "model.AppSettings[ id=" + id + " ]";
    }
    
    
    
    
}
