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
import io.github.tecflyingcommunity.evoto.domain.Voto;
import io.github.tecflyingcommunity.evoto.domain.dto.NovoVotoDTO;
import io.github.tecflyingcommunity.evoto.domain.dto.VotoDTO;
import io.github.tecflyingcommunity.evoto.services.VotoService;

@RestController
@RequestMapping(value = Constants.API_URL_VOTO)
public class VotoController {

	
	@Autowired
	private VotoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Voto> find(@PathVariable Integer id) {
		Voto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<Long> count() {
		final var  count = service.count();
		return ResponseEntity.ok().body(count);
	}
	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody NovoVotoDTO objDTO) {
		var obj = service.insert(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VotoDTO>> findAll() {
		List<VotoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
