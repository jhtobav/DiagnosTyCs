/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "HistoricoGastosGananciasCitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findAll", query = "SELECT h FROM HistoricoGastosGananciasCitas h"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findById", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByFecha", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByIntervaloFecha", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.fecha >= :from_date and h.fecha <= :to_date"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByNombreExamen", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.nombreExamen = :nombreExamen"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByTipo", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.tipo = :tipo"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByPrecioReactivo", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.precioReactivo = :precioReactivo"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByValorExamen", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.valorExamen = :valorExamen"),
    @NamedQuery(name = "HistoricoGastosGananciasCitas.findByGanancia", query = "SELECT h FROM HistoricoGastosGananciasCitas h WHERE h.ganancia = :ganancia")})
public class HistoricoGastosGananciasCitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreExamen")
    private String nombreExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioReactivo")
    private long precioReactivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorExamen")
    private long valorExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganancia")
    private long ganancia;

    public HistoricoGastosGananciasCitas() {
    }

    public HistoricoGastosGananciasCitas(Long id) {
        this.id = id;
    }

    public HistoricoGastosGananciasCitas(Long id, Date fecha, String nombreExamen, String tipo, long precioReactivo, long valorExamen, long ganancia) {
        this.id = id;
        this.fecha = fecha;
        this.nombreExamen = nombreExamen;
        this.tipo = tipo;
        this.precioReactivo = precioReactivo;
        this.valorExamen = valorExamen;
        this.ganancia = ganancia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getPrecioReactivo() {
        return precioReactivo;
    }

    public void setPrecioReactivo(long precioReactivo) {
        this.precioReactivo = precioReactivo;
    }

    public long getValorExamen() {
        return valorExamen;
    }

    public void setValorExamen(long valorExamen) {
        this.valorExamen = valorExamen;
    }

    public long getGanancia() {
        return ganancia;
    }

    public void setGanancia(long ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoGastosGananciasCitas)) {
            return false;
        }
        HistoricoGastosGananciasCitas other = (HistoricoGastosGananciasCitas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HistoricoGastosGananciasCitas[ id=" + id + " ]";
    }
    
}
