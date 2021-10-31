package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Cidade;
import io.github.tecflyingcommunity.evoto.domain.Estado;
import io.github.tecflyingcommunity.evoto.domain.dto.CidadeDTO;
import io.github.tecflyingcommunity.evoto.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.exceptions.ObjectNotFoundException;
import io.github.tecflyingcommunity.evoto.repositories.CidadeRepository;

@Service
public class CidadeService {

	
	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private EstadoService estadoService;
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public Cidade insert(CidadeDTO objDTO) {
		objDTO.setId(null);
		
		
		
		final Cidade cidade = fromObj(objDTO);
		
		
		return repository.save(cidade);
	}
	
	public Cidade update(CidadeDTO objDTO) {
		Cidade newObj = find(objDTO.getId());
		updateData(newObj, fromObj(objDTO));
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
	
	
	private Cidade fromObj(CidadeDTO objDTO) {
		final Estado estado = estadoService.find(objDTO.getEstadoID());
	
		 return new Cidade(objDTO.getId(), objDTO.getNome(), estado);
	}
}
