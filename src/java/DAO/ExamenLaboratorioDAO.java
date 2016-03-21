/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Laboratorio;
import Vista.LoginBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author jhtob
 */
public class ExamenLaboratorioDAO {
    
    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Laboratorio updateExamenLaboratorio(Laboratorio laboratorio){
        
        Laboratorio nuevoLaboratorio = new Laboratorio();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoLaboratorio = em.merge(em.find(Laboratorio.class, laboratorio.getExamenLaboratorioID()));
            nuevoLaboratorio.setResultado(laboratorio.getResultado());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoLaboratorio;
        }
        
    }
}
