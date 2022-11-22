package ajc.sopra.locationVoiture.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Location;




public interface LocationRepository extends JpaRepository<Location, Long>{

	List<Location> findByClientId(Long id);
	
	List<Location> findByDateDebut(LocalDate dateDebut);
	
	List<Location> findByDateFin(LocalDate dateFin);
}
