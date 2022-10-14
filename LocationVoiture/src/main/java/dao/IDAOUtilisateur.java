package dao;

import model.Compte;

public interface IDAOUtilisateur extends IDAO<Compte,Integer> {

	public Compte seConnecter(String login,String password);
	
	
}
