package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class PlayerAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	protected PlayerSession currentUser;
		
	public PlayerAuthenticationProvider() {
	}

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		Optional<PlayerEntity> player = playerRepository.findById(auth.getName());
		System.out.println("ENTRA");
		if(!player.isPresent()) {
			currentUser.setErrorUsuario(true);
			throw new BadCredentialsException("User not found");
		}
		
		String password = (String) auth.getCredentials();
		
		if (!new BCryptPasswordEncoder().matches(password, player.get().getPassword())) {
			currentUser.setErrorContra(true);
			throw new BadCredentialsException("Wrong password");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
			
		for (String role : player.get().getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}

		currentUser.setCurrentName(auth.getName());
		currentUser.setLogged(true);
		
		//TOKEN
		return new UsernamePasswordAuthenticationToken(player.get().getName(), password, roles);
	}
	
	@Override
	public boolean supports(Class<?> authenticationObject) {
		// TODO Auto-generated method stub
		return true;
	}

}
