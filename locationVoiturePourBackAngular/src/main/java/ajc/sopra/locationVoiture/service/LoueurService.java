package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.exception.CompteException;
import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Compte;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.repository.CompteRepository;
import ajc.sopra.locationVoiture.repository.LoueurRepository;



@Service
public class LoueurService {

	@Autowired
	private LoueurRepository loueurRepo;
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Loueur> findAll() {
		return loueurRepo.findAll();
	}
	
	public boolean checkEmailExists(String email) {
		return compteRepo.findByEmail(email).isPresent();
	}
	
	
	public Loueur findByIdFetchAnnonce(Long id) {
		return loueurRepo.findByIdFetchingAnnonce(id).orElseThrow(IdException::new);
	}

	public Loueur findById(Long id) {
		return loueurRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Loueur> findByAnnonnce(Annonce annonce) {
		return loueurRepo.findByAnnonceContaining(annonce);
	}

	public Loueur create(Loueur loueur) {
		if (loueur.getId() != null) {
			throw new CompteException("produit deja dans la base");
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
		
		loueur.setPassword(passwordEncoder.encode(loueur.getPassword()));
	
		return loueurRepo.save(loueur);
	}

	public void delete(Loueur loueur) {
		loueurRepo.delete(loueur);
	}

	public void deleteId(Long id) {
		loueurRepo.deleteById(id);
	}
}
