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

import ajc.sopra.eshop.config.JpaConfig;
import ajc.sopra.eshop.model.Produit;
import ajc.sopra.eshop.service.ProduitService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
//par defaut rollback a la fin de chaque transaction
class ServiceTestMoA {

	@Autowired
	CompteService produitSrv;

	@Test
	void InjectionProduitServicetest() {
		assertNotNull(produitSrv);
	}
	
	@Test
	@Commit
	@Disabled
	void initProduit() {
		produitSrv.create(new Produit("velo", 100, null));
		produitSrv.create(new Produit("voiture", 200, null));
	}

	@Test
	void creationProduitTest() {
		Produit produit = new Produit("aaa", 1.5, null);
		produit = produitSrv.create(produit);
		assertNotNull(produit.getId());
		assertNotNull(produitSrv.findById(produit.getId()));
	}

}
