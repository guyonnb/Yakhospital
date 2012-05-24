/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.TypeSoin;

/**
 *
 * @author djenou_m
 */
public interface TypeSoinDAO {
    public List<TypeSoin> list();
    public TypeSoin get(Integer id);
    public Integer save(TypeSoin typesoin);
    public Boolean update(TypeSoin typesoin);
    public Boolean delete(Integer id);
}
