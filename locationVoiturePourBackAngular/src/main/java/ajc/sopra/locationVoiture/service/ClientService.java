package ajc.sopra.locationVoiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.locationVoiture.exception.CompteException;
import ajc.sopra.locationVoiture.exception.IdException;
import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.repository.ClientRepository;



@Service
public class ClientService {

	@Autowired
	private ClientRepository clientrepo;

	public List<Client> findAll() {
		return clientrepo.findAll();
	}

	public Client findById(Integer id) {
//		return produitRepo.findById(id).orElseThrow(()->{
//			throw new IdException();
//		});
		return clientrepo.findById(id).orElseThrow(IdException::new);
	}

	public List<Client> findByAge(int age) {
		return clientrepo.findByAgeContaining(age);
	}
	
	public List<Client> findByAnnePermis(int AnneePermis) {
		return clientrepo.findByAnneePermisContaining(AnneePermis);
	}

	public List<Client> findByAccident(int accident) {
		return clientrepo.findByAccidentContaining(accident);
	}
	
	
	public List<Client> findByAssurance(boolean assurance) {
		return clientrepo.findByAssuranceContaining(assurance);
	}


	public Client create(Client client) {
		if (client.getId() != null) {
			throw new CompteException("client deja dans la base");
		}
		return save(client);

	}

	public Client update(Client client) {
		if (client.getId() == null || !clientrepo.existsById(client.getId())) {
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
		
		return clientrepo.save(client);
	}

	public void delete(Client client) {
		clientrepo.delete(client);
	}

	public void deleteId(Integer id) {
		clientrepo.deleteById(id);
	}
}
