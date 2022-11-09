package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, Integer> {
	Compte findByLoginContaining(String login);

	List<Compte> findByNomContaining(String nom);

	List<Compte> findByPrenomContaining(String nom);

	List<Compte> findByAdresseContaining(Adresse adresse);
}
