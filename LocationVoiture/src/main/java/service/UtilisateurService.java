package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompteException;
import exception.IdException;
import model.Adresse;
import model.Compte;
import model.Utilisateur;
import repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	public List<Utilisateur> findAll() {
		return utilisateurRepo.findAll();
	}

	public Utilisateur findById(Integer id) {
		return utilisateurRepo.findById(id).orElseThrow(IdException::new);
	}

	
	public Utilisateur findByLogin(String login) {
		return utilisateurRepo.findByLoginContaining(login);
	}
	
	public List<Utilisateur> findByNom(String nom) {
		return utilisateurRepo.findByNomContaining(nom);
	}
	
	public List<Utilisateur> findByPrenom(String prenom) {
		return utilisateurRepo.findByPrenomContaining(prenom);
	}
	
	public List<Utilisateur> findByAdresse(Adresse adresse) {
		return utilisateurRepo.findByAdresseContaining(adresse);
	}
	

	public Utilisateur create(Utilisateur utilisateur) {
		if (utilisateur.getId() != null) {
			throw new CompteException("produit deja dans la base");
		}
		return save(utilisateur);

	}

	public Utilisateur update(Utilisateur utilisateur) {
		if (utilisateur.getId() == null || !utilisateurRepo.existsById(utilisateur.getId())) {
			throw new IdException();
		}
		return save(utilisateur);
	}

	private Utilisateur save(Utilisateur utilisateur) {
		if (utilisateur.getLogin() == null || utilisateur.getLogin().isBlank() || utilisateur.getLogin().length() > 35) {
			throw new CompteException("probleme login");
		}
		if (utilisateur.getPassword() == null || utilisateur.getPassword().isBlank() || utilisateur.getPassword().length() > 35) {
			throw new CompteException("probleme password");
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isBlank() || utilisateur.getNom().length() > 35) {
			throw new CompteException("probleme nom");
		}
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isBlank() || utilisateur.getPrenom().length() > 35) {
			throw new CompteException("probleme prenom");
		}
		return utilisateurRepo.save(utilisateur);
	}

	public void delete(Utilisateur utilisateur) {
		utilisateurRepo.delete(utilisateur);
	}

	public void deleteId(Integer id) {
		utilisateurRepo.deleteById(id);
	}
}
