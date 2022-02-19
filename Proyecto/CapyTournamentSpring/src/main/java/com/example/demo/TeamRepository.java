package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository <TeamEntity,String>{
	List<TeamEntity> findByNombre(String nombre);
	void deleteById(String id);
	
	Optional<TeamEntity> findById(String id);
}
