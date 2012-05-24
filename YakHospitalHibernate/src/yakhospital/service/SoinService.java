/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.Titulaire;
import yakhospital.hibernate.TypeSoin;

/**
 *
 * @author Morgane
 */
public class SoinService {

    private SoinService() {
    }

    static Soin creerSoin(Calendar dateDebutSoin, String commentaire, Sejour s, TypeSoin typeSoin, Titulaire titulaire) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
