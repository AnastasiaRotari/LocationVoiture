package ajc.sopra.locationVoiture.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.JsonViews;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.service.LoueurService;



@RestController
@RequestMapping("/api/loueur")
@CrossOrigin(origins = {"*"})
public class LoueurRestController {

	@Autowired
	private LoueurService loueurSrv;

	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Loueur inscription(@Valid @RequestBody Loueur loueur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return loueurSrv.save(loueur);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Loueur update(@Valid @RequestBody Loueur loueur, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && loueurSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return loueurSrv.save(loueur);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Loueur findById(@PathVariable Integer id) {
		return loueurSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Loueur> findAll() {
		return loueurSrv.findAll();
	}

	@JsonView(JsonViews.LoueurWithAnnonce.class)
	@GetMapping("/{id}/Annonce")
	public Loueur findByIdWithProduit(@PathVariable Integer id) {
		return loueurSrv.findByIdFetchAnnonce(id);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Loueur patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Loueur loueur = loueurSrv.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				Map<String, Object> mapAdresse = (Map<String, Object>) v;
				mapAdresse.forEach((kAdresse, vAdresse) -> {
					Field fieldAdresse = ReflectionUtils.findField(Adresse.class, kAdresse);
					ReflectionUtils.makeAccessible(fieldAdresse);
					ReflectionUtils.setField(fieldAdresse, loueur.getAdresse(), vAdresse);
				});
			} else if (k.equals("annonce")) {
				Map<String, Object> mapAnnonce = (Map<String, Object>) v;
				mapAnnonce.forEach((kAnnonce, vAnnonce) -> {
					Field fieldAnnonce = ReflectionUtils.findField(Annonce.class, kAnnonce);
					ReflectionUtils.makeAccessible(fieldAnnonce);
					ReflectionUtils.setField(fieldAnnonce, loueur.getAnnonce(), vAnnonce);
				});
			} else {
				Field field = ReflectionUtils.findField(Loueur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, loueur, v);
			}
		});
		return loueurSrv.save(loueur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		loueurSrv.deleteId(id);
	}
}
