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
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codmascota")
	private int codMascota;
	
	@Column(name = "coddepartamento")
	private int codDepartamento;
	private String nombre;
	private String tipo;
	private String raza;
	private String sexo;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	
	
}


