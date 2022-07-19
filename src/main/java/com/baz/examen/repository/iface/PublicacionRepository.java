package com.baz.examen.repository.iface;

import java.util.Date;
import java.util.List;

import com.baz.examen.entity.PublicacionEntity;

public interface PublicacionRepository {
	
	public List<PublicacionEntity> findPublicacionesWithComentarios(Integer idUsuario);

}
