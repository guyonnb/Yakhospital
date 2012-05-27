/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import org.hibernate.Session;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Titulaire;

/**
 *
 * @author Audrey
 */
public class MainService {

    public static void main(String[] args) {

        Integer idP1 = PatientService.creerPatient("Dupont", "Jean", "1234567889123", 18,
                "rue des meches", "94000", "Creteil", "H",
                null, "0112345679", "0632659814", "note");
        Integer idP2 = PatientService.creerPatient("Kant", "Emmanuel", "1530675544655", 19,
                "rue des meches", "75000", "Paris", "H",
                null, "0112345679", "0623659814", "note");
        Integer idP3 = PatientService.creerPatient("Fourier", "Charles", "1410145546564", 1,
                "rue des meches", "01000", "Ain", "H",
                null, "0112345679", "0623659814", "note");
        Integer idP4 = PatientService.creerPatient("Marx", "Karl", "1120712546455", 2,
                "rue des meches", "09000", "Ariège", "H",
                null, "0112345679", "0623659814", "note");
        Integer idP5 = PatientService.creerPatient("Epicure", "Or", "1300678546546", 3,
                "rue des meches", "41000", "Loir-et-Cher", "H",
                null, "0112345679", "0623659814", "note");
        Integer idP6 = PatientService.creerPatient("San", "Goku", "1820694654658", 5,
                "rue des meches", "43000", "Haute-Loire", "H",
                null, "0112345679", "0623659814", "note");
        Integer idP7 = PatientService.creerPatient("Shiina", "Yuya", "2860599554668", 4,
                "rue des meches", "50000", "Manche", "F",
                null, "0112345679", "0623659814", "note");
        Integer idP8 = PatientService.creerPatient("Valentine", "Nana", "2951179532456", 6,
                "rue des meches", "76", "Seine-Maritime", "F",
                null, "0112345679", "0623659814", "note");
        Integer idP9 = PatientService.creerPatient("Osaki", "Yuya", "2980699245597", 7,
                "rue des meches", "84000", "Vaucluse", "F",
                null, "0112345679", "0623659814", "note");
        Integer idP10 = PatientService.creerPatient("Vika", "Barosse", "3992500245597", 8,
                "rue des meches", "91000", "Essonne", "F",
                null, "0112345679", "0623659814", "note");

        PosteService.creerPoste("Administrateur");
        PosteService.creerPoste("Medecin");
        PosteService.creerPoste("Chirurgien");
        PosteService.creerPoste("Aide soignant");
        PosteService.creerPoste("Secretaire");
        PosteService.creerPoste("Interne");

        Integer idPediatrie = ServiceService.creerService("Pediatrie");
        Integer idPsychiatrie = ServiceService.creerService("Psychiatrie");
        Integer idNeurologie = ServiceService.creerService("Neurologie");
        Integer idCpre = ServiceService.creerService("CPRE"); //Chirurgie plastique, reconstructrice et esthétique
        Integer idCancerologie = ServiceService.creerService("Cancerologie");
        Integer idCardiologie = ServiceService.creerService("Cardiologie");
        Integer idOrthopedie = ServiceService.creerService("Orthopedie");
        Integer idAr = ServiceService.creerService("AR");//Anesthésie et réanimation = salles de réveil

        SalleService.creerSalle(15, "3", idPediatrie);
        SalleService.creerSalle(2, "1", idPsychiatrie);
        SalleService.creerSalle(8, "2", idNeurologie);
        SalleService.creerSalle(4, "1", idCpre);
        SalleService.creerSalle(3, "1", idCancerologie);
        SalleService.creerSalle(5, "1", idCardiologie);
        SalleService.creerSalle(10, "2", idOrthopedie);
        SalleService.creerSalle(5, "1", idAr);
        
        Integer t1 = TitulaireService.creerTitulaire("Joel", "Yven", "123");
        Integer t2 = TitulaireService.creerTitulaire("Hisaishi", "Joe", "456");
        Integer t3 = TitulaireService.creerTitulaire("Amadeus", "Mozart", "891");
        Integer t4 = TitulaireService.creerTitulaire("LudovicVan", "Beethoven", "333");
        Integer t5 = TitulaireService.creerTitulaire("Bellin", "Camille", "666");
        Integer t6 = TitulaireService.creerTitulaire("Bartolomeo", "Cristofori", "951");
        
        Integer posteAdmin = PosteService.creerPoste("Administrateur");
        Integer posteMed = PosteService.creerPoste("Medecin");
        Integer posteChir = PosteService.creerPoste("Chirurgien");
        Integer posteAidSoi = PosteService.creerPoste("Aide soignant");
        Integer posteSecret = PosteService.creerPoste("Secretaire");
        Integer posteInterne = PosteService.creerPoste("Interne");
        
        TitulaireService.modifierPosteTitulaire(t1, posteAdmin);        
        TitulaireService.modifierPosteTitulaire(t2, posteMed);        
        TitulaireService.modifierPosteTitulaire(t3, posteChir);        
        TitulaireService.modifierPosteTitulaire(t4, posteAidSoi);        
        TitulaireService.modifierPosteTitulaire(t5, posteSecret);        
        TitulaireService.modifierPosteTitulaire(t6, posteInterne);        
                
        TypeSoinService.creerTypeSoin("Coloscopie");
        TypeSoinService.creerTypeSoin("Fibriscopie");
        TypeSoinService.creerTypeSoin("intensifs");
        TypeSoinService.creerTypeSoin("Consultation");
        
//        SejourService.creerSejour(null, null, idCpre, idAr);
//        SejourService.creerSejour(null, null, idCpre, idAr);
//        SejourService.creerSejour(null, null, idCpre, idAr);
//        SejourService.creerSejour(null, null, idCpre, idAr);
//        SejourService.creerSejour(null, null, idCpre, idAr);
//                
//        SoinService.creerSoin(null, "comment", null, null, null);
//        SoinService.creerSoin(null, "comment", null, null, null);
//        SoinService.creerSoin(null, "comment", null, null, null);
//        SoinService.creerSoin(null, "comment", null, null, null);
//        SoinService.creerSoin(null, "comment", null, null, null);
        
        
        Session session = HibUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction t = session.beginTransaction();

        t.commit();
    }
}
