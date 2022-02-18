package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChampionEntity {
	//atributos 
	@Id
	@Column(name="NOMBRE_CAMPEON", length=50, nullable=false, unique=true)
	private String nombre;
	
	protected ChampionEntity() {}
	public ChampionEntity(String nombre) {
		super();
		this.nombre = nombre;
	}
}
