package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Personne;

public interface ModeleRepository extends JpaRepository<Personne, Integer> {

}
