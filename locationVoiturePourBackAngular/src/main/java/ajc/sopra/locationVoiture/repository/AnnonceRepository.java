package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Annonce;



public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{
	List<Annonce> findByLibelleContaining(String libelle);
	List<Annonce> findByLoueurId(Integer id);
	List<Annonce> findByAgenceContaining(String agence);
	
	List<Annonce> findByModeleNomContaining(String nom);
	List<Annonce> findByPrixJour(double prix);
	List<Annonce> findByDisponible(Boolean disponible);
	
}
