package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Adresse;
import model.Compte;
import model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	Utilisateur findByLoginContaining(String login);

	List<Utilisateur> findByNomContaining(String nom);

	List<Utilisateur> findByPrenomContaining(String nom);

	List<Utilisateur> findByAdresseContaining(Adresse adresse);
}
