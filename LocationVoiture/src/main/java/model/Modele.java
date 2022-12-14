package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

import model.JsonViews;

@Entity
public class Modele {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="nom",nullable = false, length = 35)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('berline','familliale','sportive','utilitaire','citadine')")
	private Categorie categorie;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="annee",nullable = false, length = 4)
	private String annee;
	
	public Modele() {
	}
	
	
	
	
	public Modele(String nom, Categorie categorie, String annee) {
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
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	
	@Override
	public String toString() {
		return "Modele [id=" + id + ", nom=" + nom + ", categorie=" + categorie + ", annee=" + annee + "]";
	}
	
	
}
