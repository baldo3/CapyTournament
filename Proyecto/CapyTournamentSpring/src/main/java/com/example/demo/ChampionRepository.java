package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository <ChampionEntity, String>{
	void deleteById(String id);
	//void deleteByName(String name);
}
