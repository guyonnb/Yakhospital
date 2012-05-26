/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.Calendar;
import java.util.List;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.impl.PatientDAOImpl;

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

    //Quand on ajoute un sejour, on ajoute forcement un soin avec
    public static void ajouterSejour(Patient patient, Sejour sejour) {
        sejour.setPatient(patient);
        patient.ajouterSejour(sejour);
        PatientDAOImpl.getInstance().update(patient);
    }

    //Quand on ajoute un sejour, on ajoute forcement un soin avec
    public static void ajouterSejour(Integer idPatient, Sejour sejour) {
        Patient patient = PatientDAOImpl.getInstance().get(idPatient);
        sejour.setPatient(patient);
        patient.ajouterSejour(sejour);
        PatientDAOImpl.getInstance().update(patient);
    }

    // On ajoute toujours le soin au sejour en cours
    public static void ajouterSoin(Patient patient, Soin soin) {
        Sejour sejour = PatientDAOImpl.getInstance()
                .getSejourEnCours(patient.getId_patient());
        SejourService.ajouterSoin(sejour, soin);
    }

    // On ajoute toujours le soin au sejour en cours
    public static void ajouterSoin(Integer idPatient, Soin soin) {
        Sejour sejour = PatientDAOImpl.getInstance().getSejourEnCours(idPatient);
        SejourService.ajouterSoin(sejour, soin);
    }
    
    public static void cloturerSejourEnCours (Patient patient)
    {
        PatientDAOImpl.getInstance().getSejourEnCours(patient.getId_patient())
                .setStatus(false);
    }
    
    public static void cloturerSejourEnCours (Integer idPatient)
    {
        PatientDAOImpl.getInstance().getSejourEnCours(idPatient)
                .setStatus(false);
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