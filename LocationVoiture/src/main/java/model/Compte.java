package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('Admin','Loueur','Client')")
@Table(name="compte")
public abstract class Compte {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 100,nullable = false)
	protected String password;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35,nullable = false,unique=true)
	protected String login;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35,nullable = false)
	protected String nom;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35,nullable = false)
	protected String prenom;
	
	@JsonView(JsonViews.Common.class)
	@Column(length = 35)
	protected Adresse adresse;
	
	public Compte() {
	}
	
	
	
	public Compte(String password, String login, String nom, String prenom) {
		super();
		this.password = password;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
	public Compte(String password, String login, String nom, String prenom, Adresse adresse) {
		super();
		this.password = password;
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	


}
