/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.*;

/**
 *
 * @author Alexis
 */
public class SejourService {

    private SejourService() {
    }

    static Integer creerSejour(String raisonAdmission, Calendar dateDebut, Patient patient, Soin soin) {
        Sejour sejour = new Sejour(dateDebut, soin);
        sejour.ajouterSoin(soin);
        sejour.setRaison_admission(raisonAdmission);
        return SejourDAOImpl.getInstance().save(sejour);
    }
    
    static Integer creerSejour(String raisonAdmission, Calendar dateDebut, Integer idPatient, Integer idSoin) {
        Sejour sejour = new Sejour(dateDebut, (SoinDAOImpl.getInstance().get(idSoin)));
        sejour.setRaison_admission(raisonAdmission);
        return SejourDAOImpl.getInstance().save(sejour);
    }
    
    static Boolean ajouterListeSoin(Sejour sejour, Set<Soin> soins)
    {
        sejour.setSoins(soins);
        return SejourDAOImpl.getInstance().update(sejour);
    }

    static Boolean ajouterSoin(Sejour sejour, Soin soin) {
        Set<Soin> soins = sejour.getSoins();
        soins.add(soin);
        sejour.setSoins(soins);
        return SejourDAOImpl.getInstance().update(sejour);
    }
    
    static Boolean modifierSejour(Sejour sejour, String raisonAdmission)
    {   
        sejour.setRaison_admission(raisonAdmission);
        return SejourDAOImpl.getInstance().update(sejour);
    }
    
    static Boolean modifierSejour(Integer idSejour, String raisonAdmission)
    {
        Sejour sejour = SejourDAOImpl.getInstance().get(idSejour);
        sejour.setRaison_admission(raisonAdmission);
        return SejourDAOImpl.getInstance().update(sejour);
    }
    
    static Boolean cloturerSejour (Sejour sejour)
    {
        sejour.setStatus(false);
        return SejourDAOImpl.getInstance().update(sejour);
    }
}
