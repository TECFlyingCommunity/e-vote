package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.repositories.EleitorRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class EleitorService {
	
	@Autowired
	private EleitorRepository repository;
	
	public Eleitor find(Integer id) {
		Optional<Eleitor> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Eleitor.class.getName()));
	}
	
	public Eleitor insert(Eleitor obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Eleitor update(Eleitor obj) {
		Eleitor newObj = find(obj.getId());
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
	
	public List<Eleitor> findAll() {
		return repository.findAll();
	}
	
	
	
	private void updateData(Eleitor newObj, Eleitor obj) {
		newObj.setNome(obj.getNome());
		newObj.setSenha(obj.getSenha());
	}

}
