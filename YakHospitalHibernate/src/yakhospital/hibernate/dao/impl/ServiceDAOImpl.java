/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Service;
import yakhospital.hibernate.dao.ServiceDAO;

/**
 *
 * @author djenou_m
 */
public class ServiceDAOImpl implements ServiceDAO{
 
                  
    // Instance de notre singleton
    private static final ServiceDAOImpl instance = new ServiceDAOImpl();
    // Constructeur prive du singleton
    private ServiceDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public ServiceDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Service selon l’ID avec Criteria
    */
    @Override
    public Service get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Service
        Criteria crit = sess.createCriteria(Service.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Service service = (Service) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return service;
    }

    /*
    * Recupere la liste des Services
    */
    @Override
    public List<Service> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Service.class);
        // On recupere la liste des Services
        List<Service> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Service
    */
    @Override
    public Integer save(Service service)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Service
        Integer id = (Integer) sess.save(service);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Service service)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Service
            sess.update(service);
            t.commit();
            return true;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    /*
    * Exemple d’utilisation avec le HQL pour supprimer un Service
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from service where id=:id";
            Transaction t = sess.beginTransaction();
            Query q = sess.createQuery(req);
            q.setInteger("id", id.intValue());
            int rowcount = q.executeUpdate();
            t.commit();
            
            if (rowcount != 0)
                return true;
            
            return false;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
