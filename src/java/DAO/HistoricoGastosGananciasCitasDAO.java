package DAO;

import DTO.ReporteGananciasDTO;
import Entidades.HistoricoGastosGananciasCitas;
import Vista.LoginBean;
import java.util.Date;
import java.util.List;
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
    
    public ReporteGananciasDTO searchByFechaAndTipoLaboratorio(Date fecha, ReporteGananciasDTO reporteGananciasDTO) {

        EntityManager em = emf.createEntityManager();
        Query q;
        List<Object[]> objetos;

        try {
            q = em.createNamedQuery("HistoricoGastosGananciasCitas.findByTipoAndGanancias");
            q.setParameter("fecha", fecha);
            q.setParameter("tipo", "Laboratorio");
            objetos = (List<Object[]>) q.getResultList();
            for (Object[] objeto : objetos){
                reporteGananciasDTO.setNoExamenesLaboratorio((Long) objeto[0]);
                reporteGananciasDTO.setGastoExamenesLaboratorio((Long) objeto[1]);
                reporteGananciasDTO.setIngresoExamenesLaboratorio((Long) objeto[2]);
                reporteGananciasDTO.setGananciasExamenesLaboratorio((Long) objeto[3]);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return reporteGananciasDTO;
        }

    }
    
    public ReporteGananciasDTO searchByFechaAndTipoImagenes(Date fecha, ReporteGananciasDTO reporteGananciasDTO) {

        EntityManager em = emf.createEntityManager();
        Query q;
        List<Object[]> objetos;

        try {
            q = em.createNamedQuery("HistoricoGastosGananciasCitas.findByTipoAndGanancias");
            q.setParameter("fecha", fecha);
            q.setParameter("tipo", "ImagenesDiagnosticas");
            objetos = (List<Object[]>) q.getResultList();
            for (Object[] objeto : objetos) {
                reporteGananciasDTO.setNoImagenes((Long) objeto[0]);
                reporteGananciasDTO.setGastoImagenes((Long) objeto[1]);
                reporteGananciasDTO.setIngresoImagenes((Long) objeto[2]);
                reporteGananciasDTO.setGananciasImagenes((Long) objeto[3]);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return reporteGananciasDTO;
        }

    }
    
}
