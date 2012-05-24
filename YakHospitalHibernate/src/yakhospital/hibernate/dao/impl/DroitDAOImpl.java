/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.Droit;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.dao.DroitDAO;

/**
 *
 * @author djenou_m
 */
public class DroitDAOImpl implements DroitDAO{
    
                                      
    // Instance de notre singleton
    private static final DroitDAOImpl instance = new DroitDAOImpl();
    // Constructeur prive du singleton
    private DroitDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public DroitDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Droit selon l’ID avec Criteria
    */
    @Override
    public Droit get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Droit
        Criteria crit = sess.createCriteria(Droit.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Droit droit = (Droit) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return droit;
    }

    /*
    * Recupere la liste des Droits
    */
    @Override
    public List<Droit> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Droit.class);
        // On recupere la liste des Droits
        List<Droit> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Droit
    */
    @Override
    public Integer save(Droit droit)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Droit
        Integer id = (Integer) sess.save(droit);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Droit droit)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Droit
            sess.update(droit);
            t.commit();
            return true;
        }
        catch (HibernateException e)
        {
            return false;
        }
    }
    
    /*
    * Exemple d’utilisation avec le HQL pour supprimer un Droit
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from droit where id=:id";
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
            return false;
        }
    }
}
