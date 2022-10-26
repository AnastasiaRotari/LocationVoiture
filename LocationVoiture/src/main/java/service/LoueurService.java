package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdException;
import exception.LoueurException;
import model.Annonce;
import model.Loueur;
import repository.LoueurRepository;

@Service
public class LoueurService {

	@Autowired
	private LoueurRepository loueurRepo;

	public List<Loueur> findAll() {
		return loueurRepo.findAll();
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

	/*private Loueur save(Loueur loueur) {
		if (produit.getLibelle() == null || produit.getLibelle().isBlank() || produit.getLibelle().length() > 30) {
			throw new CompteException("probleme libelle");
		}
		if (produit.getPrix() <= 0) {
			throw new CompteException("probleme prix");
		}
		return produitRepo.save(produit);
	}
*/
	public void delete(Loueur loueur) {
		loueurRepo.delete(loueur);
	}

	public void deleteId(Integer id) {
		loueurRepo.deleteById(id);
	}
}
