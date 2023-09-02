package com.example.demo.repository.modelo.dto;

public class MatriculaDTO {
	
	private String cedula;
	
	private String codigo;
	
	private String fecha;
	
	private String nombre;

	public MatriculaDTO(String cedula, String codigo, String fecha, String nombre) {
		super();
		this.cedula = cedula;
		this.codigo = codigo;
		this.fecha = fecha;
		this.nombre = nombre;
	}
	
	public MatriculaDTO() {
		
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
