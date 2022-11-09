package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.PersonneException;
import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.model.Admin;
import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.repository.AdminRepository;



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
	
	
	public Admin findByLogin(String login) {
		return adminRepo.findByLoginContaining(login);
	}
	
	public List<Admin> findByNom(String nom) {
		return adminRepo.findByNomContaining(nom);
	}
	
	public List<Admin> findByPrenom(String prenom) {
		return adminRepo.findByPrenomContaining(prenom);
	}
	
	public List<Admin> findByAdresse(Adresse adresse) {
		return adminRepo.findByAdresseContaining(adresse);
	}
	

	public Admin create(Admin admin) {
		if (admin.getId() != null) {
			throw new PersonneException("produit deja dans la base");
		}
		return save(admin);

	}

	public Admin update(Admin admin) {
		if (admin.getId() == null || !adminRepo.existsById(admin.getId())) {
			throw new IdException();
		}
		return save(admin);
	}

	public Admin save(Admin admin) {
		if (admin.getLogin() == null || admin.getLogin().isBlank() || admin.getLogin().length() > 35) {
			throw new PersonneException("probleme login");
		}
		if (admin.getPassword() == null || admin.getPassword().isBlank() || admin.getPassword().length() > 35) {
			throw new PersonneException("probleme password");
		}
		if (admin.getNom() == null || admin.getNom().isBlank() || admin.getNom().length() > 35) {
			throw new PersonneException("probleme nom");
		}
		if (admin.getPrenom() == null || admin.getPrenom().isBlank() || admin.getPrenom().length() > 35) {
			throw new PersonneException("probleme prenom");
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
