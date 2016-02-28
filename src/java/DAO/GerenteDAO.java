package DAO;


import Entidades.Gerente;
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
public class GerenteDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Gerente searchByIdGerente(Long idGerente) {
        EntityManager em = emf.createEntityManager();
        Gerente gerente = null;
        try {
            gerente = em.find(Gerente.class
                    , idGerente);
        } catch (Exception e){
        } finally {
            em.close();
            return gerente;
        }
      
    }
        
}
