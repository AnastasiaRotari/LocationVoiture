package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompteException;
import exception.IdException;
import model.Admin;
import model.Compte;
import repository.AdminRepository;
import repository.CompteRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;

	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	public Admin findById(Integer id) {
		return adminRepo.findById(id).orElseThrow(IdException::new);
	}


	public Admin create(Admin admin) {
		if (admin.getId() != null) {
			throw new CompteException("produit deja dans la base");
		}
		return save(admin);

	}

	public Admin update(Admin admin) {
		if (admin.getId() == null || !adminRepo.existsById(admin.getId())) {
			throw new IdException();
		}
		return save(admin);
	}

	private Admin save(Admin admin) {
		if (admin.getLogin() == null || admin.getLogin().isBlank() || admin.getLogin().length() > 35) {
			throw new CompteException("probleme login");
		}
		if (admin.getPassword() == null || admin.getPassword().isBlank() || admin.getPassword().length() > 35) {
			throw new CompteException("probleme password");
		}
		if (admin.getNom() == null || admin.getNom().isBlank() || admin.getNom().length() > 35) {
			throw new CompteException("probleme nom");
		}
		if (admin.getPrenom() == null || admin.getPrenom().isBlank() || admin.getPrenom().length() > 35) {
			throw new CompteException("probleme prenom");
		}
		
		return adminRepo.save(admin);
	}

	public void delete(Admin admin) {
		adminRepo.delete(admin);
	}

	public void deleteId(Integer id) {
		adminRepo.deleteById(id);
	}
}
