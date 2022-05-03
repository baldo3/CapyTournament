package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChampionEntity implements Serializable{

	@Id
	@Column(name="NOMBRE_CAMPEON", length=50, nullable=false, unique=true)
	private String name;
	
	protected ChampionEntity() {}
	
	public ChampionEntity(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
