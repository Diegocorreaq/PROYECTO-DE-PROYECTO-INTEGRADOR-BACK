package com.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "propietario")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpropietario")
	private int idPropietario;
	
	@Column(name = "coddepartamento")
	private int codDepartamento;
	private String dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	

}


