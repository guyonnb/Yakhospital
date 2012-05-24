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

    private Integer idSejour;
    private String raison_admission;
    private boolean status;
    private Calendar date_debut;
    private Calendar date_fin;
    private Patient patient;
    private Set<Soin> soins;

    public Sejour() {
    }

    public Sejour(Calendar date_debut, Calendar date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
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
    public Integer getIdSejour() {
        return idSejour;
    }

    public void setIdSejour(Integer idSejour) {
        this.idSejour = idSejour;
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
}
