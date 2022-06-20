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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.empresa.entitySecurity.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visita")
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvisita")
	private int idVisita;
	
	@ManyToOne
	@JoinColumn(name = "coddepartamento")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name = "idvisitante")
	private Departamento idVisitante;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaEntrada;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaSalida;
	
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaRegistro;
	
	
}


