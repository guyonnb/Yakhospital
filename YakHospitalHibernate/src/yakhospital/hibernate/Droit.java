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
// Specifie que la classe correspond a une table.
public class Droit implements Serializable {

    private Integer id_droit;
    private String description;
    private Set<Poste> postes;

    public Droit() {
    }
    
    public Droit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId_droit() {
        return id_droit;
    }

    public void setId_droit(Integer id_droit) {
        this.id_droit = id_droit;
    }

    @ManyToMany(targetEntity = yakhospital.hibernate.Poste.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "poste_droit", joinColumns =
    @JoinColumn(name = "id_droit"), inverseJoinColumns =
    @JoinColumn(name = "id_poste"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<Poste> getPostes() {
        return postes;
    }

    public void setPostes(Set<Poste> postes) {
        this.postes = postes;
    }
}
