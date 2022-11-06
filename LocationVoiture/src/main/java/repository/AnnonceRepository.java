package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Annonce;
import model.Loueur;
import model.Modele;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{
	List<Annonce> findByLibelleContaining(String libelle);
	List<Annonce> findByLoueurContaining(Loueur loueur);
	List<Annonce> findByAgenceContaining(String agence);
	
	List<Annonce> findByModeleContaining(Modele modele);
	List<Annonce> findByPrixJourContaining(double prix);
	List<Annonce> findByDisponibleContaining(Boolean disponible);
	
}
