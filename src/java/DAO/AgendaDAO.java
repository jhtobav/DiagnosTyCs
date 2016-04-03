/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Agenda;
import Entidades.Doctor;
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
    
    public Agenda updateAsignacionAgenda(List<Agenda> agendas){
        
        Agenda nuevaAgenda = new Agenda();
        EntityManager em = emf.createEntityManager();  
        try {
            for(Agenda agenda : agendas){
                em.getTransaction().begin();
                nuevaAgenda = em.merge(em.find(Agenda.class, agenda.getAgendaID()));
                nuevaAgenda.setDisponible(agenda.getDisponible());
                nuevaAgenda.setDoctordoctorID(agenda.getDoctordoctorID());
                System.out.println("------------ " + agenda.getAgendaID());
                System.out.println(agenda.getDisponible());
                System.out.println(agenda.getDoctordoctorID());
                em.getTransaction().commit();
            }
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaAgenda;
        }
        
    }
    
    public List<Agenda> getListAgenda() {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        List<Agenda> agendas = null;
        
        try {
            q = em.createNamedQuery("Agenda.findAll", Agenda.class);
            agendas = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return agendas;
        }
    }
    
    public void inicializarAgenda() {
                
        EntityManager em;
        
        Agenda agenda = new Agenda();
        Doctor doctor = new Doctor();
        doctor.setDoctorID(1020779269L);
        
        for(int i=1; i<=320; i++){
            
            System.out.println(i);
            
            em = emf.createEntityManager();      
            agenda.setAgendaID(i);
            agenda.setDoctordoctorID(doctor);
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
