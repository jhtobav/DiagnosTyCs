package DAO;


import DTO.TarjetaDTO;
import Entidades.Paciente;
import Entidades.Persona;
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
    
}
