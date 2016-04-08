package DAO;


import Entidades.Cita;
import Entidades.Gasto;
import Entidades.Paciente;
import java.util.Date;
import java.util.List;
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
public class GastoDAO {

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("DiagnosTyCsPU");
        
    public Gasto createGasto(Gasto gasto) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(gasto);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return gasto;
        }

    }
    
    public List<Gasto> getListGastoByTipoAndFecha(String tipoGasto, Date fecha) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        List<Gasto> gastos = null;
        
        try {
            q = em.createNamedQuery("Gasto.findByTipoAndFecha", Gasto.class);
            q.setParameter("tipo", tipoGasto);
            q.setParameter("fecha", fecha);
            gastos = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return gastos;
        }
    }
    
    public List<Gasto> getListGastoByFecha(Date fecha) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        List<Gasto> gastos = null;
        
        try {
            q = em.createNamedQuery("Gasto.findByFecha", Gasto.class);
            q.setParameter("fecha", fecha);
            gastos = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return gastos;
        }
    }
    
}

