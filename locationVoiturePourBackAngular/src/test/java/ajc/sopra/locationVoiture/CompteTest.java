package ajc.sopra.locationVoiture;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import ajc.sopra.locationVoiture.model.Compte;
import ajc.sopra.locationVoiture.repository.CompteRepository;

@SpringBootTest
public class CompteTest {

	@Autowired
	CompteRepository compteRepo;
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
//	@Test
//	@Transactional
//	@Commit
//	@Disabled
//	void compteInitTest() {
//		compteRepo.save(new Compte("admin@admin.fr", passwordEncoder.encode("admin")));
//	}
}
