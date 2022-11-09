package ajc.sopra.locationVoiture.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByEmail(String email);
}
