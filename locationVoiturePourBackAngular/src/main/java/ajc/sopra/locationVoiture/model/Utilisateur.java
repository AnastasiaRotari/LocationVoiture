package ajc.sopra.locationVoiture.model;

import javax.persistence.Entity;

@Entity
public abstract class Utilisateur extends Personne {

	
	public Utilisateur ()
	{
	}
	
	public Utilisateur(Integer id, String nom, String prenom, Adresse adresse) {
		super(id, nom, prenom, adresse);
	}

	public Utilisateur(String nom, String prenom, Adresse adresse) {
		super(nom, prenom, adresse);
	}

	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", getId()="
				+ getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
