package ajc.sopra.locationVoiture.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.locationVoiture.model.Categorie;
import ajc.sopra.locationVoiture.model.Modele;


public interface ModeleRepository extends JpaRepository<Modele, Integer> {

	List<Modele> findByNom(String Nom);
	List<Modele> findByCategorie(Categorie categorie);
}
