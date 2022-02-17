package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamInterface extends JpaRepository <TeamEntity,String>{
	List<TeamEntity> findByNombre(String nombre);
}
