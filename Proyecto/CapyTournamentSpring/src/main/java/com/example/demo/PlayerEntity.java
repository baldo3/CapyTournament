package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class PlayerEntity {
	@Id
	@Column(name="NOMBRE_JUGADOR", length=50, nullable=false, unique=true)
	private String name;
	
	@Column(name="EMAIL", length=80, nullable=false, unique=false)
	private String email;
	
	@Column(name="CONTRASENIA", nullable=false, unique=false)
	private String passwordHash;
	
	@Column(name="NOMBRE_JUGADOR_CLIENTE", length=50, nullable=false, unique=false)
	private String nombreCliente;
	
	@Column(name="WINRATE_JUGADOR", nullable=false, unique=false)
	private int winrate=0;
	
	//@OneToOne
	//private ChampionEntity main;
	
	@ManyToOne
	private TeamEntity team;
	
	//@ElementCollection(fetch = FetchType.EAGER)
	//private List<String> roles;
	
	@Column(name="ESTADO", length=240, nullable=true, unique=false)
	private String status= "FREE";
	
	protected PlayerEntity(){}

	//CONSTRUCTOR
	public PlayerEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		//this.roles = new ArrayList<String>();
		addRol("PLAYER");
		this.nombreCliente = "";
		this.winrate = 0;
	}
	
	public PlayerEntity(String name) {
		this.name = name;
		this.email = "";
		this.passwordHash = "";
		this.nombreCliente = "";
		this.winrate = 0;
		this.status = "FREE";
	}
	
	public PlayerEntity(String name, String email, String password, String nombreCliente, int winrate, String status) {
		super();
		this.name = name;
		this.email = email;
		this.passwordHash = password;
		this.nombreCliente = nombreCliente;
		this.winrate = winrate;
		this.status = status;
	}
	
	public void setTeam(TeamEntity team) {
		this.team = team;
	}
	
	public void leaveTeam() {
		if(this.team == null) {
			return;
		}
		this.team.setAvailable(true);
		this.team = null;
		this.status = "FREE";
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
	
	public String getName() {
		return this.name;
	}
	
	public void addRol(String rol) {
		
		//roles.add(rol);
	}
	
	public List<String> getRoles(){
		//return roles;
		return null;
	}
	
	public boolean isAdmin() {
		//return roles.contains("ADMIN");
		return true;
	}
}
