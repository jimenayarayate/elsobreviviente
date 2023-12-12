package com.elsobreviviente.servicios.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodigoServicio;
    private String codigoServicio;
    private String nombreServicio;
    
    @ManyToOne
    @JoinColumn (name = "codigo_tipo_servicio", referencedColumnName = "codigo_tipo_servicio")
    private TipoServicio tipoServicio;

    
    public Long getIdCodigoServicio() {
    	return idCodigoServicio;
    }
    
    public void setIdCodigoServicio(Long idcodigoServicio, Long idCodigoServicio) {
	this.idCodigoServicio = idCodigoServicio;
}
    public String getCodigoServicio() {
    	return codigoServicio;
    }
    
    public void setCodigoServicio(String codigoServicio) {
    	this. codigoServicio = codigoServicio;
    }
    public String getNombreServicio() {
    	return nombreServicio;
    }
       
    public void getNombreServicio(String nombreServicio) {
    	this. nombreServicio = nombreServicio;
    }
    
 
    public TipoServicio getTiposervicio() {
		return tipoServicio;
	}

	public void setTiposervicio(TipoServicio tiposervicio) {
		this.tipoServicio = tiposervicio;
	}

	public void setNombreServicio(String nombreServicio2) {
		// TODO Auto-generated method stub
		
	}
}
    