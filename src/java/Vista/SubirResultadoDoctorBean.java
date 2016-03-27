/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Business.SubirResultadoDoctorBiz;
import DTO.CitaDTO;
import Entidades.ImagenDiagnostica;
import Entidades.Laboratorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jhtob
 */
@ManagedBean(name = "subirResultadoDoctorBean")
@SessionScoped
public class SubirResultadoDoctorBean {

    private List<CitaDTO> citas = new ArrayList<>();
    private DataModel<CitaDTO> citaModel;
    private List<Laboratorio> examenesLaboratorio = new ArrayList<>();
    private DataModel<Laboratorio> examenesLaboratorioModel;
    private List<ImagenDiagnostica> imagenesDiagnosticas = new ArrayList<>();
    private DataModel<ImagenDiagnostica> imagenesDiagnosticasModel;

    public static CitaDTO citaSeleccionadaDTO;
    public static ImagenDiagnostica imagenSeleccionada;
    private Long idPaciente;
    private String nombrePaciente;
    private Long idCita;
    private Date fechaCita;

    @PostConstruct
    public void init() {

        SubirResultadoDoctorBiz subirResultadoDoctorBiz = new SubirResultadoDoctorBiz();

        citas = subirResultadoDoctorBiz.parseCita_CitaDTO(LoginBean.getDoctor());

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
        SubirResultadoDoctorBean.citaSeleccionadaDTO = citaSeleccionadaDTO;
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

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public List<ImagenDiagnostica> getImagenesDiagnosticas() {
        return imagenesDiagnosticas;
    }

    public void setImagenesDiagnosticas(List<ImagenDiagnostica> imagenesDiagnosticas) {
        this.imagenesDiagnosticas = imagenesDiagnosticas;
    }

    public DataModel<ImagenDiagnostica> getImagenesDiagnosticasModel() {
        return imagenesDiagnosticasModel;
    }

    public void setImagenesDiagnosticasModel(DataModel<ImagenDiagnostica> imagenesDiagnosticasModel) {
        this.imagenesDiagnosticasModel = imagenesDiagnosticasModel;
    }

    public static ImagenDiagnostica getImagenSeleccionada() {
        return imagenSeleccionada;
    }

    public static void setImagenSeleccionada(ImagenDiagnostica imagenSeleccionada) {
        SubirResultadoDoctorBean.imagenSeleccionada = imagenSeleccionada;
    }

    public String verCitaSeleccionada() {

        citaSeleccionadaDTO = citaModel.getRowData();
        idCita = citaSeleccionadaDTO.getCitaID();
        idPaciente = citaSeleccionadaDTO.getIdPaciente();
        nombrePaciente = citaSeleccionadaDTO.getNombrePaciente();
        fechaCita = citaSeleccionadaDTO.getFecha();

        if (LoginBean.getDoctor().getEspecialidad().equals("ImagenesDiagnosticas")) {
            imagenesDiagnosticas = (List<ImagenDiagnostica>) citaSeleccionadaDTO.getCita().getImagenDiagnosticaCollection();
            imagenesDiagnosticasModel = new ListDataModel<>(imagenesDiagnosticas);
            return "subirResultadoImagenDoctor.xhtml";
        } else {
            examenesLaboratorio = (List<Laboratorio>) citaSeleccionadaDTO.getCita().getLaboratorioCollection();
            examenesLaboratorioModel = new ListDataModel<>(examenesLaboratorio);
            return "subirResultadoLaboratorioDoctor.xhtml";
        }

    }

    public String subirResultadoLaboratorio() {

        SubirResultadoDoctorBiz subirResultadoDoctorBiz = new SubirResultadoDoctorBiz();

        examenesLaboratorio = subirResultadoDoctorBiz.actualizarExamenesLaboratorio(examenesLaboratorio);

        return "subirResultadoLaboratorioDoctor.xhtml";

    }

    public String subirResultadoImagen(FileUploadEvent event) throws IOException {

        UploadedFile imagen = event.getFile();

        SubirResultadoDoctorBiz subirResultadoDoctorBiz = new SubirResultadoDoctorBiz();

        imagenesDiagnosticas = subirResultadoDoctorBiz.actualizarImagenDiagnostica(imagen, imagenesDiagnosticas);

        return "subirResultadoImagenDoctor.xhtml";

    }

}
