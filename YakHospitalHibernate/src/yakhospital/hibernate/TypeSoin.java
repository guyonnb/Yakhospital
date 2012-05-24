/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author djenou_m
 */
@Entity
@Table(name="type_soin")
public class TypeSoin implements Serializable {

    private Integer idTypeSoin;
    private String nom_soin;

    public TypeSoin() {
    }

    public TypeSoin(String nom_soin) {
        this.nom_soin = nom_soin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_TYPE_SOIN")
    public Integer getIdTypeSoin() {
        return idTypeSoin;
    }

    public void setIdTypeSoin(Integer idTypeSoin) {
        this.idTypeSoin = idTypeSoin;
    }

    @Column(name="NOM_SOIN")
    public String getNom_soin() {
        return nom_soin;
    }

    public void setNom_soin(String nom_soin) {
        this.nom_soin = nom_soin;
    }
}
