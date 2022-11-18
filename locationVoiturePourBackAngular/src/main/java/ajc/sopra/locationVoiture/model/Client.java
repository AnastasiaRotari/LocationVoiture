package ajc.sopra.locationVoiture.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Client extends Personne {

	@JsonView(JsonViews.Common.class)
	@Column (length = 30)
	private Integer age;

	@JsonView(JsonViews.Common.class)
	@Column (length = 50)
	private int anneePermis;

	@JsonView(JsonViews.Common.class)
	private boolean assurance;

	@JsonView(JsonViews.Common.class)
	@Column (length = 50)
	private Integer accident;

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "client")
	private List<Location> location;
	
	@OneToOne
	private Compte compte;

	public Client (){
	}
	
	public Client(Integer id, String nom, String prenom, Adresse adresse, Integer age, int anneePermis,
			boolean assurance, Integer accident, List<Location> location) {
		super(id, nom, prenom, adresse);
		this.age = age;
		this.anneePermis = anneePermis;
		this.assurance = assurance;
		this.accident = accident;
		this.location = location;
	}
	
	public Client(String nom, String prenom, Adresse adresse, Integer age, int anneePermis, boolean assurance,
			Integer accident, List<Location> location) {
		super(nom, prenom, adresse);
		this.age = age;
		this.anneePermis = anneePermis;
		this.assurance = assurance;
		this.accident = accident;
		this.location = location;
	}
	
	public Client(String nom, String prenom, Integer age, int anneePermis, boolean assurance, Integer accident,
			List<Location> location) {
		super(nom, prenom);
		this.age = age;
		this.anneePermis = anneePermis;
		this.assurance = assurance;
		this.accident = accident;
		this.location = location;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isAssurance() {
		return assurance;
	}


	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}


	public Integer getAccident() {
		return accident;
	}


	public void setAccident(Integer accident) {
		this.accident = accident;
	}


	public int getAnneePermis() {
		return anneePermis;
	}

	
	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAnneePermis(int anneePermis) {
		this.anneePermis = anneePermis;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", anneePermis=" + anneePermis + ", assurance=" + assurance + ", accident="
				+ accident + ", location=" + location + ", compte=" + compte + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + ", adresse=" + adresse + ", getAge()=" + getAge() + ", isAssurance()="
				+ isAssurance() + ", getAccident()=" + getAccident() + ", getAnneePermis()=" + getAnneePermis()
				+ ", getLocation()=" + getLocation() + ", getCompte()=" + getCompte() + ", toString()="
				+ super.toString() + ", getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom()
				+ ", getAdresse()=" + getAdresse() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}



}
