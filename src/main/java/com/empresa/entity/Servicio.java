package com.empresa.entity;

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
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idservicio")
	private int idServicio;
	private String descripcion;
	
	
}


