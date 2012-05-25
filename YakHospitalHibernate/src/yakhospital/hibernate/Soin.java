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
    private Sejour sejour;
    private Salle salle;
    private TypeSoin typeSoin;
    private Titulaire titulaire;

    public Soin(Calendar date_debut_soin, String commentaire, TypeSoin typeSoin, Titulaire titulaire) {
        this.date_debut_soin = date_debut_soin;
        this.commentaire = commentaire;
        this.typeSoin = typeSoin;
        this.titulaire = titulaire;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Salle.class)
    @JoinColumn(name = "id_salle")
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Sejour.class)
    @JoinColumn(name = "id_sejour")
    public Sejour getSejour() {
        return sejour;
    }

    public void setSejour(Sejour sejour) {
        this.sejour = sejour;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = TypeSoin.class)
    @JoinColumn(name = "id_type_soin")
    public TypeSoin getTypeSoin() {
        return typeSoin;
    }

    public void setTypeSoin(TypeSoin typeSoin) {
        this.typeSoin = typeSoin;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Titulaire.class)
    @JoinColumn(name = "id_titulaire")
    public Titulaire getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }
}
