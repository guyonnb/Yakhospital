/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.List;
import yakhospital.hibernate.TypeSoin;
import yakhospital.hibernate.dao.impl.TypeSoinDAOImpl;

/**
 *
 * @author Emilie
 */
public class TypeSoinService {
    
    private TypeSoinService()
    {
    }
    
    // Crée un nouveau type de soin
    public static Integer creerTypeSoin(String nomSoin)
    {
           TypeSoin soin = new TypeSoin(nomSoin);
        return TypeSoinDAOImpl.getInstance().save(soin);
    }
    
    // Modifie le nom d'un type de soin
    public static Boolean modifierTypeSoin (TypeSoin typeSoin, String nomSoin)
    {
        typeSoin.setNom_soin(nomSoin);
        return TypeSoinDAOImpl.getInstance().update(typeSoin);
    }
    
    // Supprime un type de soin
    public static Boolean supprimerTypeSoin (TypeSoin typeSoin)
    {
        return TypeSoinDAOImpl.getInstance().delete(typeSoin.getId_type_soin());
    }
    
    // Renvoie une liste de otous les soins
    public static List<TypeSoin> getAllTypeSoin()
    {
        return TypeSoinDAOImpl.getInstance().list();
    }
    
    // Renvoie un type de soin suivant son id
    public static TypeSoin getTypeSoin(Integer idSoin)
    {
        return TypeSoinDAOImpl.getInstance().get(idSoin);
    }
    
    // Renvoie un type de soin suivant son nom
    public static TypeSoin getTypeSoin(String nomSoin)
    {
        return TypeSoinDAOImpl.getInstance().get(nomSoin);
    }
    
}
