/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.dao.PatientDAO;

/**
 *
 * @author djenou_m
 */
public class PatientDAOImpl implements PatientDAO {

    // Instance de notre singleton
    private static final PatientDAOImpl instance = new PatientDAOImpl();
    // Constructeur prive du singleton

    private PatientDAOImpl() {
    }

    // La methode pour recuperer le singleton
    static public PatientDAO getInstance() {
        return instance;
    }

    /*
     * La methode pour recuperer un Patient selon l’ID avec Criteria
     */
    @Override
    public Patient get(Integer id) {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
                getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Patient
        Criteria crit = sess.createCriteria(Patient.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Patient patient = (Patient) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return patient;
    }

    /*
     * Recupere la liste des Patients
     */
    @Override
    public List<Patient> list() {
        Session sess = HibUtil.getSessionFactory().
                getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Patient.class);
        // On recupere la liste des Patients
        List<Patient> list = crit.list();
        t.commit();
        return list;
    }

    /*
     * Sauve un Patient
     */
    @Override
    public Integer save(Patient patient) {
        Session sess = HibUtil.getSessionFactory().
                getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Patient
        Integer id = (Integer) sess.save(patient);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Patient patient) {
        try {
            Session sess = HibUtil.getSessionFactory().
                    getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Patient
            sess.update(patient);
            t.commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    /*
     * Exemple d’utilisation avec le HQL pour supprimer un Patient
     */
    @Override
    public Boolean delete(Integer id) {
        try {
            Session sess = HibUtil.getSessionFactory().
                    getCurrentSession();
            String req = "Delete from patient where id=:id";
            Transaction t = sess.beginTransaction();
            Query q = sess.createQuery(req);
            q.setInteger("id", id.intValue());
            int rowcount = q.executeUpdate();
            t.commit();

            if (rowcount != 0) {
                return true;
            }

            return false;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    //En cours
    public Sejour getSejourEnCours(Integer idPatient) {
        Session sess = HibUtil.getSessionFactory().
                getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Sejour.class);
        crit.add(Restrictions.like("status", true));
        crit.createCriteria("patient").add(Restrictions.like("id", idPatient));
        Sejour sejour = (Sejour) crit.uniqueResult();
        t.commit();
        return sejour;
    }

    @Override
    public List<Patient> getByNom(String nom) {
        Session sess = HibUtil.getSessionFactory()
                .getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Patient.class);
        // On restreint ce critere suivant la valeur du nom
        crit.add(Restrictions.eq("nom_patient", nom));
        // On veut récuperer une liste de titulaires ayant ce nom
        List<Patient> patients = crit.list();
        t.commit();
        return patients;
    }

    @Override
    public List<Patient> getByNomPrenom(String nom, String prenom) {
        Session sess = HibUtil.getSessionFactory()
                .getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Patient.class);
        // On restreint ce critere suivant la valeur du nom
        crit.add(Restrictions.eq("nom_patient", nom));
        crit.add(Restrictions.eq("prenom_patient", prenom));
        // On veut récuperer une liste de titulaires ayant ce nom
        List<Patient> patients = crit.list();
        t.commit();
        return patients;
    }

    @Override
    public Patient getByNss(String nss) {
        Session sess = HibUtil.getSessionFactory()
                .getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Patient.class);
        // On restreint ce critere suivant la valeur du nom
        crit.add(Restrictions.eq("nss", nss));
        // On veut récuperer une liste de titulaires ayant ce nom
        Patient patient = (Patient) crit.uniqueResult();
        t.commit();
        return patient;
    }
}
