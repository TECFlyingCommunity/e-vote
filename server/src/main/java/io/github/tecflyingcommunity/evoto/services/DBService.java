package io.github.tecflyingcommunity.evoto.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Adm;
import io.github.tecflyingcommunity.evoto.domain.Candidato;
import io.github.tecflyingcommunity.evoto.domain.Categoria;
import io.github.tecflyingcommunity.evoto.domain.Cidade;
import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.Estado;
import io.github.tecflyingcommunity.evoto.domain.Partido;
import io.github.tecflyingcommunity.evoto.domain.enums.Perfil;
import io.github.tecflyingcommunity.evoto.repositories.AdmRepository;
import io.github.tecflyingcommunity.evoto.repositories.CandidatoRepository;
import io.github.tecflyingcommunity.evoto.repositories.CategoriaRepository;
import io.github.tecflyingcommunity.evoto.repositories.CidadeRepository;
import io.github.tecflyingcommunity.evoto.repositories.EleitorRepository;
import io.github.tecflyingcommunity.evoto.repositories.EstadoRepository;
import io.github.tecflyingcommunity.evoto.repositories.PartidoRepository;
import io.github.tecflyingcommunity.evoto.repositories.VotoRepository;

@Service
public class DBService {

    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EleitorRepository eleitorRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private VotoRepository votoRepository;

    public void instantiateTestDataBase(){
        

        Estado est1 =  new Estado(null, "Amazonas", "AM");
        Estado est2 =  new Estado(null, "Acre", "AC");

        Cidade cdd1 = new Cidade(null, "Manaus", est1);
        Cidade cdd2 = new Cidade(null, "Eirunepé", est1);
        Cidade cdd3 = new Cidade(null, "Rio Branco", est2);
    
        est1.getCidades().addAll(Arrays.asList(cdd1,cdd2));
        est2.getCidades().addAll(Arrays.asList(cdd3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(cdd1,cdd2,cdd3));

        Eleitor eleitor1 = new Eleitor("Pedro Marinho", "pedro.marinho238@gmail.com", bCryptPasswordEncoder.encode("123") , "000.000.000-01", "000000-01", "99 999999999", cdd1);
        

        Eleitor eleitor2 = new Eleitor("Pedro Eduardo", "pedroermarinho@gmail.com", bCryptPasswordEncoder.encode("123"), "000.000.000-02", "000000-02", "99 999999998", cdd2);

         eleitor2.addPerfil(Perfil.ADMIN);
         Adm adm1 = new Adm(null, "123", eleitor2);

         eleitor2.setAdm(adm1);

        eleitorRepository.saveAll(Arrays.asList(eleitor1,eleitor2));
        admRepository.saveAll(Arrays.asList(adm1));



        Partido ptd1 = new Partido(null, "Nação Verde", 34, "NV");
        Partido ptd2 = new Partido(null, "Nação Azul", 23, "NA");


        partidoRepository.saveAll(Arrays.asList(ptd1,ptd2));
        
        Categoria ctg1 = new Categoria(null, "Prefeito");
        Categoria ctg2 = new Categoria(null, "Deputado");
        Categoria ctg3 = new Categoria(null, "Presidente");

        categoriaRepository.saveAll(Arrays.asList(ctg1,ctg2,ctg3));

        Candidato cddt1 = new Candidato(null, 12, eleitor1, ptd1, ctg1);


      
       
        
        candidatoRepository.saveAll(Arrays.asList(cddt1));


    
    }
}
