package pe.edu.cibertec.proyem.jpa.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Empleado {

	 @Id
	 @GeneratedValue
	private Long id;
	private String nombre;
	

	public Empleado(){}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Empleado(String nombre, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
	}
	@ManyToOne
	private Departamento departamento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
