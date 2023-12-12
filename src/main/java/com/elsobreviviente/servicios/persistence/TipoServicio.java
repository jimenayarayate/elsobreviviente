package com.elsobreviviente.servicios.persistence;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tipo_servicio")
public class TipoServicio {

	@Id
	@Column (name ="codigo_tipo_servicio")
	private String codigoTipoSevicio;
	
	@Column (name ="nombre_tipo_servicio")
	private String nombreTipoSevicio;
	
	@OneToMany (mappedBy ="tipoServicio")
	private List<Servicio> servicioList = new ArrayList<>();

	public String getCodigoTipoSevicio() {
		return codigoTipoSevicio;
	}

	public void setCodigoTipoSevicio(String codigoTipoSevicio) {
		this.codigoTipoSevicio = codigoTipoSevicio;
	}

	public String getNombreTipoSevicio() {
		return nombreTipoSevicio;
	}

	public void setNombreTipoSevicio(String nombreTipoSevicio) {
		this.nombreTipoSevicio = nombreTipoSevicio;
	}

	public List<Servicio> getServicioList() {
		return servicioList;
	}

	public void setServicioList(List<Servicio> servicioList) {
		this.servicioList = servicioList;
	}
	
	
	
}
