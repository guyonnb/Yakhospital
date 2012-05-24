/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Sejour;

/**
 *
 * @author djenou_m
 */
public interface SejourDAO {
  
    public List<Sejour> list();
    public Sejour get(Integer id);
    public Integer save(Sejour sejour);
    public Boolean update(Sejour sejour);
    public Boolean delete(Integer id);
}
