package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.PersonneException;
import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.model.Admin;
import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Compte;
import ajc.sopra.locationVoiture.repository.AdminRepository;
import ajc.sopra.locationVoiture.repository.CompteRepository;



@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		if (admin.getNom() == null || admin.getNom().isBlank() || admin.getNom().length() > 35) {
			throw new PersonneException("probleme nom");
		}
		if (admin.getPrenom() == null || admin.getPrenom().isBlank() || admin.getPrenom().length() > 35) {
			throw new PersonneException("probleme prenom");
		}
		Compte compte=admin.getCompte();
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		compteRepo.save(compte);
		return adminRepo.save(admin);
	}

	public void delete(Admin admin) {
		adminRepo.delete(admin);
	}

	public void deleteId(Integer id) {
		adminRepo.deleteById(id);
	}
}
