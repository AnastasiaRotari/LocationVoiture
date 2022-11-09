package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Client;




public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	
	List<Client> findByAgeContaining(int age);
	List<Client> findByAnneePermisContaining(int AnneePermis);
	List<Client> findByAccidentContaining(int accident);
	List<Client> findByAssuranceContaining(boolean Assurance);
	
	
}