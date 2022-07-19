package com.baz.examen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.examen.entity.ComentarioEntity;
import com.baz.examen.entity.PublicacionEntity;
import com.baz.examen.exception.custom.ServiceException;
import com.baz.examen.exception.enums.ErrorCode;
import com.baz.examen.model.ComentarioDTO;
import com.baz.examen.model.PublicacionDTO;
import com.baz.examen.repository.iface.PublicacionJpaRepository;
import com.baz.examen.repository.iface.PublicacionRepository;
import com.baz.examen.service.iface.PublicacionService;

@Service
public class PublicacionServiceImpl implements PublicacionService {
	
	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Autowired
	private PublicacionJpaRepository publicacionJpaRepository;
	
	@Override
	public PublicacionDTO guardarPublicacion(PublicacionDTO publicacionDTO) {
		Date fechaComun = new Date(); 
		PublicacionEntity publicacionEntity = new PublicacionEntity();
		publicacionEntity.setIdUsuario(publicacionDTO.getIdUsuario());
		publicacionEntity.setTxPublicacion(publicacionDTO.getTxPublicacion());
		publicacionEntity.setStPublicacion('1');
		publicacionEntity.setFhCreacion(fechaComun);
		publicacionEntity.setFhModificacion(fechaComun);
		
		publicacionEntity = publicacionJpaRepository.save(publicacionEntity);
		BeanUtils.copyProperties(publicacionEntity, publicacionDTO);
		return publicacionDTO;
	}
	
	@Override
	public List<PublicacionDTO> consultarPublicacionesConComentarios(Integer idUsuario) {
		try {
			List<PublicacionDTO> publicacionDTOList = new ArrayList<>();		
			List<PublicacionEntity> publicacionesEntity = publicacionRepository.findPublicacionesWithComentarios(idUsuario);
			
			publicacionesEntity.stream().forEach(publicacionEntity -> publicacionDTOList.add(copiarProperties(publicacionEntity)));
			return publicacionDTOList;					
		
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.ERROR_INTERNO.codigo(), ErrorCode.ERROR_INTERNO.detalle(), "", e);
		}
	}			

	private PublicacionDTO copiarProperties(PublicacionEntity publicacionEntity) {
		PublicacionDTO publicacionDTO = new PublicacionDTO();
		BeanUtils.copyProperties(publicacionEntity, publicacionDTO);
		
		List<ComentarioDTO> comentariosDTOList = new ArrayList<ComentarioDTO>();		
		publicacionEntity.getComentariosList().stream().forEach(comentarioEntity -> comentariosDTOList.add(copiarProperties(comentarioEntity)));		
		publicacionDTO.setComentariosList(comentariosDTOList);
		
		return publicacionDTO;
	}

	private ComentarioDTO copiarProperties(ComentarioEntity comentarioEntity) {
		ComentarioDTO comentarioDTO = new ComentarioDTO();
		BeanUtils.copyProperties(comentarioEntity, comentarioDTO);
		return comentarioDTO;
	}

}
