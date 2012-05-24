/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Poste;

/**
 *
 * @author djenou_m
 */
public interface PosteDAO {
    public List<Poste> list();
    public List<Poste> listByService();
    public Poste get(Integer id);
    public Integer save(Poste poste);
    public Boolean update(Poste poste);
    public Boolean delete(Integer id);
}
