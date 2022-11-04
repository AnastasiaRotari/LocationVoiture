package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	
	List<Client> findByAgeContaining(int age);
	List<Client> findByAnneePermisContaining(int AnneePermis);
	List<Client> findByAccidentContaining(int accident);
	List<Client> findByAssuranceContaining(boolean Assurance);
	
	
}
