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
public class Lit implements Serializable {

    private Integer id_lit;
    private String nom_lit;
    private Service service;
    private Set<Soin> soins;

    public Lit() {
    }

    public Lit(Integer nb_lits, String nom_lit, Service service) {
        this.nom_lit = nom_lit;
        this.service = service;
        this.soins = new HashSet<>();
    }

  
    public String getNom_lit() {
        return nom_lit;
    }

    public void setNom_lit(String nom_lit) {
        this.nom_lit = nom_lit;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_lit() {
        return id_lit;
    }

    public void setId_lit(Integer id_lit) {
        this.id_lit = id_lit;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Service.class)
    @JoinColumn(name = "id_service")
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @OneToMany(mappedBy = "lit")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_lit")
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
