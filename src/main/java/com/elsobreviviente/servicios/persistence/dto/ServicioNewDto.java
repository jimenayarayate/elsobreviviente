package com.elsobreviviente.servicios.persistence.dto;

public class ServicioNewDto {
	private Long idCodigoServicio;
	 private String codigoServicio;
    private String nombreServicio;
    private String codigoTipoServicio;
    
	public Long getIdCodigoServicio() {
		return idCodigoServicio;
	}
	public void setIdCodigoServicio(Long idCodigoServicio) {
		this.idCodigoServicio = idCodigoServicio;
	}
	public String getCodigoServicio() {
		return codigoServicio;
	}
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getCodigoTipoServicio() {
		return codigoTipoServicio;
	}
	public void setCodigoTipoServicio(String codigoTipoServicio) {
		this.codigoTipoServicio = codigoTipoServicio;
	}
}
