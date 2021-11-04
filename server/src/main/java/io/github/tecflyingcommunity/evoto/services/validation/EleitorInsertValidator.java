package io.github.tecflyingcommunity.evoto.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.domain.dto.NovoEleitorDTO;
import io.github.tecflyingcommunity.evoto.exceptions.FieldMessage;
import io.github.tecflyingcommunity.evoto.repositories.EleitorRepository;

public class EleitorInsertValidator implements ConstraintValidator<EleitorInsert, NovoEleitorDTO> {

    
    @Autowired
	private EleitorRepository repository;

    @Override
	public void initialize(EleitorInsert ann) {
	}


    @Override
    public boolean isValid(NovoEleitorDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();



        Eleitor aux =repository.findByEmail(value.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
        return false;
    }
}
