package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.domain.Categoria;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.Partido;
import io.github.tecflyingcommunity.evoto.domain.dto.CandidatoDTO;
import io.github.tecflyingcommunity.evoto.exceptions.DataIntegrityException;
import io.github.tecflyingcommunity.evoto.exceptions.ObjectNotFoundException;
import io.github.tecflyingcommunity.evoto.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	
	@Autowired
	CandidatoRepository repository;
	
	@Autowired
	private EleitorService eleitorService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private PartidoService partidoService;
	
	public Candidato find(Integer id) {
		Optional<Candidato> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
	}
	
	public Candidato insert(CandidatoDTO objDTO) {
		objDTO.setId(null);
		final Candidato obj = fromObj(objDTO);
		return repository.save(obj);
	}
	
	public Candidato update(CandidatoDTO objDTO) {
		Candidato newObj = find(objDTO.getId());
		updateData(newObj, fromObj(objDTO));
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
	
	private Candidato fromObj(CandidatoDTO objDTO) {
		
		final Eleitor eleitor = eleitorService.find(objDTO.getEleitorID());
		final Categoria categoria = categoriaService.find(objDTO.getCategoriaID());
		final Partido partido = partidoService.find(objDTO.getPartidoID());
		
		return new Candidato(objDTO.getId(), objDTO.getNumero(), eleitor, partido,categoria);
		
		
	}

}
