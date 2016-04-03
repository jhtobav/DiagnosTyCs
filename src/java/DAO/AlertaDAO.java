package DAO;


import Entidades.Alerta;
import Vista.LoginBean;
import java.util.Date;
import java.util.List;
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
public class AlertaDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Alerta createAlerta(Alerta alerta) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(alerta);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return alerta;
        }
    }
    
    public List<Alerta> getListLastAlerta(Date fecha) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        List<Alerta> alertas = null;
        try {
            q = em.createNamedQuery("Alerta.findByLastFecha", Alerta.class);
            q = q.setParameter("fecha", fecha);
            alertas = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return alertas;
        }
      
    }
    
    public List<Alerta> getListAlerta() {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        List<Alerta> alertas = null;
        
        try {
            q = em.createNamedQuery("Alerta.findAll", Alerta.class);
            alertas = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return alertas;
        }
      
    }
    
}
