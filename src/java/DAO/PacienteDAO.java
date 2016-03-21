package DAO;


import Entidades.Paciente;
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
public class PacienteDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
        
    public Paciente createPaciente(Paciente paciente) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(paciente);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }finally{
            em.close();
            return paciente;
        }

    }
    
    public Paciente searchByNumDocumento(Long numDocumento) {
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Paciente.findByNumDocumento");
        q.setParameter("numDocumento", numDocumento);
        Paciente paciente = (Paciente) q.getSingleResult();
        em.close();
        return paciente;
        
    }
   
}
