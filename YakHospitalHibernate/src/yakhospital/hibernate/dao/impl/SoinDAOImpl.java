/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Soin;
import yakhospital.hibernate.dao.SoinDAO;

/**
 *
 * @author djenou_m
 */
public class SoinDAOImpl implements SoinDAO {
    
              
    // Instance de notre singleton
    private static final SoinDAOImpl instance = new SoinDAOImpl();
    // Constructeur prive du singleton
    private SoinDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public SoinDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Soin selon l’ID avec Criteria
    */
    @Override
    public Soin get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Soin
        Criteria crit = sess.createCriteria(Soin.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Soin soin = (Soin) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return soin;
    }

    /*
    * Recupere la liste des Soins
    */
    @Override
    public List<Soin> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Soin.class);
        // On recupere la liste des Soins
        List<Soin> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Soin
    */
    @Override
    public Integer save(Soin soin)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Soin
        Integer id = (Integer) sess.save(soin);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Soin soin)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Soin
            sess.update(soin);
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
    * Exemple d’utilisation avec le HQL pour supprimer un Soin
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from soin where id=:id";
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
