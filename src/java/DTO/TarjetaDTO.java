/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jaime
 */
public class TarjetaDTO implements Serializable {
    
    private Long idTarjeta;
    private String nombrePaciente;
    private int numeroAno;
    private int numeroMes;
    private int csv;
   
    public TarjetaDTO() {
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getNumeroAno() {
        return numeroAno;
    }

    public void setNumeroAno(int numeroAno) {
        this.numeroAno = numeroAno;
    }

    public int getNumeroMes() {
        return numeroMes;
    }

    public void setNumeroMes(int numeroMes) {
        this.numeroMes = numeroMes;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

}
