/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Service;

/**
 *
 * @author djenou_m
 */
public interface ServiceDAO {
    public List<Service> list();
    public Service get(Integer id);
    public Integer save(Service service);
    public Boolean update(Service service);
    public Boolean delete(Integer id);
}
