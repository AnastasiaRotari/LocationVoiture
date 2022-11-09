package ajc.sopra.locationVoiture;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import ajc.sopra.locationVoiture.service.ClientService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
//par defaut rollback a la fin de chaque transaction
class ServiceTestMoA {

	@Autowired
	ClientService clientSrv;

	@Test
	void InjectionProduitServicetest() {
		assertNotNull(clientSrv);
	}

}
