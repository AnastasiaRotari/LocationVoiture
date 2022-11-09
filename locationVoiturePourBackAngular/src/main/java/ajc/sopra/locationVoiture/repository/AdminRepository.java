package ajc.sopra.locationVoiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Admin;
import ajc.sopra.locationVoiture.model.Adresse;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByLoginContaining(String login);

	List<Admin> findByNomContaining(String nom);

	List<Admin> findByPrenomContaining(String prenom);

	List<Admin> findByAdresseContaining(Adresse adresse);
}
