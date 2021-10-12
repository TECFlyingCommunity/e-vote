package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Entity.Voto;
import io.github.tecflyingcommunity.evoto.repositories.VotoRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;


@Service
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	
	public Voto find(Integer id) {
		Optional<Voto> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Voto.class.getName()));
	}
	
	public Voto insert(Voto obj) {
		obj.setId(null);
		return repository.save(obj);
	}


	
	public List<Voto> findAll() {
		return repository.findAll();
	}
	
	


}
