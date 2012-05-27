/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Lit;
import yakhospital.hibernate.dao.LitDAO;

/**
 *
 * @author djenou_m
 */
public class LitDAOImpl implements LitDAO{
    
                          
    // Instance de notre singleton
    private static final LitDAOImpl instance = new LitDAOImpl();
    // Constructeur prive du singleton
    private LitDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public LitDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Lit selon l’ID avec Criteria
    */
    @Override
    public Lit get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Lit
        Criteria crit = sess.createCriteria(Lit.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Lit lit = (Lit) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return lit;
    }

    /*
    * Recupere la liste des Lits
    */
    @Override
    public List<Lit> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Lit.class);
        // On recupere la liste des Lits
        List<Lit> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un Lit
    */
    @Override
    public Integer save(Lit lit)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Lit
        Integer id = (Integer) sess.save(lit);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Lit lit)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Lit
            sess.update(lit);
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
    * Exemple d’utilisation avec le HQL pour supprimer un Lit
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from lit where id=:id";
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
