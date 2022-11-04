package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.Annonce;
import model.Loueur;


public interface LoueurRepository extends JpaRepository<Loueur, Integer>{
	
	
	List<Loueur> findByAnnonceContaining(Annonce annonce);

	
	
}
