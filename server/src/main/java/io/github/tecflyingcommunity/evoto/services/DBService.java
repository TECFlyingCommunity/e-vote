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
import io.github.tecflyingcommunity.evoto.domain.Voto;
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

        Cidade cdd11 = new Cidade(null, "Manaus", est1);
        Cidade cdd12 = new Cidade(null, "Eirunepé", est1);
        Cidade cdd13 = new Cidade(null, "Parintins", est1);
        Cidade cdd14 = new Cidade(null, "Itacoatiara", est1);
        Cidade cdd15 = new Cidade(null, "Manacapuru", est1);
        Cidade cdd16 = new Cidade(null, "Coari", est1);
        Cidade cdd17 = new Cidade(null, "Tabatinga", est1);
        Cidade cdd18 = new Cidade(null, "Maués", est1);
        Cidade cdd19 = new Cidade(null, "Tefé", est1);


        Cidade cdd3 = new Cidade(null, "Rio Branco", est2);
    
        est1.getCidades().addAll(Arrays.asList(
        cdd11,
        cdd12,
        cdd13,
        cdd14,
        cdd15,
        cdd16,
        cdd17,
        cdd18,
        cdd19
        ));



        est2.getCidades().addAll(Arrays.asList(cdd3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(
            cdd11,
            cdd12,
            cdd13,
            cdd14,
            cdd15,
            cdd16,
            cdd17,
            cdd18,
            cdd19,
            cdd3
            ));

        Eleitor eleitor1 = new Eleitor("Pedro Marinho", "pedro.marinho238@gmail.com", bCryptPasswordEncoder.encode("123") , "000.000.000-01", "000000-01", "99 999999999", cdd11);
        

        Eleitor eleitor2 = new Eleitor("Pedro Eduardo", "pedroermarinho@gmail.com", bCryptPasswordEncoder.encode("123"), "000.000.000-02", "000000-02", "99 999999998", cdd12);

        Eleitor eleitor3 = new Eleitor("João", "joão@gmail.com", bCryptPasswordEncoder.encode("123") , "864.012.587-21", "000000-03", "99 999999999", cdd3);
        
        Eleitor eleitor4 = new Eleitor("Ruam", "Ruam@gmail.com", bCryptPasswordEncoder.encode("123") , "280.564.780-78", "000000-04", "99 999999999", cdd3);
        
        Eleitor eleitor5 = new Eleitor("ronaldo", "ronaldo@gmail.com", bCryptPasswordEncoder.encode("123") , "890.254.512-17", "000000-05", "99 999999999", cdd12);
        
        Eleitor eleitor6 = new Eleitor("maria", "maria@gmail.com", bCryptPasswordEncoder.encode("123") , "454.174.464-32", "000000-06", "99 999999999", cdd12);
        
        Eleitor eleitor7 = new Eleitor("fernanda", "fernanda@gmail.com", bCryptPasswordEncoder.encode("123") , "156.643.369-00", "000000-07", "99 999999999", cdd11);
        
        Eleitor eleitor8 = new Eleitor("rikelme", "rikelme@gmail.com", bCryptPasswordEncoder.encode("123") , "878.808.672-01", "000000-08", "99 999999999", cdd11);
        
        Eleitor eleitor9 = new Eleitor("Victor", "victor@gmail.com", bCryptPasswordEncoder.encode("123") , "551.170.457-18", "000000-09", "99 999999999", cdd11);
        
        Eleitor eleitor10 = new Eleitor("marcos", "marcos@gmail.com", bCryptPasswordEncoder.encode("123") , "959.669.604-10", "000000-10", "99 999999999", cdd12);

        Eleitor eleitor11 = new Eleitor("Júnior", "junior@gmail.com", bCryptPasswordEncoder.encode("123") , "431.736.713-09", "000000-11", "99 999999999", cdd13);

        Eleitor eleitor12 = new Eleitor("Mateus", "mateus@gmail.com", bCryptPasswordEncoder.encode("123") , "185.876.448-31", "000000-12", "99 999999999", cdd14);

        Eleitor eleitor13 = new Eleitor("Felipe", "felipe@gmail.com", bCryptPasswordEncoder.encode("123") , "983.284.412-68", "000000-13", "99 999999999", cdd15);

        Eleitor eleitor14 = new Eleitor("Marcelo", "macelo@gmail.com", bCryptPasswordEncoder.encode("123") , "539.787.325-05", "000000-14", "99 999999999", cdd16);

        Eleitor eleitor15 = new Eleitor("Janielson", "janielson.com", bCryptPasswordEncoder.encode("123") , "824.402.843-27", "000000-15", "99 999999999", cdd17);

         eleitor2.addPerfil(Perfil.ADMIN);
         Adm adm1 = new Adm(null, "123", eleitor2);

         eleitor2.setAdm(adm1);

        eleitorRepository.saveAll(Arrays.asList(
        eleitor1,
        eleitor2,
        eleitor3,
        eleitor4,
        eleitor5,
        eleitor6,
        eleitor7,
        eleitor8,
        eleitor9,
        eleitor10,
        eleitor11,
        eleitor12,
        eleitor13,
        eleitor14,
        eleitor15
        ));
        admRepository.saveAll(Arrays.asList(adm1));



        Partido ptd1 = new Partido(null, "Nação Verde", 34, "NV");
        Partido ptd2 = new Partido(null, "Nação Azul", 23, "NA");
        Partido ptd3 = new Partido(null, "Nação Vermelha", 24, "NV");
        Partido ptd4 = new Partido(null, "Nação Rosa", 25, "NR");
        Partido ptd5 = new Partido(null, "Nação Laranja", 26, "NL");


        partidoRepository.saveAll(Arrays.asList(ptd1,ptd2,ptd3,ptd4,ptd5));
        
        Categoria ctg1 = new Categoria(null, "Prefeito");
        Categoria ctg2 = new Categoria(null, "Deputado");
        Categoria ctg3 = new Categoria(null, "Presidente");

        categoriaRepository.saveAll(Arrays.asList(ctg1,ctg2,ctg3));

        Candidato cddt1 = new Candidato(null, 12, eleitor1, ptd1, ctg1);
        Candidato cddt2 = new Candidato(null, 13, eleitor3, ptd2, ctg1);
        Candidato cddt3 = new Candidato(null, 14, eleitor4, ptd3, ctg1);
        Candidato cddt4 = new Candidato(null, 15, eleitor5, ptd4, ctg1);

        candidatoRepository.saveAll(Arrays.asList(cddt1,cddt2,cddt3,cddt4));


        Voto v1 = new Voto(null, eleitor6, cddt1);
        Voto v2 = new Voto(null, eleitor7, cddt1);
        Voto v3 = new Voto(null, eleitor8, cddt2);
        Voto v4 = new Voto(null, eleitor9, cddt3);
        Voto v5 = new Voto(null, eleitor10, cddt3); 


        votoRepository.saveAll(Arrays.asList(v1,v2,v3,v4,v5));
    
    }
}
