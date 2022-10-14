package model;

import javax.persistence.Entity;


@Entity
public class Admin extends Compte{
	
	
	public Admin() {
	
	
	}


	public Admin(String password, String login, String nom, String prenom) {
		super(password, login, nom, prenom);
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + "]";
	}
	
	
	

}
