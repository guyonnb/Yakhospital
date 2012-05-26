/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import yakhospital.hibernate.Salle;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Titulaire;
import yakhospital.hibernate.dao.impl.SalleDAOImpl;
import yakhospital.hibernate.dao.impl.ServiceDAOImpl;
import yakhospital.hibernate.dao.impl.TitulaireDAOImpl;



/**
 *
 * @author Morgane
 */
public class ServiceService {
    
    public static Integer creerService (String nom_service) {
        Service service = new Service (nom_service);
        return ServiceDAOImpl.getInstance().save(service);
        
    }
    public static Boolean modifierService (Service service, String nom_service) {
        service.setNom_service(nom_service);
        return ServiceDAOImpl.getInstance().update(service);
    }
    public static Boolean modifierService (Integer id_service, String nom_service) {
        Service s = ServiceDAOImpl.getInstance().get(id_service);
        s.setNom_service(nom_service);
        return ServiceDAOImpl.getInstance().update(s);
    }
    public static Boolean supprimerService (Service service) {
        return ServiceDAOImpl.getInstance().delete(service.getId_service());
    }
    public static Boolean supprimerService (Integer id_service) {
        return ServiceDAOImpl.getInstance().delete(id_service);
    }
    public static Boolean ajouterTitulaire (Titulaire titulaire, Service service) {
        titulaire.setService(service);
        service.ajouterTitulaire(titulaire);
        return ServiceDAOImpl.getInstance().update(service);
    }
        public static Boolean ajouterTitulaire (Integer id_titulaire, Service service) {
        Titulaire t = TitulaireDAOImpl.getInstance().get(id_titulaire);
        t.setService(service);
        service.ajouterTitulaire(t);
        return ServiceDAOImpl.getInstance().update(service);
    }
    public static Boolean ajouterSalle (Salle salle, Service service) {
       salle.setService(service);
       service.ajouterSalle(salle);
       return ServiceDAOImpl.getInstance().update(service);
    }
    public static Boolean ajouterSalle (Integer id_salle, Service service) {
       Salle salle = SalleDAOImpl.getInstance().get(id_salle);
       salle.setService(service);
       service.ajouterSalle(salle);
       return ServiceDAOImpl.getInstance().update(service);
    }
    public static Boolean ajouterServiceComp (Service serviceComp, Service service) {
        service.ajouterServiceComp(serviceComp);
        return ServiceDAOImpl.getInstance().update(service);
    }
    public static Boolean ajouterServiceComp (Integer id_serviceComp, Service service) {
        Service serviceComp = ServiceDAOImpl.getInstance().get(id_serviceComp);
        service.ajouterServiceComp(serviceComp);
        return ServiceDAOImpl.getInstance().update(service);
    }
}
