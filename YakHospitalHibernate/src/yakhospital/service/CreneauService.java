/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import yakhospital.hibernate.Lit;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Soin;
import yakhospital.service.tools.ComparatorDate;

/**
 *
 * @author Emilie
 */
public class CreneauService {
    
    private Lit lit;
    private Calendar dateDebut;
    private int duree;
    
    public CreneauService()
    {
    }
    
    public CreneauService(Lit lit, Calendar dateDebut, int duree)
    {
        this.lit = lit;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }
    
    
}
