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

    private TitulaireDAOImpl ()
    {
    }
    
    // Récupere le singleton
    static public TitulaireDAO getInstance()
    {
        return instance;
    }

    /*
    * Recupere un titulaire selon son id
    */
    @Override
    public Titulaire get(Integer id)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        Titulaire titulaire = (Titulaire) crit.uniqueResult();
        t.commit();
        return titulaire;
    }

    /*
    * Recupere un titulaire selon son num pro
    */
    @Override
    public Titulaire getTitulaire(String numPro)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On restreint ce critere suivant la valeur du num. prof.
        crit.add(Restrictions.eq("num_pro", numPro));
        // On ne veut et doit recuperer qu’un element
        Titulaire titulaire = (Titulaire) crit.uniqueResult();
        t.commit();
        return titulaire;
    }

    /*
    * Recupere une liste de titulaires suivant un nom
    */
    @Override
    public List<Titulaire> get(String nom)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On restreint ce critere suivant la valeur du nom
        crit.add(Restrictions.eq("nom_titulaire", nom));
        // On veut récuperer une liste de titulaires ayant ce nom
        List<Titulaire> titulaires = crit.list();
        t.commit();
        return titulaires;
    }
    
    /*
    * Recupere un titulaire selon ses nom et prenom
    */
    @Override
    public Titulaire get(String nom, String prenom)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(Titulaire.class);
        // On restreint ce critere suivant le nom ET le prenom
        crit.add(Restrictions.eq("nom_titulaire", nom));
        crit.add(Restrictions.eq("prenom_titulaire", prenom));
        // On ne veut et doit recuperer qu’un element
        Titulaire titulaire = (Titulaire) crit.uniqueResult();
        t.commit();
        return titulaire;
    }
    
    
    /*
    * Renvoie la liste de tous les titulaires
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

    /*
    * Met à jour un titulaire
    */
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
            return false;
        }
    }
    
    /*
    * Supprime un titulaire
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
            return false;
        }
    }
}
