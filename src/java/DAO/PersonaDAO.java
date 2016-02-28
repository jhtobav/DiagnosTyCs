package DAO;


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
public class PersonaDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
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
    
    public Persona searchByNombre(String nombre) {
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Persona.findByNombre");
        q.setParameter("nombre", "Luis Cardozo");
        System.out.println("pucha");
        System.out.println(q.getSingleResult().getClass().getCanonicalName());
        Persona persona = (Persona) q.getSingleResult();
        em.close();
        return persona;
        
    }
    
}
