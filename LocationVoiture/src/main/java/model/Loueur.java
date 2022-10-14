package model;

public class Loueur extends Utilisateur {

private Annonce voiture;


public Loueur(String password, String login, Integer id, String nom, String prenom, Annonce voiture) {
		super(password, login, id, nom, prenom);
		this.voiture = voiture; 
	}


public Annonce getVoiture() {
	return voiture;
}


public void setVoiture(Annonce voiture) {
	this.voiture = voiture;
}

}
