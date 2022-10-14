package dao;

import model.Compte;

public interface IDAOModele extends IDAO<Compte,Integer> {

	public Compte seConnecter(String login,String password);
	
	
}
