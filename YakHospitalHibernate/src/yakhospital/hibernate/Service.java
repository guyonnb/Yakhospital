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
@Table(name = "service")
public class Service implements Serializable {

    private Integer id_service;
    private String nom_service;
    private Set<Titulaire> titulaires;
    private Set<Salle> salles;
    private Set<Service> servicesComp;

    public Service() {
    }

    public Service(String nom_service) {
        this.nom_service = nom_service;
        this.titulaires = new HashSet<>();
        this.salles = new HashSet<>();
        this.servicesComp = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_service() {
        return id_service;
    }

    public void setId_service(Integer id_service) {
        this.id_service = id_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    @OneToMany(mappedBy = "service")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_service")
    public Set<Titulaire> getTitulaires() {
        return titulaires;
    }

    public void setTitulaires(Set<Titulaire> lst_titulaires) {
        this.titulaires = lst_titulaires;
    }

    @OneToMany(mappedBy = "service")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinColumn(name = "id_service")
    public Set<Salle> getSalles() {
        return salles;
    }

    public void setSalles(Set<Salle> lst_salles) {
        this.salles = lst_salles;
    }

//    @OneToMany(mappedBy = "service")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
////    @JoinColumn(name = "id_service")
//    public Set<Service> getServicesComp() {
//        return servicesComp;
//    }
    public void setServicesComp(Set<Service> services_comp) {
        this.servicesComp = services_comp;
    }

    public void ajouterTitulaire(Titulaire titulaire) {
        this.titulaires.add(titulaire);
    }
    
    public void ajouterSalle (Salle salle)
    {
        this.salles.add(salle);
    }
    public void ajouterServiceComp (Service service) {
        this.servicesComp.add(this);
    }
}
