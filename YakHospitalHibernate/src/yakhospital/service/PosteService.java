/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.service;

import java.util.List;
import yakhospital.hibernate.Poste;
import yakhospital.hibernate.dao.impl.PosteDAOImpl;

/**
 *
 * @author Morgane
 */
public class PosteService {
    
    public Integer creerPoste(String nomPoste)
    {
        Poste p = new Poste(nomPoste);
        return PosteDAOImpl.getInstance().save(p);
    }
    
    public Boolean modifierPoste (Poste poste, String nomPoste)
    {
        poste.setNom_poste(nomPoste);
        return PosteDAOImpl.getInstance().update(poste);
    }
    
    public Boolean modifierPoste (Integer idPoste, String nomPoste)
    {
        Poste p = PosteDAOImpl.getInstance().get(idPoste);
        p.setNom_poste(nomPoste);
        return PosteDAOImpl.getInstance().update(p);
    }
    
    public Boolean supprimerPoste(Integer idPoste) 
    {
        return PosteDAOImpl.getInstance().delete(idPoste);
    }
    
    public Boolean supprimerPoste(Poste poste) 
    {
        return PosteDAOImpl.getInstance().delete(poste.getId_poste());
    }
    
    public List<Poste> getAllPostes()
    {
        return PosteDAOImpl.getInstance().list();
    }
}
