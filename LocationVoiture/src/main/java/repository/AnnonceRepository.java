package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Annonce;
import model.Loueur;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{
	List<Annonce> findByLibelleContaining(String libelle);
	List<Annonce> findByLoueurContaining(Loueur loueur);
	List<Annonce> findByAgenceContaining(String agence);
}
