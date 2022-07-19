package com.baz.examen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baz.examen.entity.ComentarioEntity;

import lombok.Data;

@Data
public class ComentarioDTO implements Serializable {

	private static final long serialVersionUID = 5327903362829621554L;

	private Integer idComentario;
	
	private Integer idPublicacion;
		
	private Integer idUsuario;
		
	private String  txComentario;
		
	private Character stComentario;
		
	private Date fhCreacion;
		
	private Date fhModificacion;
	
}
