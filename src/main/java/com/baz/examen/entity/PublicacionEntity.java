package com.baz.examen.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Data
@Entity
@Table(name = "publicacion")
public class PublicacionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPUBLICACION")
	private Integer idPublicacion;
	
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "TXPUBLICACION")
	private String txPublicacion;
	
	@Column(name = "STPUBLICACION")
	private Character stPublicacion;
	
	@Column(name = "FHCREACION")
	private Date fhCreacion;
	
	@Column(name = "FHMODIFICACION")
	private Date fhModificacion;
	
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(
		name = "IDPUBLICACION",
		referencedColumnName = "IDPUBLICACION", 
		insertable = false, 
		updatable = false, 
		foreignKey = @javax.persistence
        	.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private List<ComentarioEntity> comentariosList;
}
