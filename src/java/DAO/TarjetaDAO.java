package DAO;


import Entidades.Tarjeta;
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
public class TarjetaDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
        
    public Tarjeta createTarjeta(Tarjeta tarjeta) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(tarjeta);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return tarjeta;
        }

    }
    
    public Tarjeta updateTarjeta(Tarjeta tarjeta){
        
        Tarjeta nuevaTarjeta = new Tarjeta();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevaTarjeta = em.merge(em.find(Tarjeta.class, tarjeta));
            
            nuevaTarjeta.setNombreEnTarjeta(tarjeta.getNombreEnTarjeta());
            nuevaTarjeta.setNumeroAno(tarjeta.getNumeroAno());
            nuevaTarjeta.setNumeroMes(tarjeta.getNumeroMes());
            nuevaTarjeta.setCsv(tarjeta.getCsv());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaTarjeta;
        }
        
    }
    
    public Tarjeta searchByIdTarjeta(Long idTarjeta) {
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Tarjeta.findByTarjetaID");
        q.setParameter("tarjetaID", idTarjeta);
        Tarjeta tarjeta = (Tarjeta) q.getSingleResult();
        em.close();
        return tarjeta;
        
    }
    
}
