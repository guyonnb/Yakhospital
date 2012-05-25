/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.Soin;

/**
 *
 * @author Morgane
 */
public class SejourService {

    private SejourService() {
    }

    static Sejour creerSejour(String raisonAdmission, Calendar dateDebut, Patient patient, Soin soin) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    static Sejour creerSejour(String raisonAdmission, Calendar dateDebut, Integer idPatient, Integer idSoin) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    static void ajouterSoin(Sejour sejour, Soin soin) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
