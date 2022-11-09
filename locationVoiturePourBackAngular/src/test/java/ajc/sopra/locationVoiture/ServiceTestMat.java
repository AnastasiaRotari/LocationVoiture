package ajc.sopra.locationVoiture;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import ajc.sopra.locationVoiture.service.AnnonceService;



@SpringBootTest
class ServiceTestMat {

	@Autowired
	AnnonceService annonceSrv;

}
