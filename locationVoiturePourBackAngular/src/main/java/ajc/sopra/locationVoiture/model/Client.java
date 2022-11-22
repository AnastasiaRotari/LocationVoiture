package ajc.sopra.locationVoiture.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Client extends Compte {

	@JsonView(JsonViews.Common.class)
	@Column (length = 30)
	private Integer age;

	@JsonView(JsonViews.Common.class)
	@Column (length = 50)
	private int anneePermis;

	@JsonView(JsonViews.Common.class)
	@Column (length = 50)
	private Integer accident;

	@OneToMany(mappedBy = "client")
	private List<Location> location;
	

	public Client (){
	}

	public Client(Long id, @NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse,
			Integer age, int anneePermis, Integer accident, List<Location> location) {
		super(id, email, password, nom, prenom, adresse);
		this.age = age;
		this.anneePermis = anneePermis;
		this.accident = accident;
		this.location = location;
	}


	public Client(@NotBlank @Email String email, String password, String nom, String prenom, Adresse adresse,
			 Integer age, int anneePermis, Integer accident, List<Location> location) {
		super(email, password, nom, prenom, adresse);
		this.age = age;
		this.anneePermis = anneePermis;
		this.accident = accident;
		this.location = location;
	}

	public Client(Integer age, int anneePermis, Integer accident, List<Location> location) {
	
		this.age = age;
		this.anneePermis = anneePermis;
		this.accident = accident;
		this.location = location;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
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

	

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAnneePermis(int anneePermis) {
		this.anneePermis = anneePermis;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", anneePermis=" + anneePermis + ", accident=" + accident + ", location="
				+ location + "]";
	}


}
