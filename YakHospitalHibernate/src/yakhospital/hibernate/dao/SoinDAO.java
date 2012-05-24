/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Soin;

/**
 *
 * @author djenou_m
 */
public interface SoinDAO {
    public List<Soin> list();
    public Soin get(Integer id);
    public Integer save(Soin soin);
    public Boolean update(Soin soin);
    public Boolean delete(Integer id);
}
