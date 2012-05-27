/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import org.hibernate.Session;
import yakhospital.hibernate.HibUtil;

/**
 *
 * @author Audrey
 */
public class MainService {
    public static void main(String[] args) {
        
        PatientService.creerPatient("Djenoual", "Mohamed", "1168994118244", 18,
                                    "rue des meches", "94000", "Creteil", "H",
                                    null, null, null, "Momo");
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction t = session.beginTransaction();
        
        t.commit();
    }
}
