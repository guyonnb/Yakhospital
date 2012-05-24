/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;

import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.Poste;
import yakhospital.hibernate.dao.PosteDAO;

/**
 *
 * @author djenou_m
 */
public class PosteDAOImpl implements PosteDAO {
 
                              
    // Instance de notre singleton
    private static final PosteDAOImpl instance = new PosteDAOImpl();
    // Constructeur prive du singleton
    private PosteDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public PosteDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un Poste selon l’ID avec Criteria
    */
    @Override
    public Poste get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Poste
        Criteria crit = sess.createCriteria(Poste.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Poste poste = (Poste) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return poste;
    }

    /*
    * Recupere la liste des Postes
    */
    @Override
    public List<Poste> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Poste.class);
        // On recupere la liste des Postes
        List<Poste> list = crit.list();
        t.commit();
        return list;
    }

    @Override
    public List<Poste> listByService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*
    * Sauve un Poste
    */
    @Override
    public Integer save(Poste poste)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le Poste
        Integer id = (Integer) sess.save(poste);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(Poste poste)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le Poste
            sess.update(poste);
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
    * Exemple d’utilisation avec le HQL pour supprimer un Poste
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from poste where id=:id";
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
