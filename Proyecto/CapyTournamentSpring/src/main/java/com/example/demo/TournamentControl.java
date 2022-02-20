package com.example.demo;
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Service;

	@Service
	public class TournamentControl implements CommandLineRunner {

	    @Autowired
	    private TournamentRepository repository;
	    public TournamentControl() {
	    }

	    public void newTournament(String name) {
	    	TournamentEntity newTournament = new TournamentEntity(name);
	        repository.save(newTournament);
	    }
	    
	    public void newTournament(TournamentEntity tournament) {
	        repository.save(tournament);
	    }
	    
	    public void joinTournament(TournamentEntity tournament, TeamEntity team) {
	    	tournament.addTeam(team);
	    }
	    
	    public void saveTournament(TournamentEntity tournament) {
	    	repository.save(tournament);
	    }
	    
	    public void leaveTournament(TournamentEntity tournament, TeamEntity team) {
	    	tournament.removeTeam(team);
	    }
	    
	    public List<TournamentEntity> findAllTournaments(){
	        List<TournamentEntity> tournamentsList= repository.findAll();
	        return tournamentsList;
	    }
	    
	    public void deleteTournamentByName(String name){
			repository.deleteByName(name);
		}
	    
	    public TournamentEntity findTournamentByName(String name) {
	     return repository.findByName(name);
	    }
	    
	    public void deleteTournament(TournamentEntity tournament) {
	    	repository.delete(tournament);
	    }

	    @Override
	    public void run(String... args) throws Exception {
	    }


	}
