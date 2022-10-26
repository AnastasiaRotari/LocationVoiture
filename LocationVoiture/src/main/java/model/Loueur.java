package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Loueur extends Utilisateur {

@OneToOne	
private Annonce annonce;


public Loueur() {	
}


public Loueur(String password, String login, String nom, String prenom, Annonce annonce) {
		super(password, login, nom, prenom);
		this.annonce = annonce; 
	}


public Annonce getAnnonce() {
	return annonce;
}


public void setVoiture(Annonce annonce) {
	this.annonce = annonce;
}

}
