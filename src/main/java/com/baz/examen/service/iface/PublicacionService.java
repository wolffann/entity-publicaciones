package com.baz.examen.service.iface;

import java.util.Date;
import java.util.List;

import com.baz.examen.model.PublicacionDTO;

public interface PublicacionService {

	public PublicacionDTO guardarPublicacion(PublicacionDTO publicacionDTO);
	
	public List<PublicacionDTO> consultarPublicacionesConComentarios(Integer idUsuario);
	
}
