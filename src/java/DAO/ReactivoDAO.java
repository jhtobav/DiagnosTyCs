/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ReactivoDTO;
import Entidades.Reactivo;
import Vista.LoginBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author jhtob
 */
public class ReactivoDAO {
    
    EntityManagerFactory emf = LoginBean.getEmf();    
        
    public Reactivo updateReactivo(Reactivo reactivo){
        
        Reactivo nuevoReactivo = new Reactivo();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoReactivo = em.merge(em.find(Reactivo.class, reactivo.getReactivoID()));
            nuevoReactivo.setUnidadesExistentes(reactivo.getUnidadesExistentes());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoReactivo;
        }
        
    }
    
    public Reactivo updateReactivoUnidades(ReactivoDTO reactivoDTO){
        
        Reactivo nuevoReactivo = new Reactivo();
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
            nuevoReactivo = em.merge(em.find(Reactivo.class, reactivoDTO.getId()));
            nuevoReactivo.setUnidadesExistentes(nuevoReactivo.getUnidadesExistentes() 
                    + reactivoDTO.getUnidadesNuevas());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoReactivo;
        }
        
    }

    public List<Reactivo> getListReactivo() {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        List<Reactivo> reactivos = null;
        
        try {
            q = em.createNamedQuery("Reactivo.findAll", Reactivo.class);
            reactivos = q.getResultList();
        } catch (Exception e){
        } finally {
            em.close();
            return reactivos;
        }
      
    }
    
    public Reactivo searchByIdReactivo(Long idReactivo) {
        EntityManager em = emf.createEntityManager();
        Reactivo reactivo = null;
        try {
            reactivo = em.find(Reactivo.class
                    , idReactivo);
        } catch (Exception e){
        } finally {
            em.close();
            return reactivo;
        }
      
    }
    
    public void inicializarReactivos() {
                
        EntityManager em;
        
        Reactivo reactivo = new Reactivo();
        
        for(int i=1; i<=299; i++){
            
            System.out.println(i);
            
            em = emf.createEntityManager();      
            reactivo.setNombre("Reactivo " + i);
            reactivo.setUnidadesExistentes(50);
            reactivo.setValor(20);
            
            em.getTransaction().begin();
            try {
                em.persist(reactivo);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
            
        }        

    }
}
