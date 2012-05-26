/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author djenou_m
 */
@Entity
public class Poste implements Serializable {

    private Integer id_poste;
    private String nom_poste;
    private Set<Titulaire> titulaires;
    private Set<Droit> droits;

    public Poste() {
    }

    public Poste(String nom_poste) {
        this.nom_poste = nom_poste;
        this.titulaires = new HashSet<>();
        this.droits = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_poste() {
        return id_poste;
    }

    public void setId_poste(Integer id_poste) {
        this.id_poste = id_poste;
    }

    public String getNom_poste() {
        return nom_poste;
    }

    public void setNom_poste(String nom_poste) {
        this.nom_poste = nom_poste;
    }

    @OneToMany(mappedBy = "poste")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_poste")
    public Set<Titulaire> getTitulaires() {
        return titulaires;
    }

    public void setTitulaires(Set<Titulaire> titulaires) {
        this.titulaires = titulaires;
    }

    @ManyToMany(targetEntity = yakhospital.hibernate.Droit.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "poste_droit", joinColumns =
    @JoinColumn(name = "id_poste"), inverseJoinColumns =
    @JoinColumn(name = "id_droit"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<Droit> getDroits() {
        return droits;
    }

    public void setDroits(Set<Droit> droits) {
        this.droits = droits;
    }
    
    public void ajouterTitulaire(Titulaire titulaire)
    {
        this.titulaires.add(titulaire);
    }
}
