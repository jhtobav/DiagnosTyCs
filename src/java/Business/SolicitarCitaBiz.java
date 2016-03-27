/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.AgendaDAO;
import DAO.AlertaDAO;
import DAO.CitaDAO;
import DAO.HistoricoGastosGananciasCitasDAO;
import DAO.ImagenDiagnosticaDAO;
import DAO.MedicoDAO;
import DAO.PrecioDAO;
import DAO.ReactivoDAO;
import DTO.ExamenDTO;
import DTO.MedicoDTO;
import Entidades.Agenda;
import Entidades.Alerta;
import Entidades.Cita;
import Entidades.Doctor;
import Entidades.HistoricoGastosGananciasCitas;
import Entidades.ImagenDiagnostica;
import Entidades.Laboratorio;
import Entidades.Medico;
import Entidades.Reactivo;
import Vista.LoginBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jaime
 */
public class SolicitarCitaBiz {

    public List<Agenda> cargarAgenda() {

        AgendaDAO agendaDAO = new AgendaDAO();

        return agendaDAO.getListAgenda();

    }
    
    public List<MedicoDTO> parseMedicoMedicoDTO() {

        MedicoDAO medicoDAO = new MedicoDAO();
        List<Medico> medicos = medicoDAO.getListMedicos();
        List<MedicoDTO> medicosDTO = new ArrayList<>();
        
        for (Medico medico: medicos){
            
            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setIdMedico(medico.getMedicoID());
            medicoDTO.setNombreMedico(medico.getPersonapersonaID().getNombre());
            medicosDTO.add(medicoDTO);
                    
        }
        
        return medicosDTO;

    }
    
    public String solicitarCitaExamenLaboratorio(ExamenDTO examenDTO, List<ExamenDTO> examenesDTO, Agenda agenda, Date fecha, Long idMedico) {

        CitaDAO citaDAO = new CitaDAO();
        
        Long preciosReactivos = 0l;
        Long precioExamen = buscarPrecioExamen(1l);
        Long valorCita = 0l; 
        
        List<Laboratorio> laboratorios = new ArrayList<>();
        
        for(ExamenDTO examen: examenesDTO){
            
            if(examen.getNombre().equals(examenDTO.getNombre())){
                
                Reactivo reactivo = buscarReactivo(examen.getIdReactivo());

                valorCita = valorCita + precioExamen;
                
                System.out.println("Paso 1");
                // Crear Laboratorio
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setDescripcion(examen.getDescripcion());
                laboratorio.setNombre(examen.getNombre());
                laboratorio.setReactivoreactivoID(reactivo);
                laboratorio.setResultado("R:");
                
                System.out.println("Paso 2");
                // Asociar Laboratorio con Cita
                laboratorios.add(laboratorio);

                System.out.println("Paso 3");
                // Actualizar cantidad de reactivos
                reactivo = actualizarUnidadesReactivo(reactivo);

                System.out.println("Paso 4");
                // Crear alerta de Reactivo
                crearAlerta(reactivo.getUnidadesExistentes(), reactivo.getNombre(), laboratorio.getDescripcion());
                
                System.out.println("Paso 5");
                // Crear Historico
                preciosReactivos = preciosReactivos + reactivo.getValor();
                
            }                
            
        }
        
        System.out.println("Paso 6");
        // Crear Cita
        ImagenDiagnostica imagen = new ImagenDiagnostica();
        Cita cita = crearCita(agenda, fecha, precioExamen, imagen, idMedico);
        cita.setLaboratorioCollection(laboratorios);
        cita.setValor(valorCita);
        citaDAO.createCita(cita);
        
        System.out.println("Paso 7");
        // Actualizar disponibilidad de Agenda
        actualizarDisponibilidadAgenda(agenda);
        
        System.out.println("Paso 8");
        // Crear Historico
        crearHistoricoGastosGananciasCitas(fecha, examenDTO.getNombre(), "Laboratorio", preciosReactivos, valorCita);
        
        return "exito";

    }

    public String solicitarCitaImagen(ExamenDTO examenDTO, Agenda agenda, Date fecha, Long idMedico) {

        CitaDAO citaDAO = new CitaDAO();
        ImagenDiagnosticaDAO imagenDiagnosticaDAO = new ImagenDiagnosticaDAO();

        Long precioExamen = buscarPrecioExamen(2l);
        Reactivo reactivo = buscarReactivo(examenDTO.getIdReactivo());
        

        System.out.println("Paso 1");
        // Crear Imagen Diagnóstica
        ImagenDiagnostica imagen = new ImagenDiagnostica();
        imagen.setDescripcion(examenDTO.getDescripcion());
        imagen.setNombre(examenDTO.getNombre());
        imagen.setReactivoreactivoID(reactivo);
        imagen.setRutaImagen("F:/");
        imagenDiagnosticaDAO.createImagen(imagen);
        
        System.out.println("Paso 2");
        // Crear Cita
        Cita cita = crearCita(agenda, fecha, precioExamen, imagen, idMedico);
        citaDAO.createCita(cita);

        System.out.println("Paso 3");
        // Actualizar disponibilidad de Agenda
        actualizarDisponibilidadAgenda(agenda);

        System.out.println("Paso 4");
        // Actualizar cantidad de reactivos
        reactivo = actualizarUnidadesReactivo(reactivo);

        System.out.println("Paso 5");
        // Crear alerta de Reactivo
        crearAlerta(reactivo.getUnidadesExistentes(), reactivo.getNombre(), imagen.getDescripcion());

        System.out.println("Paso 6");
        // Crear Historico
        crearHistoricoGastosGananciasCitas(fecha, imagen.getDescripcion(), "ImagenesDiagnosticas", reactivo.getValor(), precioExamen);

        return "exito";

    }

    public Cita crearCita(Agenda agenda, Date fecha, Long precioExamen, ImagenDiagnostica imagenDiagnostica, Long idMedico) {

        Doctor doctor = agenda.getDoctordoctorID();
        Medico medico = new MedicoDAO().searchByIdMedico(idMedico);
        
        List<Laboratorio> laboratorios = new ArrayList<>();

        Cita cita = new Cita();
        cita.setDoctordoctorID(doctor);
        cita.setMedicomedicoID(medico);
        cita.setLaboratorioCollection(laboratorios);
        cita.setPacientepacienteID(LoginBean.getPaciente());
        cita.setImagenDiagnosticaimagenDiagnosticaID(imagenDiagnostica);
        cita.setFecha(fecha);
        cita.setValor(precioExamen);

        return cita;

    }

    public void crearAlerta(long unidadesExistentes, String nombreReactivo, String nombreExamen) {

        AlertaDAO alertaDAO = new AlertaDAO();

        Alerta alerta = new Alerta();
        if (unidadesExistentes < 10l) {
            alerta.setNombreReactivo(nombreReactivo);
            alerta.setDescripcion(nombreExamen);
            alerta.setFecha(new Date());
            alerta.setCantidadFaltante((int) unidadesExistentes);
            alertaDAO.createAlerta(alerta);
        }
    }
    
    public void crearHistoricoGastosGananciasCitas(Date fecha, String nombreImagen, String tipo, Long valorReactivo, Long precioExamen){

        HistoricoGastosGananciasCitasDAO historicoGastosGananciasCitasDAO = new HistoricoGastosGananciasCitasDAO();
        
        HistoricoGastosGananciasCitas historicoGastosGananciasCitas = new HistoricoGastosGananciasCitas();
        historicoGastosGananciasCitas.setFecha(fecha);
        historicoGastosGananciasCitas.setNombreExamen(nombreImagen);
        historicoGastosGananciasCitas.setTipo(tipo);
        historicoGastosGananciasCitas.setPrecioReactivo(valorReactivo);
        historicoGastosGananciasCitas.setValorExamen(precioExamen);
        historicoGastosGananciasCitas.setGanancia(precioExamen - valorReactivo);
        
        historicoGastosGananciasCitasDAO.createHistorico(historicoGastosGananciasCitas);
    }

    public void actualizarDisponibilidadAgenda(Agenda agenda) {

        AgendaDAO agendaDAO = new AgendaDAO();

        agenda.setDisponible(false);
        agendaDAO.updateAgenda(agenda);

    }

    public Long buscarPrecioExamen(Long idExamen) {

        PrecioDAO precioDAO = new PrecioDAO();

        return precioDAO.searchPrecioExamen(idExamen);

    }

    public Reactivo buscarReactivo(Long idReactivo) {

        ReactivoDAO reactivoDAO = new ReactivoDAO();

        return reactivoDAO.searchByIdReactivo(idReactivo);

    }
    
    public Reactivo actualizarUnidadesReactivo(Reactivo reactivo){

        ReactivoDAO reactivoDAO = new ReactivoDAO();        
        
        reactivo.setUnidadesExistentes(reactivo.getUnidadesExistentes() - 1);

        return reactivoDAO.updateReactivo(reactivo);
        
    }

    public List<ExamenDTO> cargarExamenesLaboratorio() {

        List<ExamenDTO> examenes = new ArrayList<>();
        ExamenDTO examenDTO;

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Globulos Rojos");
        examenDTO.setIdReactivo(1l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Globulos Blancos");
        examenDTO.setIdReactivo(2l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Hemoglobina");
        examenDTO.setIdReactivo(3l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Hematocrito");
        examenDTO.setIdReactivo(4l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Volumen Corpuscular medio");
        examenDTO.setIdReactivo(5l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Hemoglobina Corpuscular media");
        examenDTO.setIdReactivo(6l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Concentración de Hemoglobina Corpuscular");
        examenDTO.setIdReactivo(7l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Ancho de Distribución de Globulos Rojos");
        examenDTO.setIdReactivo(8l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Plaquetas");
        examenDTO.setIdReactivo(9l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Neutrofilos %");
        examenDTO.setIdReactivo(10l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Linfocitos % ");
        examenDTO.setIdReactivo(11l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Monofitos %");
        examenDTO.setIdReactivo(12l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Eocinofitos %");
        examenDTO.setIdReactivo(13l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Basofilos");
        examenDTO.setIdReactivo(14l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cuadro Hematico");
        examenDTO.setDescripcion("Volumen Plaquetario medio");
        examenDTO.setIdReactivo(15l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de Sangre Periferico");
        examenDTO.setDescripcion("Globulos Rojos");
        examenDTO.setIdReactivo(16l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de Sangre Periferico");
        examenDTO.setDescripcion("Globulos Blancos");
        examenDTO.setIdReactivo(17l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de Sangre Periferico");
        examenDTO.setDescripcion("Plaquetas");
        examenDTO.setIdReactivo(18l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hipidico");
        examenDTO.setDescripcion("Colesterol");
        examenDTO.setIdReactivo(19l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hipidico");
        examenDTO.setDescripcion("Trigliceridos");
        examenDTO.setIdReactivo(20l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hipidico");
        examenDTO.setDescripcion("HDL");
        examenDTO.setIdReactivo(21l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hipidico");
        examenDTO.setDescripcion("LDL");
        examenDTO.setIdReactivo(22l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hipidico");
        examenDTO.setDescripcion("VLDL");
        examenDTO.setIdReactivo(23l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("Bilirrubina directa");
        examenDTO.setIdReactivo(24l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("Bilirrubina total");
        examenDTO.setIdReactivo(25l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("TGO");
        examenDTO.setIdReactivo(26l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("TGP");
        examenDTO.setIdReactivo(27l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("Amilasa");
        examenDTO.setIdReactivo(28l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil hepatico");
        examenDTO.setDescripcion("Lipasa");
        examenDTO.setIdReactivo(29l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil Renal");
        examenDTO.setDescripcion("BUN");
        examenDTO.setIdReactivo(30l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil Renal");
        examenDTO.setDescripcion("Creatinina");
        examenDTO.setIdReactivo(31l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil Renal");
        examenDTO.setDescripcion("Proteinuria");
        examenDTO.setIdReactivo(32l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil Renal");
        examenDTO.setDescripcion("Creatinina 24H");
        examenDTO.setIdReactivo(33l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Perfil Renal");
        examenDTO.setDescripcion("Proteinuria 24H");
        examenDTO.setIdReactivo(34l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprologico");
        examenDTO.setDescripcion("PH");
        examenDTO.setIdReactivo(35l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprologico");
        examenDTO.setDescripcion("Color");
        examenDTO.setIdReactivo(36l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprologico");
        examenDTO.setDescripcion("Consistencia");
        examenDTO.setIdReactivo(37l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprologico");
        examenDTO.setDescripcion("Sangre oculta");
        examenDTO.setIdReactivo(38l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprologico");
        examenDTO.setDescripcion("Azucares reductores");
        examenDTO.setIdReactivo(39l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de flujo vaginal");
        examenDTO.setDescripcion("Fresco");
        examenDTO.setIdReactivo(40l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de flujo vaginal");
        examenDTO.setDescripcion("Gram");
        examenDTO.setIdReactivo(41l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Color");
        examenDTO.setIdReactivo(42l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Turbidez");
        examenDTO.setIdReactivo(43l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("PH");
        examenDTO.setIdReactivo(44l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Densidad");
        examenDTO.setIdReactivo(45l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Nitritos");
        examenDTO.setIdReactivo(46l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Proteinas");
        examenDTO.setIdReactivo(47l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Cuerpos cetonicos");
        examenDTO.setIdReactivo(48l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Bilirrubinas");
        examenDTO.setIdReactivo(49l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Urobilinogeno");
        examenDTO.setIdReactivo(50l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Sangre");
        examenDTO.setIdReactivo(51l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Leucocitos en orina");
        examenDTO.setIdReactivo(52l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Fisico-Quimico");
        examenDTO.setDescripcion("Hematies en orina");
        examenDTO.setIdReactivo(53l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Leucocitos en sedimento por campo");
        examenDTO.setIdReactivo(54l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Celulas");
        examenDTO.setIdReactivo(55l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Bacterias");
        examenDTO.setIdReactivo(56l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Hematies en sedimento");
        examenDTO.setIdReactivo(57l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Cilindros");
        examenDTO.setIdReactivo(58l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Orinas Sedimento");
        examenDTO.setDescripcion("Cristales");
        examenDTO.setIdReactivo(59l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Reticulocitos");
        examenDTO.setDescripcion("Reticulocitos");
        examenDTO.setIdReactivo(60l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Velocidad de Sedimientación Globular");
        examenDTO.setDescripcion("Velocidad de Sedimientación Globular");
        examenDTO.setIdReactivo(61l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Eocinofilos en moco nasal");
        examenDTO.setDescripcion("Eocinofilos en moco nasal");
        examenDTO.setIdReactivo(62l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Gota Gruesa");
        examenDTO.setDescripcion("Gota Gruesa");
        examenDTO.setIdReactivo(63l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prueba rapida para malaria");
        examenDTO.setDescripcion("Prueba rapida para malaria");
        examenDTO.setIdReactivo(64l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prueba rapida para dengue");
        examenDTO.setDescripcion("Prueba rapida para dengue");
        examenDTO.setIdReactivo(65l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Acido urico");
        examenDTO.setDescripcion("Acido urico");
        examenDTO.setIdReactivo(66l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Microalbuminuria");
        examenDTO.setDescripcion("Microalbuminuria");
        examenDTO.setIdReactivo(67l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hemoglobina glicosilada");
        examenDTO.setDescripcion("Hemoglobina glicosilada");
        examenDTO.setIdReactivo(68l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("CPK");
        examenDTO.setDescripcion("CPK");
        examenDTO.setIdReactivo(69l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("CPKMB");
        examenDTO.setDescripcion("CPKMB");
        examenDTO.setIdReactivo(70l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Colinesterasa");
        examenDTO.setDescripcion("Colinesterasa");
        examenDTO.setIdReactivo(71l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Sangre oculta en heces");
        examenDTO.setDescripcion("Sangre oculta en heces");
        examenDTO.setIdReactivo(72l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis uretral");
        examenDTO.setDescripcion("Frotis uretral");
        examenDTO.setIdReactivo(73l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis de Leishmania");
        examenDTO.setDescripcion("Frotis de Leishmania");
        examenDTO.setIdReactivo(74l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Urocultivo");
        examenDTO.setDescripcion("Urocultivo");
        examenDTO.setIdReactivo(75l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hemocultivo");
        examenDTO.setDescripcion("Hemocultivo");
        examenDTO.setIdReactivo(76l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cultivo para germenes comunes");
        examenDTO.setDescripcion("Cultivo para germenes comunes");
        examenDTO.setIdReactivo(77l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antibiograma");
        examenDTO.setDescripcion("Antibiograma");
        examenDTO.setIdReactivo(78l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Gram de orina");
        examenDTO.setDescripcion("Gram de orina");
        examenDTO.setIdReactivo(79l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cultivo de anaerobios");
        examenDTO.setDescripcion("Cultivo de anaerobios");
        examenDTO.setIdReactivo(80l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Coprocultivo");
        examenDTO.setDescripcion("Coprocultivo");
        examenDTO.setIdReactivo(81l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("KOH");
        examenDTO.setDescripcion("KOH");
        examenDTO.setIdReactivo(82l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Frotis faringeo");
        examenDTO.setDescripcion("Frotis faringeo");
        examenDTO.setIdReactivo(83l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cultivo de secreciones");
        examenDTO.setDescripcion("Cultivo de secreciones");
        examenDTO.setIdReactivo(84l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cultivo de liquido cefaloraquideo");
        examenDTO.setDescripcion("Cultivo de liquido cefaloraquideo");
        examenDTO.setIdReactivo(85l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Serologia");
        examenDTO.setDescripcion("Serologia");
        examenDTO.setIdReactivo(86l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hemoclasificacion");
        examenDTO.setDescripcion("Hemoclasificacion");
        examenDTO.setIdReactivo(87l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("HBSAG");
        examenDTO.setDescripcion("HBSAG");
        examenDTO.setIdReactivo(88l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prueba rapida VIH");
        examenDTO.setDescripcion("Prueba rapida VIH");
        examenDTO.setIdReactivo(89l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Factor Rematoideo");
        examenDTO.setDescripcion("Factor Rematoideo");
        examenDTO.setIdReactivo(90l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Proteina Creativa");
        examenDTO.setDescripcion("Proteina Creativa");
        examenDTO.setIdReactivo(91l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antiestreptolisina");
        examenDTO.setDescripcion("Antiestreptolisina");
        examenDTO.setIdReactivo(92l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prueba de embarazo");
        examenDTO.setDescripcion("Prueba de embarazo");
        examenDTO.setIdReactivo(93l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prueba rapida Hepatitis C");
        examenDTO.setDescripcion("Prueba rapida Hepatitis C");
        examenDTO.setIdReactivo(94l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antigenos febriles");
        examenDTO.setDescripcion("Antigenos febriles");
        examenDTO.setIdReactivo(95l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Protrombina Time");
        examenDTO.setDescripcion("Protrombina Time");
        examenDTO.setIdReactivo(96l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tiempo parcial de tromboplastina");
        examenDTO.setDescripcion("Tiempo parcial de tromboplastina");
        examenDTO.setIdReactivo(97l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Indice PT");
        examenDTO.setDescripcion("Indice PT");
        examenDTO.setIdReactivo(98l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Acido Valproico");
        examenDTO.setDescripcion("Acido Valproico");
        examenDTO.setIdReactivo(99l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Inmunoglobulina IgA");
        examenDTO.setDescripcion("Inmunoglobulina IgA");
        examenDTO.setIdReactivo(100l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Factor reumatoideo de altaprecision");
        examenDTO.setDescripcion("Factor reumatoideo de altaprecision");
        examenDTO.setIdReactivo(101l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Proteina Creativa de alta precision");
        examenDTO.setDescripcion("Proteina Creativa de alta precision");
        examenDTO.setIdReactivo(102l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hierro total");
        examenDTO.setDescripcion("Hierro total");
        examenDTO.setIdReactivo(103l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Gama glutamil transferasa");
        examenDTO.setDescripcion("Gama glutamil transferasa");
        examenDTO.setIdReactivo(104l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Inmunoglobulina IgG");
        examenDTO.setDescripcion("Inmunoglobulina IgG");
        examenDTO.setIdReactivo(105l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Inmunoglobulina IgM");
        examenDTO.setDescripcion("Inmunoglobulina IgM");
        examenDTO.setIdReactivo(106l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Deshidrogenasa lactica");
        examenDTO.setDescripcion("Deshidrogenasa lactica");
        examenDTO.setIdReactivo(107l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Fosforo");
        examenDTO.setDescripcion("Fosforo");
        examenDTO.setIdReactivo(108l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Magnesio en suero");
        examenDTO.setDescripcion("Magnesio en suero");
        examenDTO.setIdReactivo(109l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("TSH");
        examenDTO.setDescripcion("TSH");
        examenDTO.setIdReactivo(110l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hormona foliculo estimulante");
        examenDTO.setDescripcion("Hormona foliculo estimulante");
        examenDTO.setIdReactivo(111l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hormona luteinizante basal");
        examenDTO.setDescripcion("Hormona luteinizante basal");
        examenDTO.setIdReactivo(112l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("PSA total");
        examenDTO.setDescripcion("PSA total");
        examenDTO.setIdReactivo(113l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Gonadotropina coorionica humana");
        examenDTO.setDescripcion("Gonadotropina coorionica humana");
        examenDTO.setIdReactivo(114l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Toxoplasma IgG");
        examenDTO.setDescripcion("Toxoplasma IgG");
        examenDTO.setIdReactivo(115l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Toxoplasma IgE");
        examenDTO.setDescripcion("Toxoplasma IgE");
        examenDTO.setIdReactivo(116l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Inmunoglobulina IgE");
        examenDTO.setDescripcion("Inmunoglobulina IgE");
        examenDTO.setIdReactivo(117l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Estradiol");
        examenDTO.setDescripcion("Estradiol");
        examenDTO.setIdReactivo(118l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prolactina");
        examenDTO.setDescripcion("Prolactina");
        examenDTO.setIdReactivo(119l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prolactina 1H");
        examenDTO.setDescripcion("Prolactina 1H");
        examenDTO.setIdReactivo(120l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Prolactina 2H");
        examenDTO.setDescripcion("Prolactina 2H");
        examenDTO.setIdReactivo(121l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Pool de prolactina");
        examenDTO.setDescripcion("Pool de prolactina");
        examenDTO.setIdReactivo(122l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("PSA total cualitativo");
        examenDTO.setDescripcion("PSA total cualitativo");
        examenDTO.setIdReactivo(123l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Insulina");
        examenDTO.setDescripcion("Insulina");
        examenDTO.setIdReactivo(124l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("HIV Cuarta generacion");
        examenDTO.setDescripcion("HIV Cuarta generacion");
        examenDTO.setIdReactivo(125l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("T3 total");
        examenDTO.setDescripcion("T3 total");
        examenDTO.setIdReactivo(126l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("T4 total");
        examenDTO.setDescripcion("T4 total");
        examenDTO.setIdReactivo(127l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tiroxina libre");
        examenDTO.setDescripcion("Tiroxina libre");
        examenDTO.setIdReactivo(128l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Triyodotronina libre");
        examenDTO.setDescripcion("Triyodotronina libre");
        examenDTO.setIdReactivo(129l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("PSA libre");
        examenDTO.setDescripcion("PSA libre");
        examenDTO.setIdReactivo(130l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Anti TPO");
        examenDTO.setDescripcion("Anti TPO");
        examenDTO.setIdReactivo(131l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("HIV Combi PT");
        examenDTO.setDescripcion("HIV Combi PT");
        examenDTO.setIdReactivo(132l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rubeola IgG");
        examenDTO.setDescripcion("Rubeola IgG");
        examenDTO.setIdReactivo(133l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Vitamina D");
        examenDTO.setDescripcion("Vitamina D");
        examenDTO.setIdReactivo(134l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Vitamina B12");
        examenDTO.setDescripcion("Vitamina B12");
        examenDTO.setIdReactivo(135l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antig especifico de prostata frac libre");
        examenDTO.setDescripcion("Antig especifico de prostata frac libre");
        examenDTO.setIdReactivo(136l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Testosterona libre");
        examenDTO.setDescripcion("Testosterona libre");
        examenDTO.setIdReactivo(137l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rubeola IgM");
        examenDTO.setDescripcion("Rubeola IgM");
        examenDTO.setIdReactivo(138l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("PTH Paratormona");
        examenDTO.setDescripcion("PTH Paratormona");
        examenDTO.setIdReactivo(139l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Progesterona");
        examenDTO.setDescripcion("Progesterona");
        examenDTO.setIdReactivo(140l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Acido folico");
        examenDTO.setDescripcion("Acido folico");
        examenDTO.setIdReactivo(141l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Alfafetoproteinas");
        examenDTO.setDescripcion("Alfafetoproteinas");
        examenDTO.setIdReactivo(142l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antigeno CA125");
        examenDTO.setDescripcion("Antigeno CA125");
        examenDTO.setIdReactivo(143l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Antigeno carcinoembrionario");
        examenDTO.setDescripcion("Antigeno carcinoembrionario");
        examenDTO.setIdReactivo(144l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Citomegalovirus IgG");
        examenDTO.setDescripcion("Citomegalovirus IgG");
        examenDTO.setIdReactivo(145l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Citomegalovirus IgM");
        examenDTO.setDescripcion("Citomegalovirus IgM");
        examenDTO.setIdReactivo(146l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Hormona de crecimiento");
        examenDTO.setDescripcion("Hormona de crecimiento");
        examenDTO.setIdReactivo(147l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ferritina");
        examenDTO.setDescripcion("Ferritina");
        examenDTO.setIdReactivo(148l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cortisol AM");
        examenDTO.setDescripcion("Cortisol AM");
        examenDTO.setIdReactivo(149l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cortisol PM");
        examenDTO.setDescripcion("Cortisol PM");
        examenDTO.setIdReactivo(150l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cortisol en orina");
        examenDTO.setDescripcion("Cortisol en orina");
        examenDTO.setIdReactivo(151l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Toxoplasma IgG aviles");
        examenDTO.setDescripcion("Toxoplasma IgG aviles");
        examenDTO.setIdReactivo(152l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Sodio en suero");
        examenDTO.setDescripcion("Sodio en suero");
        examenDTO.setIdReactivo(153l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Sodio en orina");
        examenDTO.setDescripcion("Sodio en orina");
        examenDTO.setIdReactivo(154l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Potasio en suero");
        examenDTO.setDescripcion("Potasio en suero");
        examenDTO.setIdReactivo(155l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Potasio en orina");
        examenDTO.setDescripcion("Potasio en orina");
        examenDTO.setIdReactivo(156l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cloro en suero");
        examenDTO.setDescripcion("Cloro en suero");
        examenDTO.setIdReactivo(157l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Cloro en orina");
        examenDTO.setDescripcion("Cloro en orina");
        examenDTO.setIdReactivo(158l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Calcio en suero");
        examenDTO.setDescripcion("Calcio en suero");
        examenDTO.setIdReactivo(159l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Calcio en orina");
        examenDTO.setDescripcion("Calcio en orina");
        examenDTO.setIdReactivo(160l);
        examenes.add(examenDTO);

        return examenes;

    }

    public List<ExamenDTO> cargarImagenes() {

        List<ExamenDTO> examenes = new ArrayList<>();
        ExamenDTO examenDTO = new ExamenDTO();

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Angiografía aórtica");
        examenDTO.setIdReactivo(161l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Angiografía mesentérica ");
        examenDTO.setIdReactivo(162l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Angiografía por catéter");
        examenDTO.setIdReactivo(163l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Angiografía pulmonar ");
        examenDTO.setIdReactivo(164l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Arteriografía renal ");
        examenDTO.setIdReactivo(165l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Artrografía directa ");
        examenDTO.setIdReactivo(166l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Cistografía retrógrada ");
        examenDTO.setIdReactivo(167l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Cistouretrograma miccional ");
        examenDTO.setIdReactivo(168l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Colangiografía transhepática percutánea ");
        examenDTO.setIdReactivo(169l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Densitometría ósea");
        examenDTO.setIdReactivo(170l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Discograma");
        examenDTO.setIdReactivo(171l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Enema opaco ");
        examenDTO.setIdReactivo(172l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Enteroclisis ");
        examenDTO.setIdReactivo(173l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Linfangiograma ");
        examenDTO.setIdReactivo(174l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Mielografía");
        examenDTO.setIdReactivo(175l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Pielograma intravenoso (PIV)");
        examenDTO.setIdReactivo(176l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía abdominal ");
        examenDTO.setIdReactivo(177l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de cráneo ");
        examenDTO.setIdReactivo(178l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de cuello ");
        examenDTO.setIdReactivo(179l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de hueso ");
        examenDTO.setIdReactivo(180l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de la columna lumbosacra ");
        examenDTO.setIdReactivo(181l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de la columna torácica ");
        examenDTO.setIdReactivo(182l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de la pelvis ");
        examenDTO.setIdReactivo(183l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de las manos ");
        examenDTO.setIdReactivo(184l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de los senos paranasales ");
        examenDTO.setIdReactivo(185l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de una articulación ");
        examenDTO.setIdReactivo(186l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía de una extremidad ");
        examenDTO.setIdReactivo(187l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía del esqueleto ");
        examenDTO.setIdReactivo(188l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía del tracto gastrointestinal (GI) inferior ");
        examenDTO.setIdReactivo(189l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía dental ");
        examenDTO.setIdReactivo(190l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografía torácica ");
        examenDTO.setIdReactivo(191l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografías dentales ");
        examenDTO.setIdReactivo(192l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Radiografías dentales (rayos X)");
        examenDTO.setIdReactivo(193l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Rayos X del tórax (radiografía de tórax)");
        examenDTO.setIdReactivo(194l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Rayos X del tracto gastrointestinal (GI) superior (radiografía)");
        examenDTO.setIdReactivo(195l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Rayos X óseo (radiografía)");
        examenDTO.setIdReactivo(196l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Rayos X panorámicos");
        examenDTO.setIdReactivo(197l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Sialograma ");
        examenDTO.setIdReactivo(198l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Tránsito esofagogastroduodenal");
        examenDTO.setIdReactivo(199l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Tránsito gastrointestinal inferior");
        examenDTO.setIdReactivo(200l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Venografía ");
        examenDTO.setIdReactivo(201l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Venografía ");
        examenDTO.setIdReactivo(202l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Rayos X");
        examenDTO.setDescripcion("Venografía renal ");
        examenDTO.setIdReactivo(203l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Angiografía coronaria por TC (ACTC)");
        examenDTO.setIdReactivo(204l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Angiotomografía computarizada");
        examenDTO.setIdReactivo(205l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Colonografía por TAC ");
        examenDTO.setIdReactivo(206l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Enterografía por TAC ");
        examenDTO.setIdReactivo(207l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Exploración de la cabeza por TAC ");
        examenDTO.setIdReactivo(208l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Exploración de la columna vertebral por TAC");
        examenDTO.setIdReactivo(209l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Exploración de senos (paranasales) por TAC  ");
        examenDTO.setIdReactivo(210l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Exploración del cuerpo por TAC  ");
        examenDTO.setIdReactivo(211l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Exploración TAC de tórax");
        examenDTO.setIdReactivo(212l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Gammagrafía renal ");
        examenDTO.setIdReactivo(213l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Perfusión por TAC de la cabeza");
        examenDTO.setIdReactivo(214l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("TAC: Abdomen y pelvis  ");
        examenDTO.setIdReactivo(215l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("TAC cardíaca para la cuantificación del calcio coronario");
        examenDTO.setIdReactivo(216l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("TC torácica ");
        examenDTO.setIdReactivo(217l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada cervical ");
        examenDTO.setIdReactivo(218l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la columna dorsal ");
        examenDTO.setIdReactivo(219l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la columna lumbar ");
        examenDTO.setIdReactivo(220l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la columna lumbosacra ");
        examenDTO.setIdReactivo(221l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la órbita ");
        examenDTO.setIdReactivo(222l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la pelvis ");
        examenDTO.setIdReactivo(223l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la pierna ");
        examenDTO.setIdReactivo(224l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de la rodilla ");
        examenDTO.setIdReactivo(225l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada de los senos paranasales ");
        examenDTO.setIdReactivo(226l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada del abdomen ");
        examenDTO.setIdReactivo(227l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada del brazo ");
        examenDTO.setIdReactivo(228l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada del corazón ");
        examenDTO.setIdReactivo(229l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada del cráneo ");
        examenDTO.setIdReactivo(230l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada del hombro ");
        examenDTO.setIdReactivo(231l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Tomografía computarizada (TC) y exploraciones para cáncer");
        examenDTO.setIdReactivo(232l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Tomografia Computarizada");
        examenDTO.setDescripcion("Urografía  ");
        examenDTO.setIdReactivo(233l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Cisternografía con radionúclidos ");
        examenDTO.setIdReactivo(234l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Cistografía con radionúclidos ");
        examenDTO.setIdReactivo(235l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Estudios de medicina nuclear");
        examenDTO.setIdReactivo(236l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Exploración por tomografía por emisión de positrones ");
        examenDTO.setIdReactivo(237l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía con galio (Ga) ");
        examenDTO.setIdReactivo(238l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía con MIBG ");
        examenDTO.setIdReactivo(239l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía de glóbulos blancos ");
        examenDTO.setIdReactivo(240l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía de glóbulos rojos ");
        examenDTO.setIdReactivo(241l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía de la tiroides ");
        examenDTO.setIdReactivo(242l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía de la vesícula biliar con radionúclidos ");
        examenDTO.setIdReactivo(243l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía de perfusión renal ");
        examenDTO.setIdReactivo(244l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía del hígado ");
        examenDTO.setIdReactivo(245l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía pulmonar con galio ");
        examenDTO.setIdReactivo(246l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía renal");
        examenDTO.setIdReactivo(247l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Gammagrafía y absorción tiroideas");
        examenDTO.setIdReactivo(248l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Linfogammagrafía ");
        examenDTO.setIdReactivo(249l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Medicina nuclear cardíaca ");
        examenDTO.setIdReactivo(250l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Prueba de esfuerzo nuclear");
        examenDTO.setIdReactivo(251l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Tomografía de las mamas por emisión de positrones (TEP) ");
        examenDTO.setIdReactivo(252l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Tomografía por emisión de positrones (TEP) ");
        examenDTO.setIdReactivo(253l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Tomografía por emisión de positrones (TEP) del corazón ");
        examenDTO.setIdReactivo(254l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Escanografia nuclear");
        examenDTO.setDescripcion("Ventriculografía nuclear ");
        examenDTO.setIdReactivo(255l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Angiografía de resonancia magnética ");
        examenDTO.setIdReactivo(256l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Angiografía por resonancia magnética ");
        examenDTO.setIdReactivo(257l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Biopsia de mama guiada por RMN ");
        examenDTO.setIdReactivo(258l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Colangiopancreatografía por resonancia magnética (CPRM)");
        examenDTO.setIdReactivo(259l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Enterografía por RMN ");
        examenDTO.setIdReactivo(260l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética cardíaca (RM cardíaca)");
        examenDTO.setIdReactivo(261l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética: Cerebro");
        examenDTO.setIdReactivo(262l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética cervical ");
        examenDTO.setIdReactivo(263l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética de la cabeza ");
        examenDTO.setIdReactivo(264l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética del abdomen ");
        examenDTO.setIdReactivo(265l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética del corazón ");
        examenDTO.setIdReactivo(266l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética nuclear (RMN) durante el embarazo");
        examenDTO.setIdReactivo(267l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Resonancia magnética y el lumbago ");
        examenDTO.setIdReactivo(268l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de cabeza");
        examenDTO.setIdReactivo(269l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de columna ");
        examenDTO.setIdReactivo(270l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de cuerpo (tórax, abdomen, pelvis)");
        examenDTO.setIdReactivo(271l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de la próstata ");
        examenDTO.setIdReactivo(272l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de la rodilla ");
        examenDTO.setIdReactivo(273l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de mama");
        examenDTO.setIdReactivo(274l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN de tórax");
        examenDTO.setIdReactivo(275l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN del hombro ");
        examenDTO.setIdReactivo(276l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN del sistema musculoesquelético ");
        examenDTO.setIdReactivo(277l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("RMN funcional (RMNf): Cerebro");
        examenDTO.setIdReactivo(278l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Resonancia magnética");
        examenDTO.setDescripcion("Urografía");
        examenDTO.setIdReactivo(279l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonografía endoscópica (EUS)");
        examenDTO.setIdReactivo(280l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecocardiografía  ");
        examenDTO.setIdReactivo(281l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecocardiografía de esfuerzo  ");
        examenDTO.setIdReactivo(282l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecocardiografía transesofágica");
        examenDTO.setIdReactivo(283l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecografía abdominal  ");
        examenDTO.setIdReactivo(284l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecografía de la tiroides  ");
        examenDTO.setIdReactivo(285l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecografía Doppler de un brazo o de una pierna  ");
        examenDTO.setIdReactivo(286l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecografía dúplex  ");
        examenDTO.setIdReactivo(287l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ecografía ocular y orbitaria  ");
        examenDTO.setIdReactivo(288l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Electrocardiograma  ");
        examenDTO.setIdReactivo(289l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Imágenes por ultrasonido de la arteria carótida");
        examenDTO.setIdReactivo(290l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido abdominal");
        examenDTO.setIdReactivo(291l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido craneal/ultrasonido de la cabeza");
        examenDTO.setIdReactivo(292l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido de cadera ");
        examenDTO.setIdReactivo(293l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido de la tiroides");
        examenDTO.setIdReactivo(294l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido intravascular");
        examenDTO.setIdReactivo(295l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido musculoesquelético");
        examenDTO.setIdReactivo(296l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido pélvico");
        examenDTO.setIdReactivo(297l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido vascular");
        examenDTO.setIdReactivo(298l);
        examenes.add(examenDTO);

        examenDTO = new ExamenDTO();
        examenDTO.setNombre("Ecografia");
        examenDTO.setDescripcion("Ultrasonido venoso (extremidades)");
        examenDTO.setIdReactivo(299l);
        examenes.add(examenDTO);

        return examenes;

    }
}
