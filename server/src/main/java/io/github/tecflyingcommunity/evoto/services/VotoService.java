package io.github.tecflyingcommunity.evoto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.Voto;
import io.github.tecflyingcommunity.evoto.domain.dto.VotoDTO;
import io.github.tecflyingcommunity.evoto.repositories.VotoRepository;
import io.github.tecflyingcommunity.evoto.services.exceptions.ObjectNotFoundException;


@Service
public class VotoService {
	
	@Autowired
	private VotoRepository repository;
	
	@Autowired
	private EleitorService eleitorService;
	
	
	@Autowired
	private CandidatoService candidatoService;
	
	
	public Voto find(Integer id) {
		Optional<Voto> obj = repository.findById(id);
		
		return  obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Voto.class.getName()));
	}
	
	public Voto insert(VotoDTO objDTO) {
		objDTO.setId(null);
		
		final Voto obj = fromOBJ(objDTO);
		return repository.save(obj);
	}


	
	private Voto fromOBJ(VotoDTO objDTO) {
		final Eleitor eleitor = eleitorService.find(objDTO.getEleitorID());
		final Candidato candidato = candidatoService.find(objDTO.getCandidatoID());
		return new Voto(objDTO.getId(), eleitor, candidato);
	}

	public List<Voto> findAll() {
		return repository.findAll();
	}
	
	


}
