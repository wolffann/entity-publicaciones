package com.baz.examen.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "comentario")
public class ComentarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMENTARIO")
	private Integer idComentario;
	
	@Column(name = "IDPUBLICACION")
	private Integer idPublicacion;
	
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "TXCOMENTARIO")
	private String  txComentario;
	
	@Column(name = "STCOMENTARIO")
	private Character stComentario;
	
	@Column(name = "FHCREACION")
	private Date fhCreacion;
	
	@Column(name = "FHMODIFICACION")
	private Date fhModificacion;  

}
