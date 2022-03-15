package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RepositoryPlayerDetailService implements UserDetailsService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	protected PlayerSession currentUser;
		
	public RepositoryPlayerDetailService() {
	}

	/*@Override
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
	}*/

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		PlayerEntity player = playerRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : player.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		currentUser.setCurrentName(username);
		currentUser.setLogged(true);
		
		return new org.springframework.security.core.userdetails.User(player.getName(), 
				player.getPassword(), roles);

	}

}
