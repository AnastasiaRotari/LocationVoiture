package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.exception.ModeleException;
import ajc.sopra.locationVoiture.model.Categorie;
import ajc.sopra.locationVoiture.model.Modele;
import ajc.sopra.locationVoiture.repository.ModeleRepository;



@Service
public class ModeleService {

	@Autowired
	private ModeleRepository modeleRepo;

	public List<Modele> findAll() {
		return modeleRepo.findAll();
	}

	public Modele findById(Integer id) {
		return modeleRepo.findById(id).orElseThrow(()->{
			throw new IdException();
		});
	}

	public List<Modele> findByNom(String nom) {
		return modeleRepo.findByNom(nom);
	}
	
	public List<Modele> findByCategorie(Categorie categorie) {
		return modeleRepo.findByCategorie(categorie);
	}

	public Modele create(Modele modele) {
		if (modele.getId() != null) {
			throw new ModeleException("modele deja dans la base");
		}
		return save(modele);

	}

	public Modele update(Modele modele) {
		if (modele.getId() == null || !modeleRepo.existsById(modele.getId())) {
			throw new IdException();
		}
		return save(modele);
	}

	private Modele save(Modele modele) {
		if (modele.getNom() == null || modele.getNom().isBlank() || modele.getNom().length() > 35) {
			throw new ModeleException("probleme Nom");
		}
		if (modele.getAnnee()==null || modele.getAnnee().length()>4) {
			throw new ModeleException("probleme Annee");
		}
		return modeleRepo.save(modele);
	}

	public void delete(Modele modele) {
		modeleRepo.delete(modele);
	}

	public void deleteById(Integer id) {
		modeleRepo.deleteById(id);
	}
}
