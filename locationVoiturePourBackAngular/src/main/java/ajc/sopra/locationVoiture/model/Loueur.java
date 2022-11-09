package ajc.sopra.locationVoiture.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Loueur extends Utilisateur {

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "loueur")
	private List<Annonce> annonce;
	
	@OneToOne
	private Compte compte;

	public Loueur() {
	}

	public Loueur(List<Annonce> annonce) {
		this.annonce = annonce;
	}

	public Loueur(String nom, String prenom, List<Annonce> annonce) {
		super(nom, prenom);
		this.annonce = annonce;
	}

	public Loueur(String nom, String prenom, Adresse adresse, List<Annonce> annonce) {
		super(nom, prenom, adresse);
		this.annonce = annonce;
	}

	public Loueur(Integer id, String nom, String prenom, Adresse adresse, List<Annonce> annonce) {
		super(id, nom, prenom, adresse);
		this.annonce = annonce;
	}

	public List<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(List<Annonce> annonce) {
		this.annonce = annonce;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Loueur [annonce=" + annonce + ", compte=" + compte + ", id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", getAnnonce()=" + getAnnonce() + ", getCompte()=" + getCompte()
				+ ", toString()=" + super.toString() + ", getId()=" + getId() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getAdresse()=" + getAdresse() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
