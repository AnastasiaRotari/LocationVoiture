package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.LocationException;
import model.Client;
import model.Location;
import repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;

	public List<Location> findAll() {
		return locationRepo.findAll();
	}

	public Location findById(Integer id) {
		return locationRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Location> findByClient(Client client) {
		return locationRepo.findByClient(client);
	}
	
	public List<Location> findByDateDebut(LocalDate dateDebut) {
		return locationRepo.findByDateDebut(dateDebut);
	}
	
	public List<Location> findByDateFin(LocalDate dateFin) {
		return locationRepo.findByDateFin(dateFin);
	}

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

	public void deleteId(Integer id) {
		locationRepo.deleteById(id);
	}
}
