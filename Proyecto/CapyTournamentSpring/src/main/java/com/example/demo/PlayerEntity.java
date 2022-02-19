package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayerEntity {
	@Id
	@Column(name="NOMBRE_JUGADOR", length=50, nullable=false, unique=true)
	private String nombre;
	
	@Column(name="EMAIL", length=80, nullable=false, unique=true)
	private String email;
	
	@Column(name="CONTRASENIA", length=30, nullable=false, unique=false)
	private String contrasenia;
	
	@Column(name="NOMBRE_JUGADOR_CLIENTE", length=50, nullable=false, unique=true)
	private String nombreCliente;
	
	@Column(name="WINRATE_JUGADOR", nullable=false, unique=false)
	private int winrate=0;
	
	//@Column(name="MAIN", nullable=true, unique=false)
	//private ChampionEntity main;
	
	@ManyToOne
	private TeamEntity team;
	
	@Column(name="ESTADO", length=240, nullable=true, unique=false)
	private String estado= "";
	
	protected PlayerEntity(){}

	public PlayerEntity(String nombre, String email, String contrasenia, String nombreCliente, int winrate,
			/*ChampionEntity main,*/ String estado) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombreCliente = nombreCliente;
		this.winrate = winrate;
		//this.main = main;
		this.estado = estado;
	}
	
	public void setTeam(TeamEntity team) {
		this.team = team;
	}
	
	public TeamEntity getTeam() {
		return this.team;
	}
	
	
	
}
