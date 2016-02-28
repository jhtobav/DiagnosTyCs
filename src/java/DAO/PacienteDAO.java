package DAO;


import Entidades.Paciente;
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
public class PacienteDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
        
    public Paciente searchByIdPersona(Long idPersona) {
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Paciente.findByPersonaID");
        q.setParameter("personaID", idPersona);
        Paciente paciente = (Paciente) q.getSingleResult();
        em.close();
        return paciente;
        
    }
    
}
