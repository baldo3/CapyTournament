package com.example.demo;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Service;

	@Service
	public class ChampionControl implements CommandLineRunner {

	    @Autowired
	    private ChampionRepository repository;
	    public ChampionControl() {
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

	    @Override
	    public void run(String... args) throws Exception {


	    }


	}
