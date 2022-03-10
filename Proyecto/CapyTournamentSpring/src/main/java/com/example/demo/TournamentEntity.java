package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TournamentEntity {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="ID_TORNEO", nullable=false, unique=true)
 private Long id;
 
 @Column(name="NOMBRE_TORNEO", length=50, nullable=false, unique=true)
 private String name;
 
 @OneToMany(mappedBy = "tournament")
	private List<TeamEntity> teams = new ArrayList<>();
 
 protected TournamentEntity() {};

 public TournamentEntity(Long id, String name) {
		this.id = id;
		this.name = name;
 }
 
 public TournamentEntity(String name) {
	 this.name = name;
 }
 
 public TournamentEntity(String name, TeamEntity team1, TeamEntity team2) {
	 this.name = name;
	 this.addTeam(team1);
	 this.addTeam(team2);
 }
 
 public void addTeam(TeamEntity team) {
	 this.teams.add(team);
	 team.setTournament(this);
 }
 
 public void removeTeam(TeamEntity team) {
	 this.teams.remove(team);
 }
 
 public List<TeamEntity> getTeams(){
	 return this.teams;
 }
 
 public String getName() {
	 return this.name;
 }
 
}
