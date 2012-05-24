/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Titulaire;

/**
 *
 * @author djenou_m
 */
public interface TitulaireDAO {
    public List<Titulaire> list();
    public Titulaire get(Integer id);
    public Integer save(Titulaire titulaire);
    public Boolean update(Titulaire titulaire);
    public Boolean delete(Integer id);
}
