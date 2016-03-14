/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.VerCitaPacienteBiz;
import DAO.AgendaDAO;
import DTO.CitaDTO;
import Entidades.Doctor;
import Entidades.Examen;
import Entidades.Medico;
import Entidades.Paciente;
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
    
    public static CitaDTO citaSeleccionadaDTO;
    private String nombreDoctorCita;
    private String nombreMedicoCita;
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

    public static CitaDTO getCitaSeleccionadaDTO() {
        return citaSeleccionadaDTO;
    }

    public static void setCitaSeleccionadaDTO(CitaDTO citaSeleccionadaDTO) {
        VerCitaPacienteBean.citaSeleccionadaDTO = citaSeleccionadaDTO;
    }

    public String getNombreDoctorCita() {
        return nombreDoctorCita;
    }

    public void setNombreDoctorCita(String nombreDoctorCita) {
        this.nombreDoctorCita = nombreDoctorCita;
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
    
    public String verCitaSeleccionada(){
        
        citaSeleccionadaDTO = citaModel.getRowData();
        idCita = citaSeleccionadaDTO.getCitaID();
        nombreDoctorCita = citaSeleccionadaDTO.getNombreDoctor();
        nombreMedicoCita = citaSeleccionadaDTO.getNombreMedico();
        fechaCita = citaSeleccionadaDTO.getFecha();
        idCita = citaSeleccionadaDTO.getCitaID();
        valorCita = citaSeleccionadaDTO.getValor();
                
        return "verCita.xhtml";

    }
    
}
