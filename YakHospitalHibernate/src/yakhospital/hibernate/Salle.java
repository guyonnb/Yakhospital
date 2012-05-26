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
public class Salle implements Serializable {

    private Integer id_salle;
    private Integer nb_lits;
    private String nom_salle;
    private Service service;
    private Set<Soin> soins;

    public Salle() {
    }

    public Salle(Integer nb_lits, String nom_salle, Service service) {
        this.nb_lits = nb_lits;
        this.nom_salle = nom_salle;
        this.service = service;
        this.soins = new HashSet<>();
    }

  
    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_salle() {
        return id_salle;
    }

    public void setId_salle(Integer id_salle) {
        this.id_salle = id_salle;
    }

    public Integer getNb_lits() {
        return nb_lits;
    }

    public void setNb_lits(Integer nb_lits) {
        this.nb_lits = nb_lits;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Service.class)
    @JoinColumn(name = "id_service")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @OneToMany(mappedBy = "salle")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_salle")
    public Set<Soin> getSoins() {
        return soins;
    }

    public void setSoins(Set<Soin> lst_soins) {
        this.soins = lst_soins;
    }
    
    public void ajouterSoin (Soin soin)
    {
        this.soins.add(soin);
    }
}
