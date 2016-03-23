package DAO;


import Entidades.Medico;
import Entidades.Precio;
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
public class PrecioDAO {

    EntityManagerFactory emf = LoginBean.getEmf();
    
    public Long searchPrecioExamen(Long idPrecio) {
        EntityManager em = emf.createEntityManager();
        Precio precio = new Precio();
        try {
            precio = em.find(Precio.class
                    , idPrecio);
        } catch (Exception e){
        } finally {
            em.close();
            return precio.getPrecio();
        }
      
    }
    
}
