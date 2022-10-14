package model;

public abstract class Utilisateur extends Compte {

	public Utilisateur(String password, String login, Integer id, String nom, String prenom) {
		super(password, login, id, nom, prenom);
	}

}
