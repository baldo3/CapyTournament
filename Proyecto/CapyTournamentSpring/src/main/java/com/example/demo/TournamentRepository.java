package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository <TournamentEntity, Long> {

	void deleteByName(String name);
	TournamentEntity findByName(String name);
}
