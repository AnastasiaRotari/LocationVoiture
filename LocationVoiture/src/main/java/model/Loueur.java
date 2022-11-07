package model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Loueur extends Utilisateur {

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "loueur")
	private List<Annonce> annonce;

	public Loueur() {
	}

	
	
	

	public Loueur(String password, String login, String nom, String prenom, List<Annonce> annonce) {
		super(password, login, nom, prenom);
		this.annonce = annonce;
	}





	public Loueur(String password, String login, String nom, String prenom, Adresse adresse, List<Annonce> annonce) {
		super(password, login, nom, prenom, adresse);
		this.annonce = annonce;
	}





	public List<Annonce> getAnnonce() {
		return annonce;
	}





	public void setAnnonce(List<Annonce> annonce) {
		this.annonce = annonce;
	}





	

}
