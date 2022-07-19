package com.baz.examen.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.examen.entity.ComentarioEntity;
import com.baz.examen.model.ComentarioDTO;
import com.baz.examen.repository.iface.ComentarioRepository;
import com.baz.examen.service.iface.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public ComentarioDTO guardarComentario(ComentarioDTO comentarioDTO) {
		Date fechaComun = new Date();
		ComentarioEntity comentarioEntity = new ComentarioEntity();
		comentarioEntity.setFhCreacion(fechaComun);
		comentarioEntity.setFhModificacion(fechaComun);
		comentarioEntity.setIdPublicacion(comentarioDTO.getIdPublicacion());
		comentarioEntity.setIdUsuario(comentarioDTO.getIdUsuario());
		comentarioEntity.setStComentario('1');
		comentarioEntity.setTxComentario(comentarioDTO.getTxComentario());		
		
		comentarioEntity = comentarioRepository.save(comentarioEntity);
		BeanUtils.copyProperties(comentarioEntity, comentarioDTO);
		return comentarioDTO;
	}

}
