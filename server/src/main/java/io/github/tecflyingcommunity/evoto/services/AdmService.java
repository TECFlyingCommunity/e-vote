package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Adm;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.dto.AdmDTO;
import io.github.tecflyingcommunity.evoto.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.exceptions.ObjectNotFoundException;
import io.github.tecflyingcommunity.evoto.repositories.AdmRepository;

@Service
public class AdmService {
	
	@Autowired
	private AdmRepository repository;
	
	@Autowired
	private EleitorService eleitorService;

	
	public Adm find(Integer id) {
		Optional<Adm> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Adm.class.getName()));
	}
	
	public Adm insert(AdmDTO objDTO) {
		objDTO.setId(null);
		
		final Adm obj = fromObj(objDTO);
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
	
	
	private Adm fromObj(AdmDTO objDTO) {
		
		final Eleitor eleitor = eleitorService.find(objDTO.getEleitorID()); 
		return new Adm(objDTO.getId(), objDTO.getMatricula(), eleitor);
	}
	
	
	


}
