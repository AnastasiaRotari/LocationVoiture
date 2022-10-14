package model;

import javax.persistence.Entity;

@Entity
public abstract class Utilisateur extends Compte {

	
	public Utilisateur ()
	{
	}
	
	public Utilisateur(String password, String login, String nom, String prenom) {
		super(password, login, nom, prenom);
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", password=" + password + ", login=" + login + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + "]";
	}

}
