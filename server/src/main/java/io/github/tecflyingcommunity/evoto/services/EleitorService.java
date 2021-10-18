package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Cidade;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.dto.EleitorDTO;
import io.github.tecflyingcommunity.evoto.repositories.EleitorRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;

@Service
public class EleitorService {
	
	@Autowired
	private EleitorRepository repository;
	
	@Autowired
	private CidadeService cidadeService;
	
	public Eleitor find(Integer id) {
		Optional<Eleitor> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Eleitor.class.getName()));
	}
	
	public Eleitor insert(EleitorDTO objDTO) {
		objDTO.setId(null);
		final Eleitor obj = fromObj(objDTO);
		return repository.save(obj);
	}
	
	

	public Eleitor update(EleitorDTO objDTO) {
		Eleitor newObj = find(objDTO.getId());
		updateData(newObj, fromObj(objDTO));
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
	
	private Eleitor fromObj(EleitorDTO objDTO) {
		
		final Cidade cidade = cidadeService.find(objDTO.getCidadeID());
		return new Eleitor(objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getCpf(), objDTO.getTitulo(), cidade);
	}
	
	private void updateData(Eleitor newObj, Eleitor obj) {
		newObj.setNome(obj.getNome());
		newObj.setSenha(obj.getSenha());
	}

}
