/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Droit;

/**
 *
 * @author djenou_m
 */
public interface DroitDAO {
    public List<Droit> list();
    public Droit get(Integer id);
    public Integer save(Droit droit);
    public Boolean update(Droit droit);
    public Boolean delete(Integer id);
}
