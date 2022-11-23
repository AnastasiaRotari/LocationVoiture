package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.exception.CompteException;
import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.model.Compte;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.repository.ClientRepository;
import ajc.sopra.locationVoiture.repository.CompteRepository;



@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Client> findAll() {
		return clientRepo.findAll();
	}

	public Client findById(Long id) {
		return clientRepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Client> findByAge(int age) {
		return clientRepo.findByAgeContaining(age);
	}
	
	public List<Client> findByAnnePermis(int AnneePermis) {
		return clientRepo.findByAnneePermisContaining(AnneePermis);
	}

	public List<Client> findByAccident(int accident) {
		return clientRepo.findByAccidentContaining(accident);
	}
	
	public Client findByIdFetchLocation(Long id) {
		return clientRepo.findByIdFetchingLocation(id).orElseThrow(IdException::new);
	}
	

	public boolean checkEmailExists(String email) {
		return compteRepo.findByEmail(email).isPresent();
	}
	
	public Client create(Client client) {
		if (client.getId() != null) {
			throw new CompteException("client deja dans la base");
		}
		return save(client);

	}

	public Client update(Client client) {
		if (client.getId() == null || !clientRepo.existsById(client.getId())) {
			throw new IdException();
		}
		return save(client);
	}

	public Client save(Client client) {
		if (client.getAge() <=0) {
			throw new CompteException("probleme age");
		}
		if (client.getAnneePermis() <=0) {
			throw new CompteException("probleme Annee de permis");
		}
		if (client.getAccident() <0) {
			throw new CompteException("probleme Accident");
		}
		//Compte compte=client.getCompte();
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		return clientRepo.save(client);
	}

	public void delete(Client client) {
		clientRepo.delete(client);
	}

	public void deleteId(Long id) {
		clientRepo.deleteById(id);
	}
}
