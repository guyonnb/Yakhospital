/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Salle;

/**
 *
 * @author djenou_m
 */
public interface SalleDAO {
   
    public List<Salle> list();
    public Salle get(Integer id);
    public Integer save(Salle salle);
    public Boolean update(Salle salle);
    public Boolean delete(Integer id);
}
