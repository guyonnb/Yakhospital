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
@Entity
public class Sejour implements Serializable {

    private Integer id_sejour;
    private String raison_admission;
    private boolean status;
    private Calendar date_debut;
    private Calendar date_fin;
    private Patient patient;
    private Set<Soin> soins;

    public Sejour() {
    }

    public Sejour(String raison_admission, Calendar date_debut, Patient patient) {
        this.raison_admission = raison_admission;
        this.date_debut = date_debut;
        this.patient = patient;
        this.status = true;
    }

   

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Calendar getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Calendar date_debut) {
        this.date_debut = date_debut;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Calendar getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Calendar date_fin) {
        this.date_fin = date_fin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_sejour() {
        return id_sejour;
    }

    public void setId_sejour(Integer id_sejour) {
        this.id_sejour = id_sejour;
    }

    public String getRaison_admission() {
        return raison_admission;
    }

    public void setRaison_admission(String raison_admission) {
        this.raison_admission = raison_admission;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Patient.class)
    @JoinColumn(name ="id_patient")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @OneToMany(mappedBy = "sejour")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_sejour")
    public Set<Soin> getSoins() {
        return soins;
    }

    public void setSoins(Set<Soin> lst_soins) {
        this.soins = lst_soins;
    }

    public void ajouterSoin(Soin soin) {
        this.soins.add(soin);
    }
}
