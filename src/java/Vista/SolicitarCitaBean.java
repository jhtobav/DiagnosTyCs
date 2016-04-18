/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.SolicitarCitaBiz;
import DTO.ExamenDTO;
import DTO.MedicoDTO;
import Entidades.Agenda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author jhtob
 */
@ManagedBean(name = "solicitarCitaBean")
@SessionScoped
public class SolicitarCitaBean {

    private List<Agenda> tablaAgendas = new ArrayList<>();
    private List<MedicoDTO> medicos = new ArrayList<>();

    private String examenLaboratorio;
    private String imagenDiagnostica;
    private String tipoImagen;
    private String[] imagenes;
    private int numCelda;
    private String fecha;
    private Long medico;
    private Integer csv;

    private String[] rayosX = {"Angiografía aórtica", "Angiografía mesentérica", "Angiografía por catéter", "Angiografía pulmonar", "Arteriografía renal", "Artrografía directa", "Cistografía retrógrada", "Cistouretrograma miccional", "Colangiografía transhepática percutánea", "Densitometría ósea", "Discograma", "Enema opaco", "Enteroclisis", "Linfangiograma", "Mielografía", "Pielograma intravenoso (PIV)", "Radiografía abdominal", "Radiografía de cráneo", "Radiografía de cuello", "Radiografía de hueso", "Radiografía de la columna lumbosacra", "Radiografía de la columna torácica", "Radiografía de la pelvis", "Radiografía de las manos", "Radiografía de los senos paranasales", "Radiografía de una articulación", "Radiografía de una extremidad", "Radiografía del esqueleto", "Radiografía del tracto gastrointestinal (GI) inferior", "Radiografía dental", "Radiografía torácica", "Radiografías dentales", "Radiografías dentales (rayos X)", "Rayos X del tórax (radiografía de tórax)", "Rayos X del tracto gastrointestinal (GI) superior (radiografía)", "Rayos X óseo (radiografía)", "Rayos X panorámicos", "Sialograma", "Tránsito esofagogastroduodenal", "Tránsito gastrointestinal inferior", "Venografía", "Venografía", "Venografía renal"};
    private String[] tomografia = {"Angiografía coronaria por TC (ACTC)", "Angiotomografía computarizada", "Colonografía por TAC", "Enterografía por TAC", "Exploración de la cabeza por TAC", "Exploración de la columna vertebral por TAC", "Exploración de senos (paranasales) por TAC ", "Exploración del cuerpo por TAC ", "Exploración TAC de tórax", "Gammagrafía renal", "Perfusión por TAC de la cabeza", "TAC: Abdomen y pelvis ", "TAC cardíaca para la cuantificación del calcio coronario", "TC torácica", "Tomografía computarizada cervical", "Tomografía computarizada de la columna dorsal", "Tomografía computarizada de la columna lumbar", "Tomografía computarizada de la columna lumbosacra", "Tomografía computarizada de la órbita", "Tomografía computarizada de la pelvis", "Tomografía computarizada de la pierna", "Tomografía computarizada de la rodilla", "Tomografía computarizada de los senos paranasales", "Tomografía computarizada del abdomen", "Tomografía computarizada del brazo", "Tomografía computarizada del corazón", "Tomografía computarizada del cráneo", "Tomografía computarizada del hombro", "Tomografía computarizada (TC) y exploraciones para cáncer", "Urografía"};
    private String[] escanografia = {"Cisternografía con radionúclidos", "Cistografía con radionúclidos", "Estudios de medicina nuclear", "Exploración por tomografía por emisión de positrones", "Gammagrafía con galio (Ga)", "Gammagrafía con MIBG", "Gammagrafía de glóbulos blancos", "Gammagrafía de glóbulos rojos", "Gammagrafía de la tiroides", "Gammagrafía de la vesícula biliar con radionúclidos", "Gammagrafía de perfusión renal", "Gammagrafía del hígado", "Gammagrafía pulmonar con galio", "Gammagrafía renal", "Gammagrafía y absorción tiroideas", "Linfogammagrafía", "Medicina nuclear cardíaca", "Prueba de esfuerzo nuclear", "Tomografía de las mamas por emisión de positrones (TEP)", "Tomografía por emisión de positrones (TEP)", "Tomografía por emisión de positrones (TEP) del corazón", "Ventriculografía nuclear"};
    private String[] resonancia = {"Angiografía de resonancia magnética", "Angiografía por resonancia magnética", "Biopsia de mama guiada por RMN", "Colangiopancreatografía por resonancia magnética (CPRM)", "Enterografía por RMN", "Resonancia magnética cardíaca (RM cardíaca)", "Resonancia magnética: Cerebro", "Resonancia magnética cervical", "Resonancia magnética de la cabeza", "Resonancia magnética del abdomen", "Resonancia magnética del corazón", "Resonancia magnética nuclear (RMN) durante el embarazo", "Resonancia magnética y el lumbago", "RMN de cabeza", "RMN de columna", "RMN de cuerpo (tórax, abdomen, pelvis)", "RMN de la próstata", "RMN de la rodilla", "RMN de mama", "RMN de tórax", "RMN del hombro", "RMN del sistema musculoesquelético", "RMN funcional (RMNf): Cerebro", "Urografía"};
    private String[] ecografia = {"Ultrasonografía endoscópica (EUS)", "Ecocardiografía", "Ecocardiografía de esfuerzo", "Ecocardiografía transesofágica", "Ecografía abdominal", "Ecografía de la tiroides", "Ecografía Doppler de un brazo o de una pierna", "Ecografía dúplex", "Ecografía ocular y orbitaria", "Electrocardiograma", "Imágenes por ultrasonido de la arteria carótida", "Ultrasonido abdominal", "Ultrasonido craneal/ultrasonido de la cabeza", "Ultrasonido de cadera", "Ultrasonido de la tiroides", "Ultrasonido intravascular", "Ultrasonido musculoesquelético", "Ultrasonido pélvico", "Ultrasonido vascular", "Ultrasonido venoso (extremidades)"};

    public String init(String tipoExamen) {

        tablaAgendas = new ArrayList<>();
        medicos = new ArrayList<>();

        fecha = null;

        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();

        tablaAgendas = solicitarCitaBiz.cargarAgenda();
        medicos = solicitarCitaBiz.parseMedicoMedicoDTO();

        if (tipoExamen.equals("Laboratorio")) {
            return "solicitarCitaLaboratorio.xhtml";
        } else {
            return "solicitarCitaImagen.xhtml";
        }

    }

    public String[] getImagenes() {
        return imagenes;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public List<Agenda> getTablaAgendas() {
        return tablaAgendas;
    }

    public void setTablaAgendas(List<Agenda> tablaAgendas) {
        this.tablaAgendas = tablaAgendas;
    }

    public List<MedicoDTO> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoDTO> medicos) {
        this.medicos = medicos;
    }

    public String getExamenLaboratorio() {
        return examenLaboratorio;
    }

    public void setExamenLaboratorio(String examenLaboratorio) {
        this.examenLaboratorio = examenLaboratorio;
    }

    public String getImagenDiagnostica() {
        return imagenDiagnostica;
    }

    public void setImagenDiagnostica(String imagenDiagnostica) {
        this.imagenDiagnostica = imagenDiagnostica;
    }

    public int getNumCelda() {
        return numCelda;
    }

    public void setNumCelda(int numCelda) {
        this.numCelda = numCelda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCsv() {
        return csv;
    }

    public void setCsv(Integer csv) {
        this.csv = csv;
    }

    public String obtenerEstado(int indice) {

        if (tablaAgendas.get(indice - 1).getDisponible()) {
            return "button";
        } else {
            return "hidden";
        }

    }

    public Date parsearFecha(String fecha) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitarCitaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }

    public String solicitarCitaImagen() {

        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();

        List<ExamenDTO> imagenes = solicitarCitaBiz.cargarImagenes();

        for (ExamenDTO imagen : imagenes) {

            System.out.println("- " + imagenDiagnostica.trim().trim() + " -");
            System.out.println("- " + imagen.getDescripcion().trim().trim() + " -");

            if (imagen.getDescripcion().trim().trim().trim()
                    .equals(imagenDiagnostica.trim().trim())) {

                System.out.println("exito");
                solicitarCitaBiz.solicitarCitaImagen(csv, imagen, tablaAgendas.get(numCelda - 1), parsearFecha(fecha), medico);
                break;

            }
        }

        return "pacienteBody.xhtml";
    }

    public String solicitarCitaLaboratorio() {

        SolicitarCitaBiz solicitarCitaBiz = new SolicitarCitaBiz();

        List<ExamenDTO> examenes = solicitarCitaBiz.cargarExamenesLaboratorio();

        for (ExamenDTO examen : examenes) {

            System.out.println("- " + examenLaboratorio + " -");
            System.out.println("- " + examen.getNombre() + " -");

            if (examen.getNombre().equals(examenLaboratorio)) {

                System.out.println("exito");
                solicitarCitaBiz.solicitarCitaExamenLaboratorio(csv, examen, examenes, tablaAgendas.get(numCelda - 1), parsearFecha(fecha), medico);
                break;

            }

        }

        return "pacienteBody.xhtml";
    }

    public void seleccionarImagenes() {
        System.out.println(tipoImagen);
        if (tipoImagen.equals("Rayos X")) {
            imagenes = rayosX;
        }
        if (tipoImagen.equals("Tomografia Computarizada")) {
            imagenes = tomografia;
        }
        if (tipoImagen.equals("Escanografia nuclear")) {
            imagenes = escanografia;
        }
        if (tipoImagen.equals("Resonancia magnética")) {
            imagenes = resonancia;
        }
        if (tipoImagen.equals("Ecografia")) {
            imagenes = ecografia;
        }
        for (String imagen : imagenes) {
            System.out.println(imagen);
        }
    }

}
