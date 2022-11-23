package ajc.sopra.locationVoiture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.model.Loueur;




public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
	List<Client> findByAgeContaining(int age);
	List<Client> findByAnneePermisContaining(int AnneePermis);
	List<Client> findByAccidentContaining(int accident);
	

	@Query("select c from Client c left join fetch c.location where c.id=:id")
	Optional<Client> findByIdFetchingLocation(@Param("id") Long id);

	
}
