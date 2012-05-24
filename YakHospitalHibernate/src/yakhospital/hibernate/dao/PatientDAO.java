/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yakhospital.hibernate.dao;

import java.util.List;
import yakhospital.hibernate.Patient;
import yakhospital.hibernate.Sejour;

/**
 *
 * @author djenou_m
 */
public interface PatientDAO {
    public List<Patient> list();
    public Patient get(Integer id);
    public Integer save(Patient patient);
    public Boolean update(Patient patient);
    public Boolean delete(Integer id);

    public Sejour getSejourEnCours(Integer idPatient);
}
