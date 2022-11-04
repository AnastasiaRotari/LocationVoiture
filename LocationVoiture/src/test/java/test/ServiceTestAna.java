package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import config.JpaConfig;
import service.AdminService;
import service.CompteService;
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
	UtilisateurService utilisateurSrv;

	@Test
	void InjectionProduitServicetest() {
		assertNotNull(compteSrv);
	}
	
	@Test
	@Commit
	@Disabled
	void initProduit() {
		//produitSrv.create(new Produit("velo", 100, null));
		//produitSrv.create(new Produit("voiture", 200, null));
		//produitSrv.create(new Produit("taxi", 50, null));
		//produitSrv.update(new Produit(6,"jambon", 4, null));
		//produitSrv.deleteId(7);
		//System.out.println(produitSrv.findByLibelle("taxi"));
	}
	
	
	

}
