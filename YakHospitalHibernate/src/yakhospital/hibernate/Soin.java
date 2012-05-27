/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author djenou_m
 */
@Entity
@Table(name="soin")
public class Soin implements Serializable {

    private Integer id_soin;
    private Calendar date_debut_soin;
    private Calendar date_fin_soin;
    private String commentaire;
    private Patient patient;
    private Lit lit;
    private TypeSoin typeSoin;
    private Titulaire titulaire;

    public Soin() {
    }

    public Soin(Calendar date_debut_soin, Calendar date_fin_soin, String commentaire, TypeSoin typeSoin, Titulaire titulaire, Patient patient) {
        this.date_debut_soin = date_debut_soin;
        this.commentaire = commentaire;
        this.typeSoin = typeSoin;
        this.titulaire = titulaire;
        this.date_fin_soin = date_fin_soin;
        this.patient = patient;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Calendar getDate_debut_soin() {
        return date_debut_soin;
    }

    public void setDate_debut_soin(Calendar date_debut_soin) {
        this.date_debut_soin = date_debut_soin;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Calendar getDate_fin_soin() {
        return date_fin_soin;
    }

    public void setDate_fin_soin(Calendar date_fin_soin) {
        this.date_fin_soin = date_fin_soin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_soin() {
        return id_soin;
    }

    public void setId_soin(Integer id_soin) {
        this.id_soin = id_soin;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Lit.class)
    @JoinColumn(name = "id_lit")
    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Patient.class)
    @JoinColumn(name = "id_patient")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = TypeSoin.class)
    @JoinColumn(name = "id_type_soin")
    public TypeSoin getTypeSoin() {
        return typeSoin;
    }

    public void setTypeSoin(TypeSoin typeSoin) {
        this.typeSoin = typeSoin;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Titulaire.class)
    @JoinColumn(name = "id_titulaire")
    public Titulaire getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }
}
