/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Doctor;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jhtob
 */
public class DoctorDAO {
    

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Doctor searchByIdDoctor(Long idDoctor) {
        EntityManager em = emf.createEntityManager();
        Doctor doctor = null;
        try {
            doctor = em.find(Doctor.class
                    , idDoctor);
        } catch (Exception e){
        } finally {
            em.close();
            return doctor;
        }
      
    }
}
