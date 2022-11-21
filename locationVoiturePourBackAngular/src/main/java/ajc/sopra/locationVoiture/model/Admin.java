package ajc.sopra.locationVoiture.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Admin extends Compte{
	
	
	public Admin() {
	
	}

	public Admin(Long id, @NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse
			) {
		super(id, email, password, nom, prenom, adresse);
		
	}

	public Admin(@NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse
			) {
		super(email, password, nom, prenom, adresse);
		
	}

	@Override
	public String toString() {
		return "Admin [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

	

	

}
