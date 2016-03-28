/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.VerCitaPacienteBiz;
import DTO.CitaDTO;
import Entidades.ImagenDiagnostica;
import Entidades.Laboratorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author jhtob
 */
@ManagedBean(name="verCitaPacienteBean")
@SessionScoped
public class VerCitaPacienteBean {
    
    private List<CitaDTO> citas = new ArrayList<>();
    private DataModel<CitaDTO> citaModel;
    private List<Laboratorio> examenesLaboratorio = new ArrayList<>();
    private DataModel<Laboratorio> examenesLaboratorioModel;
    private ImagenDiagnostica imagenDiagnostica;
    
    public CitaDTO citaSeleccionadaDTO;
    private String nombreMedicoCita;
    private String nombreDoctorCita;
    private Long idCita;
    private Date fechaCita;
    private Long valorCita;

    @PostConstruct
    public void init() {
        
        VerCitaPacienteBiz citaPacienteBiz = new VerCitaPacienteBiz();
                
        citas = citaPacienteBiz.parseCitaCitaDTO(LoginBean.getPaciente());
        
        citaModel = new ListDataModel<>(citas);
    }

    public List<CitaDTO> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaDTO> citas) {
        this.citas = citas;
    }

    public DataModel<CitaDTO> getCitaModel() {
        return citaModel;
    }

    public void setCitaModel(DataModel<CitaDTO> citaModel) {
        this.citaModel = citaModel;
    }

    public CitaDTO getCitaSeleccionadaDTO() {
        return citaSeleccionadaDTO;
    }

    public void setCitaSeleccionadaDTO(CitaDTO citaSeleccionadaDTO) {
        this.citaSeleccionadaDTO = citaSeleccionadaDTO;
    }
    
    public String getNombreMedicoCita() {
        return nombreMedicoCita;
    }

    public void setNombreMedicoCita(String nombreMedicoCita) {
        this.nombreMedicoCita = nombreMedicoCita;
    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Long getValorCita() {
        return valorCita;
    }

    public void setValorCita(Long valorCita) {
        this.valorCita = valorCita;
    }

    public List<Laboratorio> getExamenesLaboratorio() {
        return examenesLaboratorio;
    }

    public void setExamenesLaboratorio(List<Laboratorio> examenesLaboratorio) {
        this.examenesLaboratorio = examenesLaboratorio;
    }

    public DataModel<Laboratorio> getExamenesLaboratorioModel() {
        return examenesLaboratorioModel;
    }

    public void setExamenesLaboratorioModel(DataModel<Laboratorio> examenesLaboratorioModel) {
        this.examenesLaboratorioModel = examenesLaboratorioModel;
    }

    public ImagenDiagnostica getImagenDiagnostica() {
        return imagenDiagnostica;
    }

    public void setImagenDiagnostica(ImagenDiagnostica imagenDiagnostica) {
        this.imagenDiagnostica = imagenDiagnostica;
    }
    
    public String getNombreDoctorCita() {
        return nombreDoctorCita;
    }

    public void setNombreDoctorCita(String nombreDoctorCita) {
        this.nombreDoctorCita = nombreDoctorCita;
    }
    
    public String verCitaSeleccionada(){
        
        citaSeleccionadaDTO = citaModel.getRowData();
        idCita = citaSeleccionadaDTO.getCitaID();
        nombreMedicoCita = citaSeleccionadaDTO.getNombreMedico();
        nombreDoctorCita = citaSeleccionadaDTO.getNombreDoctor();
        fechaCita = citaSeleccionadaDTO.getFecha();
        valorCita = citaSeleccionadaDTO.getValor();
                
        examenesLaboratorio = (List<Laboratorio>) citaSeleccionadaDTO.getCita().getLaboratorioCollection();
        examenesLaboratorioModel = new ListDataModel<>(examenesLaboratorio);
        
        List<ImagenDiagnostica> imagenesDiagnosticas = new ArrayList<>(citaSeleccionadaDTO.getCita().getImagenDiagnosticaCollection());
        
        if(examenesLaboratorio.size()>0){
            return "verResultadoLaboratorioPaciente.xhtml";
        }else{
            imagenDiagnostica = imagenesDiagnosticas.get(0);
            return "verResultadoImagenPaciente.xhtml";
        }

    }
    
}
