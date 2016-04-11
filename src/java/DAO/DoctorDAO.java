/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Doctor;
import Entidades.Gasto;
import Vista.LoginBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author jhtob
 */
public class DoctorDAO {
    

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Doctor createDoctor(Doctor doctor) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(doctor);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return doctor;
        }
    }
    
    public Doctor searchByIdDoctor(Long idDoctor) {
        EntityManager em = emf.createEntityManager();
        Doctor doctor = null;
        try {
            doctor = em.find(Doctor.class
                    , idDoctor);
        } catch (Exception e){
        } finally {
            em.close();
            return doctor;
        }
      
    }
    
    public List<Doctor> getDoctoresByEspecialidad(String especialidad){
        
        EntityManager em = emf.createEntityManager();
        Query q;
        List<Doctor> doctores = null;
        try {
            q = em.createNamedQuery("Doctor.findByEspecialidad", Doctor.class);
            q = q.setParameter("especialidad", especialidad);
            q = q.setParameter("estado", "Activo");
            doctores = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return doctores;
        }
    }
    
    
    public List<Doctor> getDoctores(){
        
        EntityManager em = emf.createEntityManager();
        Query q;
        List<Doctor> doctores = null;
        try {
            q = em.createNamedQuery("Doctor.findAll", Doctor.class);
            doctores = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return doctores;
        }
    }
    
}
