package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Loueur extends Utilisateur {

@OneToOne	
private Annonce voiture;


public Loueur() {	
}


public Loueur(String password, String login, String nom, String prenom, Annonce voiture) {
		super(password, login, nom, prenom);
		this.voiture = voiture; 
	}


public Annonce getVoiture() {
	return voiture;
}


public void setVoiture(Annonce voiture) {
	this.voiture = voiture;
}

}
