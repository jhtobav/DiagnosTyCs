/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cita;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jhtob
 */
public class CitaDAO {
    
    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Cita createCita(Cita cita) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(cita);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
            return cita;
        }

    }
    
    public Cita updateCita(Cita cita){
        
        Cita nuevaCita = new Cita();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevaCita = em.merge(em.find(Cita.class, cita.getCitaID()));
            nuevaCita.setImagenDiagnosticaCollection(cita.getImagenDiagnosticaCollection());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaCita;
        }
        
    }
    
}
