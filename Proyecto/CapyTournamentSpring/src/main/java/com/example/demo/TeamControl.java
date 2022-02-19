package com.example.demo;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Service;

	@Service
	public class TeamControl implements CommandLineRunner {

	    @Autowired
	    private TeamRepository repository;
	    public TeamControl() {
	    }

	    public void newTeam(String name, String motto) {
	        TeamEntity newTeam = new TeamEntity(name, 0, motto, 0, 0, 0, 0, 0);
	        //Añadir al jugador actual como capitán
	        repository.save(newTeam);
	    }
	    
	    public void newTeam(TeamEntity team) {
	        repository.save(team);
	    }
	    
	    public void joinTeam(TeamEntity team, PlayerEntity player) {
	    	team.addPlayer(player);
	    }
	    
	    public void leaveTeam(TeamEntity team, PlayerEntity player) {
	    	team.removePlayer(player);
	    }
	    
	    public List<TeamEntity> findAllTeams(){
	        List<TeamEntity> teamsList= repository.findAll();
	        return teamsList;
	    }
	    
	    public void deleteTeamById(String id){
			repository.deleteById(id);
		}
	    
	    public Optional<TeamEntity> findTeamById(String id) {
	     return repository.findById(id);
	    }
	    
	    //public Player

	    @Override
	    public void run(String... args) throws Exception {


	    }


	}
