package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <PlayerEntity, String>{
	
	void deleteById(String id);
	
	Optional<PlayerEntity> findById(String id);
	
}
