package DAO;


import Entidades.Persona;
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
public class PersonaDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Persona createPersona(Persona persona) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return persona;
        }

    }
    
    public Persona searchByIdPersona(Long idPersona) {
        EntityManager em = emf.createEntityManager();
        Persona persona = null;
        try {
            persona = em.find(Persona.class
                    , idPersona);
        } catch (Exception e){
        } finally {
            em.close();
            return persona;
        }
      
    }
    
}
