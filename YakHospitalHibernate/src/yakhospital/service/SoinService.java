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

    static Integer creerSoin(Calendar dateDebutSoin, String commentaire,
                            Sejour s, TypeSoin typeSoin, Titulaire titulaire) {
        Soin soin = new Soin(dateDebutSoin, commentaire, typeSoin, titulaire, s);
        
        return SoinDAOImpl.getInstance().save(soin);
    }
    static Boolean modifierSoin (Soin soin, Calendar dateDebutSoin,
                                 Calendar dateFinSoin,  String commentaire,
                                 Sejour s, TypeSoin typeSoin, Titulaire titulaire,
                                 Salle salle) {
        soin.setDate_debut_soin(dateDebutSoin);
        soin.setDate_fin_soin(dateFinSoin);
        soin.setCommentaire(commentaire);
        soin.setSalle(salle);
        soin.setSejour(s);
        soin.setTitulaire(titulaire);
        soin.setTypeSoin(typeSoin);
        
        return SoinDAOImpl.getInstance().update(soin);
    }
    static Boolean modifierSoin (Integer id_soin, Calendar dateDebutSoin,
                                 Calendar dateFinSoin,  String commentaire,
                                 Sejour s, TypeSoin typeSoin, Titulaire titulaire,
                                 Salle salle) {
        Soin soin = SoinDAOImpl.getInstance().get(id_soin);
        soin.setDate_debut_soin(dateDebutSoin);
        soin.setDate_fin_soin(dateFinSoin);
        soin.setCommentaire(commentaire);
        soin.setSalle(salle);
        soin.setSejour(s);
        soin.setTitulaire(titulaire);
        soin.setTypeSoin(typeSoin);
        
        return SoinDAOImpl.getInstance().update(soin);
    }

}
