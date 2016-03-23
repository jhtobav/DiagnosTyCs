package DAO;

import Entidades.HistoricoGastosGananciasCitas;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhtob
 */
public class HistoricoGastosGananciasCitasDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public HistoricoGastosGananciasCitas createHistorico(HistoricoGastosGananciasCitas historicoGastosGananciasCitas) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(historicoGastosGananciasCitas);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return historicoGastosGananciasCitas;
        }
    }
    
}
