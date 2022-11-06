package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Annonce {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name="libelle")
	private String libelle;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne
	@JoinColumn(name="modele")
	private Modele modele;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne
	@JoinColumn(name="loueur")
	private Loueur loueur;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('vide','quart','moitie','trois-quart','rempli')")
	private Plein plein;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="kilometrage",nullable = false,length = 7)
	private int kilometrage;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="agence",length = 35)
	private String agence;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('mint','nearMint','excellent','fine','good','played','poor')")
	private Etat etat;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="prixJour",length = 35)
	private double prixJour; 
	
	@JsonView(JsonViews.Common.class)
	private Boolean disponible;
	
	
	
	public Annonce(String libelle, Modele modele, Loueur loueur, Plein plein, int kilometrage, String agence, Etat etat,
			double prixJour, Boolean disponible) {
		super();
		this.libelle = libelle;
		this.modele = modele;
		this.loueur = loueur;
		this.plein = plein;
		this.kilometrage = kilometrage;
		this.agence = agence;
		this.etat = etat;
		this.prixJour = prixJour;
		this.disponible = disponible;
	}

	public Annonce() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
		
	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Plein getPlein() {
		return plein;
	}

	public void setPlein(Plein plein) {
		this.plein = plein;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Loueur getLoueur() {
		return loueur;
	}

	public void setLoueur(Loueur loueur) {
		this.loueur = loueur;
	}

	@Override
	public String toString() {
		return "Annonce [modele=" + modele + ", plein=" + plein + ", kilometrage=" + kilometrage + ", agence=" + agence
				+ ", etat=" + etat + ", disponible=" + disponible + "]";
	}
	
	


}
