package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.AnnonceException;
import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.repository.AnnonceRepository;



@Service
public class AnnonceService {

	@Autowired
	private AnnonceRepository annonceRepo;

	public List<Annonce> findAll() {
		System.out.println(annonceRepo.findAll());
		return annonceRepo.findAll();
	}
	
	public Annonce findByIdFetchModele(Long id) {
		return annonceRepo.findByIdFetchingModele(id).orElseThrow(IdException::new);
	}
	
	public Annonce findByIdFetchLoueur(Long id) {
		return annonceRepo.findByIdFetchingLoueur(id).orElseThrow(IdException::new);
	}

	public Annonce findById(Long id) {
		return annonceRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Annonce> findByLibelle(String libelle) {
		return annonceRepo.findByLibelleContaining(libelle);
	}
	
	public List<Annonce> findByLoueurId(Long id) {
		return annonceRepo.findByLoueurId(id);
	}
	
	public List<Annonce> findByAgence(String agence) {
		return annonceRepo.findByAgenceContaining(agence);
	}
	
	public List<Annonce> findByModeleNomContening(String nom) {
		return annonceRepo.findByModeleNomContaining(nom);
	}
	
	public List<Annonce> findByPrixJour(double prix) {
		return annonceRepo.findByPrixJour(prix);
	}
	
	public List<Annonce> findByDisponibilite(Boolean disponible) {
		return annonceRepo.findByDisponible(disponible);
	}

	public Annonce create(Annonce annonce) {
		if (annonce.getId() != null) {
			throw new AnnonceException("annonce deja dans la base");
		}
		return save(annonce);

	}

	public Annonce update(Annonce annonce) {
		if (annonce.getId() == null || !annonceRepo.existsById(annonce.getId())) {
			throw new IdException();
		}
		return save(annonce);
	}

	public Annonce save(Annonce annonce) {
		if (annonce.getLibelle() == null || annonce.getLibelle().isBlank()) {
			throw new AnnonceException("probleme libelle");
		}
		if (annonce.getModele() == null) {
			throw new AnnonceException("probleme modele");
		}
		if (annonce.getLoueur() == null) {
			throw new AnnonceException("probleme loueur");
		}
		if (annonce.getPlein() == null) {
			throw new AnnonceException("probleme plein");
		}
		if (annonce.getKilometrage() <= 0) {
			throw new AnnonceException("probleme kilometrage");
		}
		if (annonce.getAgence() == null || annonce.getAgence().isBlank()) {
			throw new AnnonceException("probleme agence");
		}
		if (annonce.getEtat() == null) {
			throw new AnnonceException("probleme etat");
		}
		if (annonce.getDisponible() == null) {
			throw new AnnonceException("probleme dispo");
		}
		return annonceRepo.save(annonce);
	}

	public void delete(Annonce annonce) {
		annonceRepo.delete(annonce);
	}

	public void deleteId(Long id) {
		annonceRepo.deleteById(id);
	}
	
	
}
