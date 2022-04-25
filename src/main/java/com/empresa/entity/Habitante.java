package com.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "habitante")
public class Habitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhabitante")
	private int idHabitante;
	
	@ManyToOne
	@JoinColumn(name = "coddepartamento")
	private Departamento departamento;
	
	private String dni;
	private String nombre;	
	private String apellido;
	private String correo;
	private String telefono;
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "idtipohabitante")
	private TipoHabitante habitante;	
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	private Date fechaRegistro;
	
}
