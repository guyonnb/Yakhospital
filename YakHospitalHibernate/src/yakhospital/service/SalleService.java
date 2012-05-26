/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import yakhospital.hibernate.*;
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
    public static Integer CreerSalle(Integer nombreLits, String nomSalle) {
        Salle salle = new Salle(nombreLits, nomSalle, null);
        return SalleDAOImpl.getInstance().save(salle);
    }
    
    public static Boolean ModifierSalle(Salle salle, Integer nombreLits, String nomSalle, Service service) {
        salle.setNb_lits(nombreLits);
        salle.setNom_salle(nomSalle);
        salle.setService(service);
        return SalleDAOImpl.getInstance().update(salle);
    }
    
    public static Set<Salle> ConsulterSalleService (Service service) { 
        return service.getSalles();
    }
    
    public static Set<Salle> ConsulterSalleService (Integer idService) {
        return (ServiceDAOImpl.getInstance().get(idService)).getSalles();
    }
    
    public static void SupprimerSalle (Salle salle) {
        SalleDAOImpl.getInstance().delete(salle.getId_salle());
    }
    
    public static void SupprimerSalle (Integer idSalle) {
        SalleDAOImpl.getInstance().delete(idSalle);
    }
    
    public static List<Salle> ConsulterTouteSalle() {
        return SalleDAOImpl.getInstance().list();
    }
}
