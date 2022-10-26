package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompteException;
import exception.IdException;
import model.Adresse;
import model.Compte;
import repository.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;

	public List<Compte> findAll() {
		return compteRepo.findAll();
	}

	public Compte findById(Integer id) {
		return compteRepo.findById(id).orElseThrow(IdException::new);
	}

	public Compte findByLogin(String login) {
		return compteRepo.findByLoginContaining(login);
	}
	
	public List<Compte> findByNom(String nom) {
		return compteRepo.findByNomContaining(nom);
	}
	
	public List<Compte> findByPrenom(String prenom) {
		return compteRepo.findByPrenomContaining(prenom);
	}
	
	public List<Compte> findByAdresse(Adresse adresse) {
		return compteRepo.findByAdresseContaining(adresse);
	}

	public Compte create(Compte compte) {
		if (compte.getId() != null) {
			throw new CompteException("produit deja dans la base");
		}
		return save(compte);

	}

	public Compte update(Compte compte) {
		if (compte.getId() == null || !compteRepo.existsById(compte.getId())) {
			throw new IdException();
		}
		return save(compte);
	}

	private Compte save(Compte compte) {
		if (compte.getLogin() == null || compte.getLogin().isBlank() || compte.getLogin().length() > 35) {
			throw new CompteException("probleme login");
		}
		if (compte.getPassword() == null || compte.getPassword().isBlank() || compte.getPassword().length() > 35) {
			throw new CompteException("probleme password");
		}
		if (compte.getNom() == null || compte.getNom().isBlank() || compte.getNom().length() > 35) {
			throw new CompteException("probleme nom");
		}
		if (compte.getPrenom() == null || compte.getPrenom().isBlank() || compte.getPrenom().length() > 35) {
			throw new CompteException("probleme prenom");
		}
		
		return compteRepo.save(compte);
	}

	public void delete(Compte produit) {
		compteRepo.delete(produit);
	}

	public void deleteId(Integer id) {
		compteRepo.deleteById(id);
	}
}
