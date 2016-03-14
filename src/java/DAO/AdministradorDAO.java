package DAO;


import Entidades.Administrador;
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
public class AdministradorDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Administrador createAdministrador(Administrador administrador) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(administrador);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return administrador;
        }
    }
    
    public Administrador searchByIdAdministrador(Long idAdministrador) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = null;
        try {
            administrador = em.find(Administrador.class
                    , idAdministrador);
        } catch (Exception e){
        } finally {
            em.close();
            return administrador;
        }
      
    }  
    
}
