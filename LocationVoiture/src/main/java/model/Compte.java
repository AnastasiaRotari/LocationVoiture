package model;


public abstract class Compte {
	
	protected String password;
	protected String login;
	protected Integer id;
	protected String nom;
	protected String prenom;
	protected Adresse adresse;
	
	public Compte(String password, String login, Integer id, String nom, String prenom) {
		super();
		this.password = password;
		this.login = login;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	


}
