/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author djenou_m
 */
@Entity
public class Salle implements Serializable {

    private Integer idSalle;
    private Integer nb_lits;
    private String nom_salle;
    private Service service;
    private Set<Soin> soins;

    public Salle() {
    }

    public Salle(Integer nb_lits) {
        this.nb_lits = nb_lits;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
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
}