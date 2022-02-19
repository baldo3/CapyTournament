/*package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class GameEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GAME", nullable=false, unique=true)
	private Long id; 
	
	@Column(name="GAME_DATE", nullable=false, unique=false)
	private LocalDate fecha;
	
	@Column(name="GAME_STATE", nullable=false, unique=false)
	private String estado;
	
	@ManyToOne
	private TournamentEntity torneo;
	
	@OneToMany
	private List<TeamEntity> teams;
	
	protected GameEntity(){}

	public GameEntity(Long id, LocalDate fecha, String estado, TournamentEntity torneo, List<TeamEntity> teams) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.torneo = torneo;
		this.teams = teams;
	}
	
	
	
	
	
}*/
