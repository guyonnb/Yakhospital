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
public class Titulaire implements Serializable {

    private Integer id_titulaire;
    private String nom_titulaire;
    private String prenom_titulaire;
    private String num_pro;
    private String mdp;
    private Poste poste;
    private Service service;
    private Set<Soin> soins;

    public Titulaire(String nom_titulaire, String prenom_titulaire, String num_pro) {
        this.nom_titulaire = nom_titulaire;
        this.prenom_titulaire = prenom_titulaire;
        this.num_pro = num_pro;
        this.mdp = "";
        this.soins = new HashSet<>();
    }

    public Titulaire() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_titulaire() {
        return id_titulaire;
    }

    public String getNom_titulaire() {
        return nom_titulaire;
    }

    public String getNum_pro() {
        return num_pro;
    }

    public String getPrenom_titulaire() {
        return prenom_titulaire;
    }

    public void setId_titulaire(Integer id_titulaire) {
        this.id_titulaire = id_titulaire;
    }

    public void setNom_titulaire(String nom_titulaire) {
        this.nom_titulaire = nom_titulaire;
    }

    public void setNum_pro(String num_pro) {
        this.num_pro = num_pro;
    }

    public void setPrenom_titulaire(String prenom_titulaire) {
        this.prenom_titulaire = prenom_titulaire;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Poste.class)
    @JoinColumn(name = "id_poste")
    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Service.class)
    @JoinColumn(name = "id_service")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        
        this.service = service;
    }

    @OneToMany(mappedBy = "titulaire")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_titulaire")
    public Set<Soin> getSoins() {
        return soins;
    }

    public void setSoins(Set<Soin> soins) {
        this.soins = soins;
    }
    
    public void addSoin(Soin soin) {
        this.soins.add(soin);
    }
}
