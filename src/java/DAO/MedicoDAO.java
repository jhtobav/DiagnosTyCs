package DAO;


import Entidades.Medico;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    
    public Medico createMedico(Medico medico) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(medico);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return medico;
        }
    }
    
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
