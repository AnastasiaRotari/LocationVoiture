package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Personne;


public interface PersonneRepository extends JpaRepository<Personne, Integer> {
	Personne findByLoginContaining(String login);

	List<Personne> findByNomContaining(String nom);

	List<Personne> findByPrenomContaining(String nom);

	List<Personne> findByAdresseContaining(Adresse adresse);
}
