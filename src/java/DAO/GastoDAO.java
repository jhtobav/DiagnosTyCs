package DAO;


import Entidades.Cita;
import Entidades.Gasto;
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
    
}

