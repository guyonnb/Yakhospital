/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.List;
import yakhospital.hibernate.Poste;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.Titulaire;
import yakhospital.hibernate.dao.impl.TitulaireDAOImpl;

/**
 *
 * @author Emilie
 */
public class TitulaireService {
    
    private TitulaireService()
    {
    } 
    
    // Crée un titulaire
    static Integer creerTitulaire(String nom, String prenom, String numPro)
    {
        Titulaire titulaire = new Titulaire(nom, prenom, numPro);
        return TitulaireDAOImpl.getInstance().save(titulaire);
    }
    
    // Modifie les nom, prenom, num pro du titulaire
    static Boolean modifierTitulaire (Titulaire titulaire, String nom, String prenom, String numPro)
    {
        titulaire.setNom_titulaire(nom);
        titulaire.setPrenom_titulaire(prenom);
        titulaire.setNum_pro(numPro);
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Modifie le mot de passe du titulaire
    static Boolean modifierMdpTitulaire (Titulaire titulaire, String mdp)
    {
        titulaire.setMdp(mdp);
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Assigne un poste au titulaire
    static Boolean modifierPosteTitulaire (Titulaire titulaire, Poste poste)
    {
        if (titulaire.getPoste() != poste)
        {
            if (titulaire.getPoste() != null)
                titulaire.getPoste().getTitulaires().remove(titulaire);
            poste.getTitulaires().add(titulaire);
            titulaire.setPoste(poste);
        }
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Assigne un service au titulaire
    static Boolean modifierServiceTitulaire (Titulaire titulaire, Service service)
    {
        if (titulaire.getService() != service)
        {
            if (titulaire.getService() != null)
                titulaire.getService().getTitulaires().remove(titulaire);
            service.getTitulaires().add(titulaire);
            titulaire.setService(service);
        }
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Ajoute un soin pour un titulaire
    static Boolean ajouterSoinTitulaire (Titulaire titulaire, Soin soin)
    {
        soin.setTitulaire(titulaire);
        titulaire.addSoin(soin);
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Supprime un soin de la liste des soins du titulaire
    static Boolean supprimerSoinTitulaire (Titulaire titulaire, Soin soin)
    {
        soin.setTitulaire(null);
        titulaire.getSoins().remove(soin);
        return TitulaireDAOImpl.getInstance().update(titulaire);
    }
    
    // Supprime un titulaire
    static Boolean supprimerTitulaire (Titulaire titulaire)
    {
        return TitulaireDAOImpl.getInstance().delete(titulaire.getId_titulaire());
    }
    
    // Renvoie une liste de tous les titulaires
    static List<Titulaire> getAllTitulaire()
    {
        return TitulaireDAOImpl.getInstance().list();
    }
    
    // Renvoie un titulaire suivant son id
    static Titulaire getTitulaire(Integer idTitulaire)
    {
        return TitulaireDAOImpl.getInstance().get(idTitulaire);
    }
    
    // Renvoie un titulaire suivant son num pro
    static Titulaire getTitulaire(String numPro)
    {
        return TitulaireDAOImpl.getInstance().getTitulaire(numPro);
    }
    
    // Renvoie une liste de titulaires suivant le nom
    static List<Titulaire> getTit(String nom)
    {
        return TitulaireDAOImpl.getInstance().get(nom);
    }
    
    // Renvoie un titulaire suivant ses nom et prénom
    static Titulaire getTitulaire(String nom, String prenom)
    {
        return TitulaireDAOImpl.getInstance().get(nom, prenom);
    }
    
}
