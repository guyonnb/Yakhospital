/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Sejour;
import yakhospital.hibernate.dao.SejourDAO;

/**
 *
 * @author djenou_m
 */
public class SejourDAOImpl implements SejourDAO {
    
                      
    // Instance de notre singleton
    private static final SejourDAOImpl instance = new SejourDAOImpl();
    // Constructeur prive du singleton
    private SejourDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public SejourDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Sejour selon l’ID avec Criteria
    */
    @Override
    public Sejour get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Sejour
        Criteria crit = sess.createCriteria(Sejour.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Sejour sejour = (Sejour) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return sejour;
    }

    /*
    * Recupere la liste des Sejours
    */
    @Override
    public List<Sejour> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Sejour.class);
        // On recupere la liste des Sejours
        List<Sejour> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Sejour
    */
    @Override
    public Integer save(Sejour sejour)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Sejour
        Integer id = (Integer) sess.save(sejour);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Sejour sejour)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Sejour
            sess.update(sejour);
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
    * Exemple d’utilisation avec le HQL pour supprimer un Sejour
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from Sejour where id=:id";
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
