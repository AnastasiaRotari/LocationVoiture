package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.sopra.eshop.model.Client;

public interface LoueurRepository extends JpaRepository<Client, Integer>{

}
