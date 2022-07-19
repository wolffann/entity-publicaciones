package com.baz.examen.repository.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.examen.entity.ComentarioEntity;

public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Integer> {

}
