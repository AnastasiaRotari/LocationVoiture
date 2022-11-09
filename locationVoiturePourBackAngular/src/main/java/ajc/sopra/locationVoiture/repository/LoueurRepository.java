package ajc.sopra.locationVoiture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Loueur;



public interface LoueurRepository extends JpaRepository<Loueur, Integer>{
	
	
	List<Loueur> findByAnnonceContaining(Annonce annonce);
	
	@Query("select l from Loueur l left join fetch l.annonce where l.id=:id")
	Optional<Loueur> findByIdFetchingAnnonce(@Param("id") Integer id);

	
	
}
