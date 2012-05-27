/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Lit;

/**
 *
 * @author djenou_m
 */
public interface LitDAO {
   
    public List<Lit> list();
    public Lit get(Integer id);
    public Integer save(Lit lit);
    public Boolean update(Lit lit);
    public Boolean delete(Integer id);
}
