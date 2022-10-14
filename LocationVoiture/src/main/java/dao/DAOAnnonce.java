package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import context.Context;
import model.Compte;

public class DAOAnnonce implements IDAOUtilisateur{
	
	@Override
	public Compte findById(Integer id) {
	
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Compte c = em.find(Compte.class, id);
		em.close();

		return c;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("from Compte").getResultList();

		em.close();

		return comptes;
	}

	@Override
	public Compte save(Compte c) {
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Context.getSingleton().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			c = em.merge(c);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Compte c = em.find(Compte.class, id);

		em.getTransaction().begin();

		em.remove(c);

		em.getTransaction().commit();


		em.close();
	}

	@Override
	public Compte seConnecter(String login, String password) {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		Compte compte = null;

		try {

			Query requete = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
			requete.setParameter("login", login);
			requete.setParameter("password", password);
			compte = (Compte) requete.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}

		em.close();

		return compte;
	}


}

