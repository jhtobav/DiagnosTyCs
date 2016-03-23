/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Agenda;
import Entidades.Doctor;
import Entidades.Medico;
import Vista.LoginBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author jhtob
 */
public class AgendaDAO {
    
    EntityManagerFactory emf = LoginBean.getEmf();
    
    public List<Agenda> getListAgenda() {
      
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Agenda.findAll");
        return q.getResultList();
      
    }

    public Agenda updateAgenda(Agenda agenda){
        
        Agenda nuevaAgenda = new Agenda();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevaAgenda = em.merge(em.find(Agenda.class, agenda.getAgendaID()));
            nuevaAgenda.setDisponible(agenda.getDisponible());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaAgenda;
        }
        
    }
    
    public void inicializarAgenda() {
                
        EntityManager em;
        
        Agenda agenda = new Agenda();
        Doctor doctor = new Doctor();
        doctor.setDoctorID(1020779269L);
        Medico medico = new Medico();
        medico.setMedicoID(1020779267L);
        
        for(int i=1; i<=320; i++){
            
            System.out.println(i);
            
            em = emf.createEntityManager();      
            agenda.setAgendaID(i);
            agenda.setDoctordoctorID(doctor);
            agenda.setMedicomedicoID(medico);
            agenda.setDisponible(true);
            
            em.getTransaction().begin();
            try {
                em.persist(agenda);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
            
        }        

    }
    
}
