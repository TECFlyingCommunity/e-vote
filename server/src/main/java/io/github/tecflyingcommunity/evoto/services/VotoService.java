package io.github.tecflyingcommunity.evoto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.Voto;
import io.github.tecflyingcommunity.evoto.domain.dto.NovoVotoDTO;
import io.github.tecflyingcommunity.evoto.domain.dto.VotoDTO;
import io.github.tecflyingcommunity.evoto.exceptions.ObjectNotFoundException;
import io.github.tecflyingcommunity.evoto.repositories.VotoRepository;


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




	
	public Voto insert(NovoVotoDTO objDTO) {
		objDTO.setId(null);
		
		final Voto obj = fromOBJ(objDTO);
		return repository.save(obj);
	}


	
	private Voto fromOBJ(NovoVotoDTO objDTO) {

		final Eleitor eleitor = eleitorService.find(objDTO.getEleitorID());
		final Candidato candidato = candidatoService.find(objDTO.getCandidatoID());

		if(eleitor == null){
			throw new ObjectNotFoundException("Eleitor não encontrado");
		}

		if(candidato == null){
			throw new ObjectNotFoundException("Candidato não encontrado");
		}

		return new Voto(objDTO.getId(), eleitor, candidato);
	}

	public List<VotoDTO> findAll() {

		List<VotoDTO> votos = new ArrayList<>();


		List<Candidato> candidatos =  candidatoService.findAll();

		for (Candidato candidato: candidatos){
			int quantVoto =  repository.countByCandidato(candidato);

			votos.add(new VotoDTO(candidato, quantVoto));
		}
		
		return votos;
	}
	

}
