/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entidades.Doctor;
import Entidades.Examen;
import Entidades.Medico;
import Entidades.Paciente;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jaime
 */
public class CitaDTO implements Serializable {
    
    private Long citaID;
    private Date fecha;
    private long valor;
    private String nombreDoctor;
    private String nombreMedico;
   
    public CitaDTO() {
    }

    public Long getCitaID() {
        return citaID;
    }

    public void setCitaID(Long citaID) {
        this.citaID = citaID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    
    
}
