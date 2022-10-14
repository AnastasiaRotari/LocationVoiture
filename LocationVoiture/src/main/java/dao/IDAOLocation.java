package dao;

import model.Compte;

public interface IDAOLocation extends IDAO<Compte,Integer> {

	public Compte seConnecter(String login,String password);
	
	
}
