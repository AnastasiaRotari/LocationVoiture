package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.CompteException;
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

	public Admin findById(Long id) {
		return adminRepo.findById(id).orElseThrow(IdException::new);
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

	public Admin save(Admin admin) {
		if (admin.getNom() == null || admin.getNom().isBlank() || admin.getNom().length() > 35) {
			throw new CompteException("probleme nom");
		}
		if (admin.getPrenom() == null || admin.getPrenom().isBlank() || admin.getPrenom().length() > 35) {
			throw new CompteException("probleme prenom");
		}
	
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		
		return adminRepo.save(admin);
	}

	public void delete(Admin admin) {
		adminRepo.delete(admin);
	}

	public void deleteId(Long id) {
		adminRepo.deleteById(id);
	}
}
