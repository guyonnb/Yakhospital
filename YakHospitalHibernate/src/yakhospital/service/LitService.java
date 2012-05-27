/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.List;
import java.util.Set;
import yakhospital.hibernate.Lit;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.LitDAOImpl;
import yakhospital.hibernate.dao.impl.ServiceDAOImpl;

/**
 *
 * @author Alexis
 */
public class LitService {
    
    private LitService() {
    }
    
    //voir si on set le service à la créationd de la lit ou plus tard (je pense plus tard)
    public static Integer creerLit(Integer nombreLits, String nomLit, Service service) {
        Lit lit = new Lit(nombreLits, nomLit, service);
        return LitDAOImpl.getInstance().save(lit);
    }
    
    public static Integer creerLit(Integer nombreLits, String nomLit, Integer idService) {
        Lit lit = new Lit(nombreLits, nomLit, ServiceDAOImpl.getInstance().get(idService));
        return LitDAOImpl.getInstance().save(lit);
    }
    
    public static Boolean modifierLit(Lit lit, String nomLit, Service service) {
        lit.setNom_lit(nomLit);
        lit.setService(service);
        return LitDAOImpl.getInstance().update(lit);
    }
    
    public static Set<Lit> consulterLitService (Service service) { 
        return service.getLits();
    }
    
    public static Set<Lit> consulterLitService (Integer idService) {
        return (ServiceDAOImpl.getInstance().get(idService)).getLits();
    }
    
    public static void supprimerLit (Lit lit) {
        LitDAOImpl.getInstance().delete(lit.getId_lit());
    }
    
    public static void supprimerLit (Integer idLit) {
        LitDAOImpl.getInstance().delete(idLit);
    }
    
    public static List<Lit> consulterTouteLit() {
        return LitDAOImpl.getInstance().list();
    }
    
    public static Boolean ajouterSoin(Lit lit, Soin soin) {
        soin.setLit(lit);
        lit.ajouterSoin(soin);
        return LitDAOImpl.getInstance().update(lit);
    }
}
