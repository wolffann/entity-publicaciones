package com.baz.examen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PublicacionDTO implements Serializable {

	private static final long serialVersionUID = -4561667443236769993L;
	
	private Integer idPublicacion;
		
	private Integer idUsuario;
		
	private String txPublicacion;
		
	private Character stPublicacion;
	
	private Date fhCreacion;

	private Date fhModificacion;
	
	private List<ComentarioDTO> comentariosList = new ArrayList<>();

}
