package io.github.tecflyingcommunity.evoto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.tecflyingcommunity.evoto.domain.Eleitor;
import io.github.tecflyingcommunity.evoto.repositories.EleitorRepository;
import io.github.tecflyingcommunity.evoto.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private EleitorRepository eleitorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         final Eleitor eleitor = eleitorRepository.findByEmail(email);

        

         if (eleitor == null) {
             throw new UsernameNotFoundException(email);
         }
        return new  UserSS(eleitor.getId(), eleitor.getEmail(), eleitor.getSenha(), eleitor.getPerfis());
    }


    
}
