/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Titulaire;
import yakhospital.hibernate.dao.TitulaireDAO;

/**
 *
 * @author djenou_m
 */
public class TitulaireDAOImpl implements TitulaireDAO{
  
            
    // Instance de notre singleton
    private static final TitulaireDAOImpl instance = new TitulaireDAOImpl();
    // Constructeur prive du singleton
    private TitulaireDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public TitulaireDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un titulaire selon l’ID avec Criteria
    */
    @Override
    public Titulaire get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Titulaire
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Titulaire Titulaire = (Titulaire) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return Titulaire;
    }

    /*
    * Recupere la liste des titulaires
    */
    @Override
    public List<Titulaire> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On recupere la liste des titulaires
        List<Titulaire> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un titulaire
    */
    @Override
    public Integer save(Titulaire Titulaire)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le titulaire
        Integer id = (Integer) sess.save(Titulaire);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Titulaire Titulaire)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le titulaire
            sess.update(Titulaire);
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
    * Exemple d’utilisation avec le HQL pour supprimer un titulaire
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from titulaire where id=:id";
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
