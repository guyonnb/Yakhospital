/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author djenou_m
 */
@Entity // Specifie que la classe correspond a une table.
public class Patient implements Serializable {

    private Integer idPatient;
    private String nom_patient;
    private String prenom_patient;
    private String nss;
    private Integer numero_rue;
    private String rue;
    private String cp;
    private String ville;
    private String sexe;
    private Calendar naissance;
    private String tel;
    private String tel_urgence;
    private String note;
    private Set<Sejour> sejours;

    public Patient() {
    }

    public Patient(String nom_patient, String prenom_patient, String nss) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.nss = nss;
    }

    public Patient(String nom_patient, String prenom_patient,
            String nss, Integer num_rue, String rue, String cp,
            String ville, String sexe, Calendar naissance, String tel,
            String tel_urgence, String note) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.nss = nss;
        this.numero_rue = num_rue;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.sexe = sexe;
        this.naissance = naissance;
        this.tel = tel;
        this.tel_urgence = tel_urgence;
        this.note = note;
    }

    public Patient(String nom_patient, String prenom_patient,
            String nss, Integer num_rue, String rue, String cp,
            String ville, String sexe, Calendar naissance, String tel,
            String tel_urgence, String note, Set<Sejour> sejours) {
        this.nom_patient = nom_patient;
        this.prenom_patient = prenom_patient;
        this.nss = nss;
        this.numero_rue = num_rue;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.sexe = sexe;
        this.naissance = naissance;
        this.tel = tel;
        this.tel_urgence = tel_urgence;
        this.note = note;
        this.sejours = sejours;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        if (!this.cp.equals(cp)) {
            this.cp = cp;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        if (this.idPatient != idPatient) {
            this.idPatient = idPatient;
        }
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Calendar getNaissance() {
        return naissance;
    }

    public void setNaissance(Calendar naissance) {
        if (this.naissance != naissance) {
            this.naissance = naissance;
        }
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public void setNom_patient(String nom_patient) {
        if (!this.nom_patient.equals(nom_patient)) {
            this.nom_patient = nom_patient;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        if (!this.note.equals(note)) {
            this.note = note;
        }
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        if (!this.nss.equals(nss)) {
            this.nss = nss;
        }
    }

    public Integer getNumero_rue() {
        return numero_rue;
    }

    public void setNumero_rue(Integer numero_rue) {
        if (this.numero_rue != numero_rue) {
            this.numero_rue = numero_rue;
        }
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public void setPrenom_patient(String prenom_patient) {
        if (!this.prenom_patient.equals(prenom_patient)) {
            this.prenom_patient = prenom_patient;
        }
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        if (!this.rue.equals(rue)) {
            this.rue = rue;
        }
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if (!this.sexe.equals(sexe)) {
            this.sexe = sexe;
        }
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if (!this.tel.equals(tel)) {
            this.tel = tel;
        }
    }

    public String getTel_urgence() {
        return tel_urgence;
    }

    public void setTel_urgence(String tel_urgence) {
        if (!this.tel_urgence.equals(tel_urgence)) {
            this.tel_urgence = tel_urgence;
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        if (!this.ville.equals(ville)) {
            this.ville = ville;
        }
    }

    @OneToMany(mappedBy = "patient")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_patient")
    public Set<Sejour> getSejours() {
        return sejours;
    }

    public void setSejours(Set<Sejour> sejours) {
        this.sejours = sejours;
    }
    
    public void ajouterSejour(Sejour sejour)
    {
        sejours.add(sejour);
    }
}
