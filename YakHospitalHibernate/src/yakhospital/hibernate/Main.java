/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import org.hibernate.Session;
import yakhospital.hibernate.dao.impl.PatientDAOImpl;

/**
 *
 * @author djenou_m
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Patient p = new Patient("Dupont", "Jean", "1234567889123");
//
//        Session session = HibUtil.getSessionFactory().getCurrentSession();
//        org.hibernate.Transaction t = session.beginTransaction();
//        session.save(p);
//        t.commit();
        Sejour sejour = PatientDAOImpl.getInstance().getSejourEnCours(2);
        System.out.println(sejour.getId_sejour());
    }
}
