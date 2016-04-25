package DAO;


import DTO.PacienteDTO;
import Entidades.Cita;
import Entidades.Paciente;
import Vista.LoginBean;
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
    
    public Paciente updatePacientePerfil(PacienteDTO pacienteDTO){
        
        Paciente nuevoPaciente = new Paciente();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoPaciente = em.merge(em.find(Paciente.class, LoginBean.idPersonaLogueada));
            
            nuevoPaciente.setNumDocumento(pacienteDTO.getNumDocPaciente());
            nuevoPaciente.setNombre(pacienteDTO.getNombrePaciente());
            nuevoPaciente.setContrasena(pacienteDTO.getContrasena());
            nuevoPaciente.setCorreo(pacienteDTO.getCorreo());
            nuevoPaciente.setDireccion(pacienteDTO.getDireccion());
            nuevoPaciente.setTelefono(pacienteDTO.getTelefono());
            nuevoPaciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
            nuevoPaciente.setEps(pacienteDTO.getEps());
            nuevoPaciente.setNombreContacto(pacienteDTO.getNombreContacto());
            nuevoPaciente.setTelefonoContacto(pacienteDTO.getTelefonoContacto());
            nuevoPaciente.setNumHijos(pacienteDTO.getNumHijos());
            
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
        Paciente paciente = null;
        try {
            Query q = em.createNamedQuery("Paciente.findByNumDocumento");
            q.setParameter("numDocumento", numDocumento);
            paciente = (Paciente) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return paciente;
        }
        
    }
    
}

