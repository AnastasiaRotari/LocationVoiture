package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;
import model.Adresse;
import model.Compte;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByLoginContaining(String login);

	List<Admin> findByNomContaining(String nom);

	List<Admin> findByPrenomContaining(String nom);

	List<Admin> findByAdresseContaining(Adresse adresse);
}
