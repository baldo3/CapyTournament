package com.example.demo;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	
	@Autowired
    private ChampionControl championControl;
	
	@Autowired
    private TeamControl teamControl;
	
	@Autowired
    private PlayerControl playerControl;
	
	@Autowired
	private TournamentControl tournamentControl;
	
	@GetMapping("/home")
    public String sayHello(Model model, HttpSession session) {
		String homeText = new String("CapyTournament es tu herramienta de creación de torneos, de amateurs para amateurs.\r\n"
				+ "¡Crea tu equipo, inscríbete a un torneo y compite!");
    	model.addAttribute("sectionName", "Inicio");
    	model.addAttribute("description", homeText);
    	model.addAttribute("hasDescription", true);
    	model.addAttribute("hasImage", true);
    	
    	Optional<PlayerEntity> player = playerControl.findPlayerById("Usuario");
    	if(player.isPresent()) {
    		session.setAttribute("CurrentUser", player.get());
    	}    	
    	return "list_template";
    }
	
	@PostConstruct
    public void init() {
		playerControl.newPlayer("Usuario");
		
		PlayerEntity player;
		TeamEntity team;
		TeamEntity team2;
		TournamentEntity tournament;
		
		//tournament = new TournamentEntity("Copa pistón");
		//tournamentControl.newTournament(tournament);
		
		team = new TeamEntity("Los Gatos Gordos", "Miau, miau...");
		teamControl.newTeam(team);
		
		player = new PlayerEntity("BaldoRA");
		teamControl.joinTeam(team, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("ClaudiaRA");
		teamControl.joinTeam(team, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("JaviJo");
		teamControl.joinTeam(team, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Cpabe");
		teamControl.joinTeam(team, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Pol");
		teamControl.joinTeam(team, player);
		playerControl.newPlayer(player);
		
		teamControl.saveTeam(team);
		//tournamentControl.joinTournament(tournament, team);
		
		team2 = new TeamEntity("Los Capybaras", "Somos todos amigos");
		teamControl.newTeam(team2);
		
		player = new PlayerEntity("System");
		teamControl.joinTeam(team2, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Rick");
		teamControl.joinTeam(team2, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Jax11");
		teamControl.joinTeam(team2, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Nahuel");
		teamControl.joinTeam(team2, player);
		playerControl.newPlayer(player);
		
		player = new PlayerEntity("Eduardo");
		teamControl.joinTeam(team2, player);
		playerControl.newPlayer(player);
		
		teamControl.newTeam(team2);
		
		tournament = new TournamentEntity("Copa pistón", team, team2);
		System.out.println("1.- Tournament: " + tournament.getName() + "| teams: " + tournament.getTeams());
		tournamentControl.saveTournament(tournament);
		
		teamControl.newTeam(team);
		teamControl.newTeam(team2);
		tournamentControl.newTournament(tournament);
		//tournamentControl.joinTournament(tournament, team);
		//System.out.println("1.- Tournament: " + tournament.getName() + "| teams: " + tournament.getTeams());
		//tournamentControl.saveTournament(tournament);
		//tournament = tournamentControl.findTournamentByName("Copa pistón");
		//System.out.println("2.- Tournament: " + tournament.getName() + "| teams: "  + tournament.getTeams());
		
        teamControl.newTeam("Noche Fuerte", "A partir de las 3am se juega mejor");
		
		championControl.newChampion("Aatrox");
        championControl.newChampion("Ahri");
        championControl.newChampion("Akali");
        championControl.newChampion("Akshan");
        championControl.newChampion("Alistar");
        championControl.newChampion("Amumu");
        
        tournamentControl.newTournament("Superliga Blue");
	}
	
}