package ajc.sopra.locationVoiture;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import config.JpaConfig;
import model.Admin;
import model.Adresse;
import model.Annonce;
import model.Categorie;
import model.Client;
import model.Etat;
import model.Location;
import model.Loueur;
import model.Modele;
import model.Plein;
import service.AdminService;
import service.AnnonceService;
import service.ClientService;
import service.CompteService;
import service.LocationService;
import service.LoueurService;
import service.ModeleService;
import service.UtilisateurService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
//par defaut rollback a la fin de chaque transaction
class ServiceTestAna {

	@Autowired
	CompteService compteSrv;
	
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
