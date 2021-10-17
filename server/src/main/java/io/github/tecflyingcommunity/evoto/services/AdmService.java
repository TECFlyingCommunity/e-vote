package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Adm;
import io.github.tecflyingcommunity.evoto.repositories.AdmRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class AdmService {
	
	@Autowired
	private AdmRepository repository;

	
	public Adm find(Integer id) {
		Optional<Adm> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Adm.class.getName()));
	}
	
	public Adm insert(Adm obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Adm");
		}
	}
	
	public List<Adm> findAll() {
		return repository.findAll();
	}
	
	
	


}
