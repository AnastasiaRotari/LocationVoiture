package model;

public class Loueur extends Utilisateur {

private Voiture voiture;


public Loueur(String password, String login, Integer id, String nom, String prenom, Voiture voiture) {
		super(password, login, id, nom, prenom);
		this.voiture = voiture; 
	}


public Voiture getVoiture() {
	return voiture;
}


public void setVoiture(Voiture voiture) {
	this.voiture = voiture;
}

}
