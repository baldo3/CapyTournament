package Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository <TeamEntity,String>{
	List<TeamEntity> findByNombre(String nombre);
}
