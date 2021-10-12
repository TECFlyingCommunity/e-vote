package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Entity.Partido;
import io.github.tecflyingcommunity.evoto.repositories.PartidoRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository repository;

	
	public Partido find(Integer id) {
		Optional<Partido> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Partido.class.getName()));
	}
	
	public Partido insert(Partido obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Partido update(Partido obj) {
		Partido newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Eleitor");
		}
	}
	
	public List<Partido> findAll() {
		return repository.findAll();
	}
	
	
	
	private void updateData(Partido newObj, Partido obj) {
		newObj.setNome(obj.getNome());
	}

}
