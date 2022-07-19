package com.baz.examen.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baz.examen.entity.PublicacionEntity;
import com.baz.examen.repository.iface.PublicacionRepository;

@Repository
public class PublicacionRepositoryImpl implements PublicacionRepository {
	
	@Autowired
	private EntityManager entityManager;	
	
	@Override
	public List<PublicacionEntity> findPublicacionesWithComentarios(Integer idUsuario) {
		TypedQuery<PublicacionEntity> query = entityManager
				.createQuery(
					"select p from PublicacionEntity p left join ComentarioEntity c on p.idPublicacion = c.idPublicacion"
					+ " where p.idUsuario = :idUsuario",
					PublicacionEntity.class);		
		
		return query.setParameter("idUsuario", idUsuario)					
					.getResultList();
	}

}
