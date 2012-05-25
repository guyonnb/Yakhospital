/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
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
        Calendar date  = Calendar.getInstance();
        Calendar date_fin = Calendar.getInstance();
        date_fin.set(2014, 12, 16);
        
        Patient p1 = new Patient("Dupont", "Jean", "1234567889123");
        Patient p2 = new Patient("Kant", "Emmanuel", "1530675544655");
        Patient p3 = new Patient("Fourier", "Charles", "1410145546564");
        Patient p4 = new Patient("Marx", "Karl", "1120712546455");
        Patient p5 = new Patient("Epicure", "Or", "1300678546546");
        Patient p6 = new Patient("San", "Goku", "1820694654658");
        Patient p7 = new Patient("Shiina", "Yuya", "2860599554668");
        Patient p8 = new Patient("Valentine", "Faye", "2951179532456");
        Patient p9 = new Patient("Osaki", "Nana", "2980699245597");
        Patient p10 = new Patient("Vika", "Barosse", "3992500245597");
        
       
        Titulaire t1 = new Titulaire("Joel", "Yven","123");
        Titulaire t2 = new Titulaire("Hisaishi", "Joe","456");
        Titulaire t3 = new Titulaire("Amadeus", "Mozart","891");
        Titulaire t4 = new Titulaire("ludovicVan", "Beethoven","333");
        
        TypeSoin ts1 = new TypeSoin("Cancérologie");
        TypeSoin ts2 = new TypeSoin("Cardiologie");
        TypeSoin ts3 = new TypeSoin("Psychiatrie");
        TypeSoin ts4 = new TypeSoin("Pédiatrie");
       
        Sejour sejour1 = new Sejour("ulcère", date, p1);
        Sejour sejour2 = new Sejour("ulcère", date, p1);
        Sejour sejour3 = new Sejour("ulcère", date, p1);
        Sejour sejour4 = new Sejour("ulcère", date, p1);
        Sejour sejour5 = new Sejour("ulcère", date, p1);
        Sejour sejour6 = new Sejour("ulcère", date, p1);
        Sejour sejour7 = new Sejour("ulcère", date, p1);
        Sejour sejour8 = new Sejour("ulcère", date, p1);
        
        sejour1.ajouterSoin(new Soin(date, "comment", ts1, t1));
        sejour1.ajouterSoin(new Soin(date, "comment", ts2, t2));
        sejour2.ajouterSoin(new Soin(date, "comment", ts3, t3));
        sejour2.ajouterSoin(new Soin(date, "comment", ts4, t4));
                        
        p10.ajouterSejour(sejour1);
        
        List<Patient> myList = new ArrayList<>();
        myList.add(p1);
        myList.add(p2);
        myList.add(p3);
        myList.add(p4);
        myList.add(p5);
        myList.add(p6);
        myList.add(p7);
        myList.add(p8);
        myList.add(p9);
        myList.add(p10);
         
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction t = session.beginTransaction();
        
        for(Patient p : myList)
            session.save(p);
        
        t.commit();
    }
}
