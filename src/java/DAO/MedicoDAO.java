package DAO;


import Entidades.Medico;
import Entidades.Persona;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhtob
 */
public class MedicoDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Medico searchByIdMedico(Long idMedico) {
        EntityManager em = emf.createEntityManager();
        Medico medico = null;
        try {
            medico = em.find(Medico.class
                    , idMedico);
        } catch (Exception e){
        } finally {
            em.close();
            return medico;
        }
      
    }
    
}
