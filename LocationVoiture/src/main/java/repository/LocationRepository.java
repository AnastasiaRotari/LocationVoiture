package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Client;
import model.Location;



public interface LocationRepository extends JpaRepository<Location, Integer>{

	List<Location> findByClient(Client client);
	
	List<Location> findByDateDebut(LocalDate dateDebut);
	
	List<Location> findByDateFin(LocalDate dateFin);
}
