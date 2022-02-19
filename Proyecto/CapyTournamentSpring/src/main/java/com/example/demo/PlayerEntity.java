package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayerEntity {
	@Id
	@Column(name="NOMBRE_JUGADOR", length=50, nullable=false, unique=true)
	private String name;
	
	@Column(name="EMAIL", length=80, nullable=false, unique=false)
	private String email;
	
	@Column(name="CONTRASENIA", length=30, nullable=false, unique=false)
	private String password;
	
	@Column(name="NOMBRE_JUGADOR_CLIENTE", length=50, nullable=false, unique=false)
	private String nombreCliente;
	
	@Column(name="WINRATE_JUGADOR", nullable=false, unique=false)
	private int winrate=0;
	
	//@Column(name="MAIN", nullable=true, unique=false)
	//private ChampionEntity main;
	
	@ManyToOne
	private TeamEntity team;
	
	@Column(name="ESTADO", length=240, nullable=true, unique=false)
	private String status= "FREE";
	
	protected PlayerEntity(){}

	public PlayerEntity(String name) {
		this.name = name;
		this.email = "";
		this.password = "";
		this.nombreCliente = "";
		this.winrate = 0;
		this.status = "";
	}
	
	public PlayerEntity(String name, String email, String password, String nombreCliente, int winrate, String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.nombreCliente = nombreCliente;
		this.winrate = winrate;
		this.status = status;
	}
	
	public void setTeam(TeamEntity team) {
		this.team = team;
	}
	
	public TeamEntity getTeam() {
		return this.team;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
