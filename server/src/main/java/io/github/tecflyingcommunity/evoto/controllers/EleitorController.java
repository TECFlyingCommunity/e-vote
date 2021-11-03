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
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.dto.EleitorDTO;
import io.github.tecflyingcommunity.evoto.services.EleitorService;
import io.github.tecflyingcommunity.evoto.services.UserService;

@RestController
@RequestMapping(value = Constants.API_URL_ELEITOR)
public class EleitorController {
	
	@Autowired
	private EleitorService service;


	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Eleitor> find(@PathVariable Integer id) {
		Eleitor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Eleitor> current() {
		Eleitor obj = service.find(UserService.authenticated().getId());
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EleitorDTO objDTO) {
		var obj = service.insert(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EleitorDTO objDTO, @PathVariable Integer id) {
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
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<Eleitor>> findAll() {
		List<Eleitor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}



	
	
}
