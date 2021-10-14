package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.repositories.CandidatoRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class CandidatoService {

	
	@Autowired
	CandidatoRepository repository;
	
	public Candidato find(Integer id) {
		Optional<Candidato> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
	}
	
	public Candidato insert(Candidato obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Candidato update(Candidato obj) {
		Candidato newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Candidato");
		}
	}
	
	public List<Candidato> findAll() {
		return repository.findAll();
	}
	
	
	
	private void updateData(Candidato newObj, Candidato obj) {
		newObj.setNumero(obj.getNumero());
		newObj.setPartido(obj.getPartido());
		
	}

}
