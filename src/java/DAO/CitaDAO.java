/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cita;
import Entidades.Paciente;
import Vista.LoginBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    
    public List<Cita> getListCitas() {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        List<Cita> citas = null;
        try {
            q = em.createNamedQuery("Cita.findAll", Cita.class);
            citas = q.getResultList();
            System.out.println(citas.size());
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
            return citas;
        }
      
    }
    
}
