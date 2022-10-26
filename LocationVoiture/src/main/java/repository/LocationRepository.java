package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Achat;

public interface LocationRepository extends JpaRepository<Achat, Integer>{

}
