/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.List;
import java.util.Set;
import yakhospital.hibernate.Salle;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.SalleDAOImpl;
import yakhospital.hibernate.dao.impl.ServiceDAOImpl;

/**
 *
 * @author Alexis
 */
public class SalleService {
    
    private SalleService() {
    }
    
    //voir si on set le service à la créationd de la salle ou plus tard (je pense plus tard)
    public static Integer creerSalle(Integer nombreLits, String nomSalle, Service service) {
        Salle salle = new Salle(nombreLits, nomSalle, service);
        return SalleDAOImpl.getInstance().save(salle);
    }
    
    public static Integer creerSalle(Integer nombreLits, String nomSalle, Integer idService) {
        Salle salle = new Salle(nombreLits, nomSalle, ServiceDAOImpl.getInstance().get(idService));
        return SalleDAOImpl.getInstance().save(salle);
    }
    
    public static Boolean modifierSalle(Salle salle, Integer nombreLits, String nomSalle, Service service) {
        salle.setNb_lits(nombreLits);
        salle.setNom_salle(nomSalle);
        salle.setService(service);
        return SalleDAOImpl.getInstance().update(salle);
    }
    
    public static Set<Salle> consulterSalleService (Service service) { 
        return service.getSalles();
    }
    
    public static Set<Salle> consulterSalleService (Integer idService) {
        return (ServiceDAOImpl.getInstance().get(idService)).getSalles();
    }
    
    public static void supprimerSalle (Salle salle) {
        SalleDAOImpl.getInstance().delete(salle.getId_salle());
    }
    
    public static void supprimerSalle (Integer idSalle) {
        SalleDAOImpl.getInstance().delete(idSalle);
    }
    
    public static List<Salle> consulterTouteSalle() {
        return SalleDAOImpl.getInstance().list();
    }
    
    public static Boolean ajouterSoin(Salle salle, Soin soin) {
        soin.setSalle(salle);
        salle.ajouterSoin(soin);
        return SalleDAOImpl.getInstance().update(salle);
    }
}
