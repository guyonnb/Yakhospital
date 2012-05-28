/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import yakhospital.hibernate.Lit;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.LitDAOImpl;
import yakhospital.hibernate.dao.impl.ServiceDAOImpl;
import yakhospital.service.tools.ComparatorDate;

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
    
    public static List<CreneauService> rechercherCreneauSalle(Service service, Calendar dateDebut, int duree) {
        
        List<CreneauService> listeCreneaux = new ArrayList<>();
        Set<Lit> lits = new TreeSet<>();
	Set<Soin> soins;
        Calendar dateFin = null;
        Calendar creneauDebut = null;
        int dureeCreneau = 0;
        
        lits = service.getLits();
	// TODO : Si aucune salle dispo, voir les services compatibles

	for (Lit lit : lits) {
            soins = lit.getSoins();
            
            for (Soin soin : soins) {
                if (soin.getDate_fin_soin().before(dateDebut))
                {
                    creneauDebut = soin.getDate_fin_soin();
                    break;
                }
                dateFin = dateDebut;
                dateFin.add(Calendar.MINUTE, duree);
                if (dateFin.before(soin.getDate_debut_soin()))
                {
                    dureeCreneau = ComparatorDate.calculateDifference
                            (creneauDebut, soin.getDate_debut_soin());
                }
                else
                {
                    creneauDebut = soin.getDate_fin_soin();
                    break;
                }
                
                CreneauService creneau = new CreneauService(lit, creneauDebut, dureeCreneau);
                listeCreneaux.add(creneau);
                
                creneauDebut = soin.getDate_fin_soin();
                dureeCreneau = 0;
            }
        }
        return listeCreneaux;
    }
}
