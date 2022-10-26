package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Fournisseur;

public interface CompteRepository extends JpaRepository<Fournisseur, Integer>{

}
