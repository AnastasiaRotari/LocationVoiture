package ajc.sopra.locationVoiture;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import ajc.sopra.locationVoiture.model.Admin;
import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.Categorie;
import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.model.Etat;
import ajc.sopra.locationVoiture.model.Location;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.model.Modele;
import ajc.sopra.locationVoiture.model.Plein;
import ajc.sopra.locationVoiture.service.AdminService;
import ajc.sopra.locationVoiture.service.AnnonceService;
import ajc.sopra.locationVoiture.service.ClientService;
import ajc.sopra.locationVoiture.service.PersonneService;
import ajc.sopra.locationVoiture.service.LocationService;
import ajc.sopra.locationVoiture.service.LoueurService;
import ajc.sopra.locationVoiture.service.ModeleService;
import ajc.sopra.locationVoiture.service.UtilisateurService;


@SpringBootTest
class ServiceTestAna {

	@Autowired
	PersonneService compteSrv;
	
	@Autowired
	AdminService adminSrv;
	
	@Autowired
	ClientService clientSrv;
	
	@Autowired
	LoueurService loueurSrv;
	
	@Autowired
	UtilisateurService utilisateurSrv;
	
	@Autowired
	ModeleService modeleSrv;
	
	@Autowired
	LocationService locationSrv;
	
	@Autowired
	AnnonceService annonceSrv;

	
	@Test
	@Commit
	void init() {
		
		adminSrv.create(new Admin("1111","admin","Doe","John"));
		Adresse adresse1 = new Adresse("5","rue de Paris","Paris","55555");
		clientSrv.create(new Client("1234","client","Abid","Jordan",adresse1,29,5,true,0,null));
		loueurSrv.create(new Loueur("1234","loueur","Rotari","Anastasia",null));
		
	
		modeleSrv.create(new Modele ("C2",Categorie.valueOf("citadine"),"2005"));
		annonceSrv.create(new Annonce("Superbe C2",modeleSrv.findById(1),loueurSrv.findById(3),Plein.valueOf("rempli"),205000,"Lille",Etat.valueOf("excellent"),70.00,true));
		
		locationSrv.create(new Location(LocalDate.parse("2022-11-07"),LocalDate.parse("2022-11-08"),70,annonceSrv.findById(1),clientSrv.findById(2)));                             
	}
	
	
	

}
