package DAO;


import Entidades.Cita;
import Entidades.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("DiagnosTyCsPU");
        
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
    
    public Paciente updatePacientePerfil(Paciente paciente){
        
        Paciente nuevoPaciente = new Paciente();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoPaciente = em.merge(em.find(Paciente.class, paciente.getPacienteID()));
            
            nuevoPaciente.setNumDocumento(paciente.getNumDocumento());
            nuevoPaciente.setNombre(paciente.getNombre());
            nuevoPaciente.setContrasena(paciente.getContrasena());
            nuevoPaciente.setCorreo(paciente.getCorreo());
            nuevoPaciente.setDireccion(paciente.getDireccion());
            nuevoPaciente.setTelefono(paciente.getTelefono());
            nuevoPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
            nuevoPaciente.setEps(paciente.getEps());
            nuevoPaciente.setNombreContacto(paciente.getNombreContacto());
            nuevoPaciente.setTelefonoContacto(paciente.getTelefonoContacto());
            nuevoPaciente.setNumHijos(paciente.getNumHijos());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoPaciente;
        }
        
    }
    
    public Paciente updatePacienteCitas(Long pacienteID, Cita cita) {

        Paciente nuevoPaciente = new Paciente();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            nuevoPaciente = em.merge(em.find(Paciente.class, pacienteID));
            nuevoPaciente.getCitaCollection().add(cita);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoPaciente;
        }

    }
    
    public Paciente searchByIdPaciente(Long idPaciente) {
        EntityManager em = emf.createEntityManager();
        Paciente paciente = null;
        try {
            paciente = em.find(Paciente.class
                    , idPaciente);
        } catch (Exception e){
        } finally {
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

