/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ReporteExamenDTO;
import Entidades.Laboratorio;
import Vista.LoginBean;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
    
    public ReporteExamenDTO searchByFechaAndDescripcion(Date fecha, ReporteExamenDTO reporteExamenDTO){
        
        EntityManager em = emf.createEntityManager();
        Query q;
        List<Object[]> objetos;
        
        try {
            q = em.createNamedQuery("Laboratorio.findAVGandCount");
            q.setParameter("fecha", fecha);
            q.setParameter("nombreExamen", reporteExamenDTO.getNombreExamen());
            q.setParameter("descripcionExamen", reporteExamenDTO.getDescripcionExamen());
            objetos = (List<Object[]>) q.getResultList();
            for (Object[] objeto : objetos){
                reporteExamenDTO.setPromedioExamen((Double) objeto[0]);
                reporteExamenDTO.setNumExamenes((Long) objeto[1]);
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            em.close();
            return reporteExamenDTO;
        }
        
    }
}
