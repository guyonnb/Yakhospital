/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import java.util.List;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.PatientDAOImpl;
import yakhospital.hibernate.dao.impl.SoinDAOImpl;

/**
 *
 * @author Morgane
 */
public class PatientService {

    private PatientService() {
    }

    public static Integer creerPatient(String nomPatient, String PrenomPatient,
            String nss, Integer numRue, String rue, String cp, String ville,
            String sexe, Calendar naissance, String tel, String telUrgence,
            String note) {
        Patient patient = new Patient(nomPatient, PrenomPatient, nss, numRue,
                rue, cp, ville, sexe, naissance, tel, telUrgence, note);

        return PatientDAOImpl.getInstance().save(patient);
    }

    public static Boolean modifierPatient(Patient patient, String nomPatient,
            String PrenomPatient, String nss, Integer numRue, String rue,
            String cp, String ville, String sexe, Calendar naissance,
            String tel, String telUrgence, String note) {
        patient.setNom_patient(nomPatient);
        patient.setPrenom_patient(PrenomPatient);
        patient.setNss(nss);
        patient.setNumero_rue(numRue);
        patient.setRue(rue);
        patient.setCp(cp);
        patient.setVille(ville);
        patient.setSexe(sexe);
        patient.setNaissance(naissance);
        patient.setTel(tel);
        patient.setTel_urgence(telUrgence);
        patient.setNote(note);

        return PatientDAOImpl.getInstance().update(patient);
    }

    public static Boolean modifierPatient(Integer idPatient, String nomPatient,
            String PrenomPatient, String nss, Integer numRue, String rue,
            String cp, String ville, String sexe, Calendar naissance,
            String tel, String telUrgence, String note) {
        Patient patient = PatientDAOImpl.getInstance().get(idPatient);

        patient.setNom_patient(nomPatient);
        patient.setPrenom_patient(PrenomPatient);
        patient.setNss(nss);
        patient.setNumero_rue(numRue);
        patient.setRue(rue);
        patient.setCp(cp);
        patient.setVille(ville);
        patient.setSexe(sexe);
        patient.setNaissance(naissance);
        patient.setTel(tel);
        patient.setTel_urgence(telUrgence);
        patient.setNote(note);

        return PatientDAOImpl.getInstance().update(patient);
    }

    public static Boolean supprimerPatient(Integer idPatient) {
        return PatientDAOImpl.getInstance().delete(idPatient);
    }

    public static Boolean supprimerPatient(Patient patient) {
        return PatientDAOImpl.getInstance().delete(patient.getId_patient());
    }

    public static void ajouterSoin(Patient patient, Soin soin) {
        soin.setPatient(patient);
        patient.ajouterSoin(soin);
    }

    public static void ajouterSoin(Integer idPatient, Integer idSoin) {
        Patient patient = PatientDAOImpl.getInstance().get(idPatient);
        Soin soin = SoinDAOImpl.getInstance().get(idSoin);
        soin.setPatient(patient);
        patient.ajouterSoin(soin);
    }
    
    public static List<Patient> getPatientByNom(String nom)
    {
        return PatientDAOImpl.getInstance().getByNom(nom);
    }
    
    public static List<Patient> getPatientByNomPrenom(String nom, String prenom)
    {
        return PatientDAOImpl.getInstance().getByNomPrenom(nom, prenom);
    }
    
    public static Patient getPatientByNss(String nss)
    {
        return PatientDAOImpl.getInstance().getByNss(nss);
    }
}