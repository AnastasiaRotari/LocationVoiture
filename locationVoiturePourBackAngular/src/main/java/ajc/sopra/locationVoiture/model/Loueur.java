package ajc.sopra.locationVoiture.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Loueur extends Compte {

	
	@OneToMany(mappedBy = "loueur")
	private List<Annonce> annonce;


	public Loueur() {
	}

	public Loueur(List<Annonce> annonce) {
		this.annonce = annonce;
	}

	public Loueur(Long id, @NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse,
			List<Annonce> annonce) {
		super(id, email, password, nom, prenom, adresse);
		this.annonce = annonce;
		
	}

	public Loueur(@NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse,
			List<Annonce> annonce) {
		super(email, password, nom, prenom, adresse);
		this.annonce = annonce;
		
	}



	public List<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(List<Annonce> annonce) {
		this.annonce = annonce;
	}

	@Override
	public String toString() {
		return "Loueur [annonce=" + annonce + "]";
	}



	
}
