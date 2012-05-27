/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import yakhospital.hibernate.*;
import yakhospital.hibernate.dao.impl.SoinDAOImpl;

/**
 *
 * @author Morgane
 */
public class SoinService {

    private SoinService() {
    }

    public static Integer creerSoin(Calendar dateDebutSoin, Calendar dateFinSoin, String commentaire,
                            Patient patient, TypeSoin typeSoin, Titulaire titulaire) {
        Soin soin = new Soin(dateDebutSoin, dateFinSoin, commentaire, typeSoin, titulaire, patient);
        
        return SoinDAOImpl.getInstance().save(soin);
    }
    public static Boolean modifierSoin (Soin soin, Calendar dateDebutSoin,
                                 Calendar dateFinSoin,  String commentaire,
                                 Patient patient, TypeSoin typeSoin, Titulaire titulaire,
                                 Lit lit) {
        soin.setDate_debut_soin(dateDebutSoin);
        soin.setDate_fin_soin(dateFinSoin);
        soin.setCommentaire(commentaire);
        soin.setLit(lit);
        soin.setPatient(patient);
        soin.setTitulaire(titulaire);
        soin.setTypeSoin(typeSoin);
        
        return SoinDAOImpl.getInstance().update(soin);
    }
    public static Boolean modifierSoin (Integer id_soin, Calendar dateDebutSoin,
                                 Calendar dateFinSoin,  String commentaire,
                                 Patient patient, TypeSoin typeSoin, Titulaire titulaire,
                                 Lit lit) {
        Soin soin = SoinDAOImpl.getInstance().get(id_soin);
        soin.setDate_debut_soin(dateDebutSoin);
        soin.setDate_fin_soin(dateFinSoin);
        soin.setCommentaire(commentaire);
        soin.setLit(lit);
        soin.setPatient(patient);
        soin.setTitulaire(titulaire);
        soin.setTypeSoin(typeSoin);
        
        return SoinDAOImpl.getInstance().update(soin);
    }

}
