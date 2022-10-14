package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.jpa.DAOCompte;


public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	
	private IDAOCompte daoCompte = new DAOCompte();
	
	
	
	private static Context singleton=null;


	
	private Context() {}
	

	public static Context getSingleton() {
	
		if(singleton==null) 
		{
			singleton=new Context();	
		}
		return singleton;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	
	
}
