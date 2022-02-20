package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TeamEntity {
	
	//atributos 
	@Id
	@Column(name="NOMBRE_EQUIPO", length=50, nullable=false, unique=true)
	private String name;
	
	//incluir info del capitan cuando cree jugador
	@Column(name="WINRATE", nullable=false, unique=false)
	private float winrate = 0;
	
	@Column(name="LEMA",length=140, nullable=true, unique=false)
	private String motto;
	
	@Column(name="VICTORIAS_EQUIPO", nullable=false, unique=false)
	private int victorias = 0;
	
	@Column(name="DERROTAS_EQUIPO", nullable=false, unique=false)
	private int derrotas = 0;
	
	@Column(name="KILL_STAT", nullable=false, unique=false)
	private int kills = 0;
	
	@Column(name="DEATHS_STAT", nullable=false, unique=false)
	private int deaths = 0;
	
	@Column(name="ASSIST_STAT", nullable=false, unique=false)
	private int assists = 0;
	
	@OneToMany(mappedBy = "team")
	private List<PlayerEntity> players = new ArrayList<>();
	
	@ManyToOne
	private TournamentEntity tournament;
	
	private boolean available = true;
	
	@Column(name="POINTS")
	private int points = 0;
	
	//constructor
	protected TeamEntity() {}
	
	public TeamEntity(String name, String motto) {
		this.name = name;
		this.winrate = 0;
		this.motto = motto;
		this.victorias = 0;
		this.derrotas = 0;
		this.kills = 0;
		this.deaths = 0;
		this.assists = 0;
	}

	public TeamEntity(String name, float winrate, String motto, int victorias, int derrotas, int kills, int deaths, int assists) {
		this.name = name;
		this.winrate = winrate;
		this.motto = motto;
		this.victorias = victorias;
		this.derrotas = derrotas;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWinrate() {
		return winrate;
	}

	public void setWinrate(float winrate) {
		this.winrate = winrate;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	};
	
	public List<PlayerEntity> getPlayers(){
		return this.players;
	}
	
	public String getMotto() {
		return this.motto;
	}
	
	public void addPlayer(PlayerEntity player) {
		if(this.players.size() >= 5)
			return;
		this.players.add(player);
		player.setStatus("ON TEAM");
		player.setTeam(this);
		
		if(this.players.size() >= 5)
			available = false;
	}
	
	public void removePlayer(PlayerEntity player) {
		this.players.remove(player);
		player.setStatus("FREE");
		player.setTeam(null);
		available = true;
	}
	
	public boolean isAvailable() {
		return this.available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void addPoint() {
		this.points++;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setTournament(TournamentEntity tournament) {
		this.tournament = tournament;
	}
	
	public TournamentEntity getTournament() {
		return this.tournament;
	}
	
	public void leaveTournament() {
		this.tournament = null;
	}
}
