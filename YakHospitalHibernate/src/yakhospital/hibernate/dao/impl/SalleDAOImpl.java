/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Salle;
import yakhospital.hibernate.dao.SalleDAO;

/**
 *
 * @author djenou_m
 */
public class SalleDAOImpl implements SalleDAO{
    
                          
    // Instance de notre singleton
    private static final SalleDAOImpl instance = new SalleDAOImpl();
    // Constructeur prive du singleton
    private SalleDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public SalleDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Salle selon l’ID avec Criteria
    */
    @Override
    public Salle get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Salle
        Criteria crit = sess.createCriteria(Salle.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Salle salle = (Salle) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return salle;
    }

    /*
    * Recupere la liste des Salles
    */
    @Override
    public List<Salle> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Salle.class);
        // On recupere la liste des Salles
        List<Salle> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Salle
    */
    @Override
    public Integer save(Salle salle)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Salle
        Integer id = (Integer) sess.save(salle);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Salle salle)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Salle
            sess.update(salle);
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
    * Exemple d’utilisation avec le HQL pour supprimer un Salle
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from salle where id=:id";
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
