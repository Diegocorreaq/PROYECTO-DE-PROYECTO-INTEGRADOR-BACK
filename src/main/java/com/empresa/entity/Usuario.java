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
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private int idUsuario;
	private String password;

	@ManyToOne
	@JoinColumn(name = "idtipousuario")
	private TipoUsuario tipoUsuario;
	
	private int dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	
	
	
}


