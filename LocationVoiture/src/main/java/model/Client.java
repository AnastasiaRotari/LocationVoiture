package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public  class Client extends Utilisateur {
	
	
	@Column (length = 30, nullable = false)
	private int age;
	
	@Column (length = 50, nullable = false)
	private int anneePermis;
	
	
	private boolean assurance;
	
	@Column (length = 50, nullable = false)
	private Integer accident;
	
	@OneToOne
	private Location location;
	
	public Client (){
	}


	public Client(String password, String login, String nom, String prenom, int age, int anneePermis, boolean assurance, int accident,Location location) {
		super(password, login, nom, prenom);
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


	@Override
	public String toString() {
		return "Client [password=" + password + ", login=" + login + ", id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", age=" + age + ", anneePermis=" + anneePermis + ", assurance="
				+ assurance + ", accident=" + accident + "]";
	}


	
	}
