package com.baz.examen.repository.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.examen.entity.PublicacionEntity;

public interface PublicacionJpaRepository extends JpaRepository<PublicacionEntity, Integer> {

}
