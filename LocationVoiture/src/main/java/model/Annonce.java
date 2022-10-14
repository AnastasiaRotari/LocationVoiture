package model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Annonce {
	
	@OneToOne
	@JoinColumn(name="modele")
	private Modele modele;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('vide','quart','moitie','trois-quart','rempli')")
	private Plein plein;
	
	@Column(name="kilometrage",nullable = false,length = 7)
	private int kilometrage;
	
	@Column(name="agence",length = 35)
	private String agence;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('mint','nearMint','excellent','fine','good','played','poor')")
	private Etat etat;
	
	
	private Boolean disponible;
	
	public Annonce(Modele modele, Plein plein, int kilometrage, String agence,
			Etat etat, Boolean disponible) {
		super();
		this.plein = plein;
		this.kilometrage = kilometrage;
		this.agence = agence;
		this.etat = etat;
		this.disponible = disponible;
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

	@Override
	public String toString() {
		return "Annonce [modele=" + modele + ", plein=" + plein + ", kilometrage=" + kilometrage + ", agence=" + agence
				+ ", etat=" + etat + ", disponible=" + disponible + "]";
	}
	
	


}
