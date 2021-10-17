package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Cidade;
import io.github.tecflyingcommunity.evoto.repositories.CidadeRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	
	@Autowired
	private CidadeRepository repository;
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Cidade update(Cidade obj) {
		Cidade newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Cidade");
		}
	}
	
	public List<Cidade> findAll() {
		return repository.findAll();
	}
	
	
	
	private void updateData(Cidade newObj, Cidade obj) {
		newObj.setNome(obj.getNome());
		
	}
}
