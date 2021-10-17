package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Estado;
import io.github.tecflyingcommunity.evoto.repositories.EstadoRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	
	@Autowired
	private EstadoRepository repository;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
	
	public Estado insert(Estado obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Estado update(Estado obj) {
		Estado newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Estado");
		}
	}
	
	public List<Estado> findAll() {
		return repository.findAll();
	}
	
	
	
	private void updateData(Estado newObj, Estado obj) {
		newObj.setName(obj.getName());
		
	}
}
