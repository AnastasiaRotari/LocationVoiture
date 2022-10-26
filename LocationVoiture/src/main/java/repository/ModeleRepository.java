package repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Categorie;
import model.Modele;

public interface ModeleRepository extends JpaRepository<Modele, Integer> {

	List<Modele> findByNom(String Nom);
	List<Modele> findByCategorie(Categorie categorie);
}
