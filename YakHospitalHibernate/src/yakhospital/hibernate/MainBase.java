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
public class MainBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * variable : date = date du jour de creation date_de_fin : date de fin
         */
        Calendar date = Calendar.getInstance();
        Calendar date_fin = Calendar.getInstance();
        date_fin.set(2014, 12, 16, 0, 0, 0);
        
        /*
         * creation : Patient -> OK Poste -> OK Service -> OK Lit -> OK
         */
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

        Poste posteAdmin = new Poste("Administrateur");
        Poste posteMed = new Poste("Medecin");
        Poste posteChir = new Poste("Chirurgien");
        Poste posteAidSoi = new Poste("Aide soignant");
        Poste posteSecret = new Poste("Secretaire");
        Poste posteInterne = new Poste("Interne");

        Service Pediatrie = new Service("Pediatrie");
        Service Psychiatrie = new Service("Psychiatrie");
        Service Neurologie = new Service("Neurologie");
        Service cpre = new Service("cpre"); //Chirurgie plastique, reconstructrice et esthétique
        Service Cancerologie = new Service("Cancerologie");
        Service Cardiologie = new Service("Cardiologie");
        Service Orthopedie = new Service("Orthopedie");
        Service ar = new Service("ar");//Anesthésie et réanimation = lits de réveil

        Lit s1 = new Lit(15, "litPédiatrie", Pediatrie);
        Lit s2 = new Lit(2, "litNeurologie", Neurologie);
        Lit s3 = new Lit(8, "litPsychiatrie", Psychiatrie);
        Lit s4 = new Lit(4, "litCPRE", cpre);
        Lit s5 = new Lit(3, "litCancerologie", Cancerologie);
        Lit s6 = new Lit(5, "litCardiologie", Cardiologie);
        Lit s7 = new Lit(10, "litOrthopedie", Orthopedie);
        Lit s8 = new Lit(5, "litAR", ar);
        /*
         * association service <-> lit
         */
        Pediatrie.ajouterLit(s1);
        Neurologie.ajouterLit(s2);
        Psychiatrie.ajouterLit(s3);
        cpre.ajouterLit(s4);
        Cancerologie.ajouterLit(s5);
        Cardiologie.ajouterLit(s6);
        Orthopedie.ajouterLit(s7);
        ar.ajouterLit(s8);

        /*
         * creation : Titulaire typeSoin
         */
        Titulaire t1 = new Titulaire("Joel", "Yven", "123");
        Titulaire t2 = new Titulaire("Hisaishi", "Joe", "456");
        Titulaire t3 = new Titulaire("Amadeus", "Mozart", "891");
        Titulaire t4 = new Titulaire("ludovicVan", "Beethoven", "333");
        Titulaire t5 = new Titulaire("ray", "charles", "666");
        Titulaire t6 = new Titulaire("Bartolomeo", "Cristofori", "951");
        /*
         * assocition titulaire <-> poste
         */
        t1.setPoste(posteAdmin);
        t2.setPoste(posteMed);
        t3.setPoste(posteChir);
        t4.setPoste(posteAidSoi);
        t5.setPoste(posteSecret);
        t6.setPoste(posteInterne);
        
        /*
         * creation : de type de soin; 
         */
        TypeSoin ts1 = new TypeSoin("Coloscopie");
        TypeSoin ts2 = new TypeSoin("intensifs");
        TypeSoin ts3 = new TypeSoin("Consultation");
        TypeSoin ts4 = new TypeSoin("Puericulture");

        /*
         * association patient <-> soin
         */

        Soin soin1 = new Soin(date, date_fin, "comment", ts1, t2, p1);
        soin1.setLit(s8);
        Soin soin2 = new Soin(date, date_fin, "comment", ts2, t2, p5);
        Soin soin3 = new Soin(date, date_fin, "comment", ts3, t3, p2);
        Soin soin4 = new Soin(date, date_fin, "comment", ts4, t4, p7);
        
        p1.ajouterSoin(soin1);
        p5.ajouterSoin(soin2);
        p2.ajouterSoin(soin3);
        p7.ajouterSoin(soin4);

        /*
         * creation de la liste de patient puis ajout patient dans liste
         */
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

        /*
         * sauvegarde le patient et tous ses attributs
         */
        for (Patient p : myList) {
            session.save(p);
        }
        t.commit();
    }
}
