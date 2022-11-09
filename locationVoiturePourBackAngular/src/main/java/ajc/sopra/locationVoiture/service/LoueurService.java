package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.PersonneException;
import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.repository.LoueurRepository;



@Service
public class LoueurService {

	@Autowired
	private LoueurRepository loueurRepo;

	public List<Loueur> findAll() {
		return loueurRepo.findAll();
	}
	
	public Loueur findByIdFetchAnnonce(Integer id) {
		return loueurRepo.findByIdFetchingAnnonce(id).orElseThrow(IdException::new);
	}

	public Loueur findById(Integer id) {
//		return produitRepo.findById(id).orElseThrow(()->{
//			throw new IdException();
//		});
		return loueurRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Loueur> findByAnnonnce(Annonce annonce) {
		return loueurRepo.findByAnnonceContaining(annonce);
	}

	public Loueur create(Loueur loueur) {
		if (loueur.getId() != null) {
			throw new PersonneException("produit deja dans la base");
		}
		return save(loueur);

	}

	public Loueur update(Loueur loueur) {
		if (loueur.getId() == null || !loueurRepo.existsById(loueur.getId())) {
			throw new IdException();
		}
		return save(loueur);
	}

	public Loueur save(Loueur loueur) {
		
		return loueurRepo.save(loueur);
	}

	public void delete(Loueur loueur) {
		loueurRepo.delete(loueur);
	}

	public void deleteId(Integer id) {
		loueurRepo.deleteById(id);
	}
}
