package com.baz.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baz.examen.model.ComentarioDTO;
import com.baz.examen.model.PublicacionDTO;
import com.baz.examen.service.iface.ComentarioService;
import com.baz.examen.service.iface.PublicacionService;

@RestController
public class PublicacionesController {
	
	@Autowired
	private PublicacionService publicacionService;
	
	@Autowired
	private ComentarioService comentarioService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/publicaciones")
	public PublicacionDTO guardarPublicacion(@RequestBody PublicacionDTO publicacionDTO) {
		return publicacionService.guardarPublicacion(publicacionDTO);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/publicaciones/{idUsuario}")
	public List<PublicacionDTO> consultarPublicacionesConComentarios(@PathVariable Integer idUsuario) {
		return publicacionService.consultarPublicacionesConComentarios(idUsuario);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/comentarios")
	public ComentarioDTO guardarComentario(@RequestBody ComentarioDTO comentarioDTO) {
		return comentarioService.guardarComentario(comentarioDTO);
	}

}
