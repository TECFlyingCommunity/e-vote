package io.github.tecflyingcommunity.evoto.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.tecflyingcommunity.evoto.config.Constants;
import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.domain.dto.CandidatoDTO;
import io.github.tecflyingcommunity.evoto.services.CandidatoService;

@RestController
@RequestMapping(value = Constants.API_URL_CANDIDATO)
public class CandidatoController {
	
	@Autowired
	private CandidatoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Candidato> find(@PathVariable Integer id) {
		Candidato obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/numero/{numero}", method=RequestMethod.GET)
	public ResponseEntity<Candidato> findByNumero(@PathVariable Integer numero) {
		Candidato obj = service.findByNumero(numero);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<Long> count() {
		final var  count = service.count();
		return ResponseEntity.ok().body(count);
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CandidatoDTO objDTO) {
		var obj = service.insert(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CandidatoDTO objDTO, @PathVariable Integer id) {
		objDTO.setId(id);
		 service.update(objDTO);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Candidato>> findAll() {
		List<Candidato> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
