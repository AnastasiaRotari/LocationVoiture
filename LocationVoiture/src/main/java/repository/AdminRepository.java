package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Achat;

public interface AdminRepository extends JpaRepository<Achat, Integer>{

}
