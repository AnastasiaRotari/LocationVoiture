package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	Utilisateur findByLoginContaining(String login);

	List<Utilisateur> findByNomContaining(String nom);

	List<Utilisateur> findByPrenomContaining(String nom);

	List<Utilisateur> findByAdresseContaining(Adresse adresse);
}
