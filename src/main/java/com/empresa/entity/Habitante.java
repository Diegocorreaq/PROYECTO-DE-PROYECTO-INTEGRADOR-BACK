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
@Table(name = "habitante")
public class Habitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idhabitante")
	private int idHabitante;
	@Column(name = "coddepartamento")
	private int codDepartamento;
	
	private String dni;
	private String nombre;	
	private String apellido;
	private String correo;
	private String telefono;
	private Date fechaNacimiento;
	@Column(name = "idtipopropietario")
	private int idTipoPropietario;	
	@Column(name = "idusuario")
	private int idUsuario;
	private Date fechaRegistro;
	
}
