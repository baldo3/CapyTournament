package com.example.demo;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Service;

	@Service
	public class ControlChampion implements CommandLineRunner {

	    @Autowired
	    private ChampionRepository repository;
	    public ControlChampion() {
	    }

	    public void newChampion(String name) {
	        ChampionEntity newChamp= new ChampionEntity(name);
	        repository.save(newChamp);
	    }
	    
	    public List<ChampionEntity> findAllChampions(){
	        List<ChampionEntity> championsList= repository.findAll();
	        return championsList;
	    }
	    
	    public void deleteChampionById(String id){
			repository.deleteById(id);
		}
	    
	    /*public void deleteChampionByName(String name){
			repository.deleteByName(name);
		}*/

	    @Override
	    public void run(String... args) throws Exception {


	    }


	}
