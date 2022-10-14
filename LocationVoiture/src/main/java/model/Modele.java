package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modele {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom",nullable = false, length = 35)
	private String nom;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Berline','Familliale','Sportive','Utilitaire','Citadine')")
	private Categorie categorie;
	
	@Column(name="annee",nullable = false, length = 4)
	private int annee;
	
	public Modele() {
	}
	
	
	public Modele(String nom, Categorie categorie, int annee) {
		this.nom = nom;
		this.categorie = categorie;
		this.annee = annee;
	}
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	@Override
	public String toString() {
		return "Modele [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", annee=" + annee + "]";
	}
	
	
}
