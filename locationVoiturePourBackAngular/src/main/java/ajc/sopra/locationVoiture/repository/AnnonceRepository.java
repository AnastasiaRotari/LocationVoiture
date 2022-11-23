package ajc.sopra.locationVoiture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Loueur;



public interface AnnonceRepository extends JpaRepository<Annonce, Long>{
	List<Annonce> findByLibelleContaining(String libelle);
	List<Annonce> findByLoueurId(Long id);
	List<Annonce> findByAgenceContaining(String agence);
	
	List<Annonce> findByModeleNomContaining(String nom);
	List<Annonce> findByPrixJour(double prix);
	List<Annonce> findByDisponible(Boolean disponible);
	
	@Query("select a from Annonce a right join fetch a.modele where a.id=:id")
	Optional<Annonce> findByIdFetchingModele(@Param("id") Long id);
	
	@Query("select a from Annonce a right join fetch a.loueur where a.id=:id")
	Optional<Annonce> findByIdFetchingLoueur(@Param("id") Long id);
}
