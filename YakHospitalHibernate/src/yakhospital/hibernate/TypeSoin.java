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

    private Integer id_type_soin;
    private String nom_soin;

    public TypeSoin() {
    }

    public TypeSoin(String nom_soin) {
        this.nom_soin = nom_soin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_TYPE_SOIN")
    public Integer getId_type_soin() {
        return id_type_soin;
    }

    public void setId_type_soin(Integer id_type_soin) {
        this.id_type_soin = id_type_soin;
    }

    @Column(name="NOM_SOIN")
    public String getNom_soin() {
        return nom_soin;
    }

    public void setNom_soin(String nom_soin) {
        this.nom_soin = nom_soin;
    }
}
