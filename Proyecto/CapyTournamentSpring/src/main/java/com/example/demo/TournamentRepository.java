package com.example.demo;

import javax.persistence.QueryHint;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

//@Repository
public interface TournamentRepository extends JpaRepository <TournamentEntity, Long> {

	@CacheEvict(value = "tournamets", allEntries = true)
	void deleteByName(String name);
	
	@Cacheable("tournaments")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	TournamentEntity findByName(String name);
	
	@CacheEvict(value = "tournaments", allEntries = true)
	TournamentEntity save(TournamentEntity tournamentEntity);
}
