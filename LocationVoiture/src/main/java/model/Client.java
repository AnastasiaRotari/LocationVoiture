package model;

public  class Client extends Utilisateur {
	
	private int age;
	private int anneePermis;
	private boolean assurance;
	private int accident;
	

	public Client(String password, String login, Integer id, String nom, String prenom, int age, int anneePermis, boolean assurance, int accident) {
		super(password, login, id, nom, prenom);
		this.age = age;
		this.anneePermis = anneePermis;
		this.assurance = assurance;
		this.accident = accident;
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


	
	}
