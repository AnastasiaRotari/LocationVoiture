package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.exception.LocationException;
import ajc.sopra.locationVoiture.model.Location;
import ajc.sopra.locationVoiture.repository.LocationRepository;



@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;

	public List<Location> findAll() {
		return locationRepo.findAll();
	}

	public Location findById(Long id) {
		return locationRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Location> findByClientId(Long id) {
		return locationRepo.findByClientId(id);
	}
	
	/*public List<Location> findByDateDebut(LocalDate dateDebut) {
		return locationRepo.findByDateDebut(dateDebut);
	}
	
	public List<Location> findByDateFin(LocalDate dateFin) {
		return locationRepo.findByDateFin(dateFin);
	}*/

	public Location create(Location location) {
		if (location.getId() != null) {
			throw new LocationException("produit deja dans la base");
		}
		return save(location);

	}

	public Location update(Location location) {
		if (location.getId() == null || !locationRepo.existsById(location.getId())) {
			throw new IdException();
		}
		return save(location);
	}

	private Location save(Location location) {
		if (location.getDateDebut() == null || location.getDateDebut() == null) {
			throw new LocationException("probleme date");
		}
		if (location.getPrixTotal() <= 0) {
			throw new LocationException("probleme prix total");
		}
		return locationRepo.save(location);
	}

	public void delete(Location location) {
		locationRepo.delete(location);
	}

	public void deleteId(Long id) {
		locationRepo.deleteById(id);
	}
}
