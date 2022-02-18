package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.TorneoEntity;

@Repository
public interface TorneoRepository extends JpaRepository <TorneoEntity, Long> {

}
