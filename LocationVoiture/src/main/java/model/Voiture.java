package model;

public class Voiture {
	private Integer id;
	private String nom;
	private Categorie categorie;
	private int annee;
	private Plein plein;
	private int kilometrage;
	private String agence;
	private Etat etat;
	private Boolean disponible;
	
	public Voiture(Integer id, String nom, Categorie categorie, int annee, Plein plein, int kilometrage, String agence,
			Etat etat, Boolean disponible) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.annee = annee;
		this.plein = plein;
		this.kilometrage = kilometrage;
		this.agence = agence;
		this.etat = etat;
		this.disponible = disponible;
	}


}
