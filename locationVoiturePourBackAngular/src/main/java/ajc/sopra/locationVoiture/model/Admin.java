package ajc.sopra.locationVoiture.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Admin extends Personne{
	
	@OneToOne
	private Compte compte;
	
	public Admin() {
	
	}

	public Admin(Integer id, String nom, String prenom, Adresse adresse) {
		super(id, nom, prenom, adresse);
	}

	public Admin(String nom, String prenom, Adresse adresse) {
		super(nom, prenom, adresse);
	}

	public Admin(String nom, String prenom) {
		super(nom, prenom);
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Admin [compte=" + compte + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", getCompte()=" + getCompte() + ", getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getAdresse()=" + getAdresse() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


}
