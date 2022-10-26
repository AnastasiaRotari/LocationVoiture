package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	//List<Produit> findByLibelleContaining(String libelle);
}
