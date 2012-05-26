/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao.impl;


import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import yakhospital.hibernate.HibUtil;
import yakhospital.hibernate.TypeSoin;
import yakhospital.hibernate.dao.TypeSoinDAO;

/**
 *
 * @author djenou_m
 */
public class TypeSoinDAOImpl implements TypeSoinDAO {
 
        
    // Instance de notre singleton
    private static final TypeSoinDAOImpl instance = new TypeSoinDAOImpl();
    // Constructeur prive du singleton
    private TypeSoinDAOImpl ()
    {
    }
    
    // La methode pour recuperer le singleton
    static public TypeSoinDAO getInstance()
    {
        return instance;
    }

    /*
    * La methode pour recuperer un conducteur selon l’ID avec Criteria
    */
    @Override
    public TypeSoin get(Integer id)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Driver
        Criteria crit = sess.createCriteria(TypeSoin.class);
        // On restreint ce critere suivant la valeur de l’id voulue
        crit.add(Restrictions.eq("id", id));
        // On ne veut et doit recuperer qu’un element
        TypeSoin typesoin = (TypeSoin) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return typesoin;
    }

    
    /*
    * La methode pour recuperer un conducteur selon le nom du soin
    */
    @Override
    public TypeSoin get(String nomSoin)
    {
        // On recupere la session
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        // On commence une transaction avec la base
        Transaction t = sess.beginTransaction();
        // On creer un critere suivant la classe Driver
        Criteria crit = sess.createCriteria(TypeSoin.class);
        // On restreint ce critere suivant la valeur de le nom voulu
        crit.add(Restrictions.eq("nom_soin", nomSoin));
        // On ne veut et doit recuperer qu’un element
        TypeSoin typesoin = (TypeSoin) crit.uniqueResult();
        // On finalise la transaction
        t.commit();
        return typesoin;
    }

    
    /*
    * Recupere la liste des conducteurs
    */
    @Override
    public List<TypeSoin> list() {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        Criteria crit = sess.createCriteria(TypeSoin.class);
        // On recupere la liste des conducteurs
        List<TypeSoin> list = crit.list();
        t.commit();
        return list;
    }
    
    /*
    * Sauve un conducteur
    */
    @Override
    public Integer save(TypeSoin typesoin)
    {
        Session sess = HibUtil.getSessionFactory().
        getCurrentSession();
        Transaction t = sess.beginTransaction();
        // On sauvegarde le conducteur
        Integer id = (Integer) sess.save(typesoin);
        t.commit();
        return id;
    }

    @Override
    public Boolean update(TypeSoin typesoin)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            Transaction t = sess.beginTransaction();
            // On met a jour le conducteur
            sess.update(typesoin);
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
    * Exemple d’utilisation avec le HQL pour supprimer un conducteur
    */
    @Override
    public Boolean delete(Integer id)
    {
        try
        {
            Session sess = HibUtil.getSessionFactory().
            getCurrentSession();
            String req = "Delete from type_soin where id=:id";
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
