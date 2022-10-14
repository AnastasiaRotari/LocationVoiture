package dao;

import model.Compte;

public interface IDAOAnnonce extends IDAO<Compte,Integer> {

	public Compte seConnecter(String login,String password);
	
	
}
