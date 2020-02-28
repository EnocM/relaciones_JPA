/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "personadiagrama")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personadiagrama.findAll", query = "SELECT p FROM Personadiagrama p")
    , @NamedQuery(name = "Personadiagrama.findByIdpersonaDiagrama", query = "SELECT p FROM Personadiagrama p WHERE p.idpersonaDiagrama = :idpersonaDiagrama")
    , @NamedQuery(name = "Personadiagrama.findByNombre", query = "SELECT p FROM Personadiagrama p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Personadiagrama.findByApellido", query = "SELECT p FROM Personadiagrama p WHERE p.apellido = :apellido")})
public class Personadiagrama implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonaDiagrama")
    private Integer idpersonaDiagrama;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;

    public Personadiagrama() {
    }

    public Personadiagrama(Integer idpersonaDiagrama) {
        this.idpersonaDiagrama = idpersonaDiagrama;
    }

    public Personadiagrama(Integer idpersonaDiagrama, String nombre, String apellido) {
        this.idpersonaDiagrama = idpersonaDiagrama;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdpersonaDiagrama() {
        return idpersonaDiagrama;
    }

    public void setIdpersonaDiagrama(Integer idpersonaDiagrama) {
        this.idpersonaDiagrama = idpersonaDiagrama;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonaDiagrama != null ? idpersonaDiagrama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personadiagrama)) {
            return false;
        }
        Personadiagrama other = (Personadiagrama) object;
        if ((this.idpersonaDiagrama == null && other.idpersonaDiagrama != null) || (this.idpersonaDiagrama != null && !this.idpersonaDiagrama.equals(other.idpersonaDiagrama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Personadiagrama[ idpersonaDiagrama=" + idpersonaDiagrama + " ]";
    }
    
}
