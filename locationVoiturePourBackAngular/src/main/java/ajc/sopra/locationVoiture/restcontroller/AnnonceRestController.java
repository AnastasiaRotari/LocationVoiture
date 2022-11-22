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

import ajc.sopra.locationVoiture.model.Annonce;
import ajc.sopra.locationVoiture.model.JsonViews;
import ajc.sopra.locationVoiture.model.Loueur;
import ajc.sopra.locationVoiture.model.Modele;
import ajc.sopra.locationVoiture.service.AnnonceService;



@RestController
@RequestMapping("/api/annonce")
@CrossOrigin(origins = {"*"})
public class AnnonceRestController {

	@Autowired
	private AnnonceService annonceSrv;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Annonce> findAll() {
		return annonceSrv.findAll();
	}
	
	@JsonView(JsonViews.AnnoncewithModele.class)
	@GetMapping("/{id}/modele")
	public Annonce findByIdWithModele(@PathVariable Long id) {
		return annonceSrv.findByIdFetchModele(id);
	}
	
	@JsonView(JsonViews.AnnoncewithLoueur.class)
	@GetMapping("/{id}/loueur")
	public Annonce findByIdWithLoueur(@PathVariable Long id) {
		return annonceSrv.findByIdFetchLoueur(id);
	}
	

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Annonce findById(@PathVariable Long id) {
		return annonceSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/libelle/{libelle}")
	public List<Annonce> findByLibelle(@PathVariable String libelle) {
		return annonceSrv.findByLibelle(libelle);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/loueur/{id}")
	public List<Annonce> findByLoueurId(@PathVariable Long id) {
		return annonceSrv.findByLoueurId(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/agence/{agence}")
	public List<Annonce> findByAgence(@PathVariable String agence) {
		return annonceSrv.findByAgence(agence);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/modele/{nom}")
	public List<Annonce> findByModeleNomContaining(@PathVariable String nom) {
		return annonceSrv.findByModeleNomContening(nom);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/prix/{prix}")
	public List<Annonce> findByPrixJour(@PathVariable double prix) {
		return annonceSrv.findByPrixJour(prix);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/dispo/{disponible}")
	public List<Annonce> findByDisponibilite(@PathVariable Boolean disponible) {
		return annonceSrv.findByDisponibilite(disponible);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Annonce create(@Valid @RequestBody Annonce annonce, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}

		return annonceSrv.save(annonce);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		try {
			annonceSrv.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Annonce update(@Valid @RequestBody Annonce annonce, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		annonce.setId(id);
		return annonceSrv.update(annonce);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Annonce patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Annonce annonce = annonceSrv.findById(id);

		fields.forEach((k, v) -> {

			if (k.equals("modele")) {
				Map<String, Object> mapModele = (Map<String, Object>) v;
				mapModele.forEach((kModele, vModele) -> {
					Field fieldModele = ReflectionUtils.findField(Modele.class, kModele);
					ReflectionUtils.makeAccessible(fieldModele);
					ReflectionUtils.setField(fieldModele, annonce.getModele(), vModele);
				});
			} else if (k.equals("loueur")) {
				Map<String, Object> mapLoueur = (Map<String, Object>) v;
				mapLoueur.forEach((kLoueur, vLoueur) -> {
					Field fieldLoueur = ReflectionUtils.findField(Loueur.class, kLoueur);
					ReflectionUtils.makeAccessible(fieldLoueur);
					ReflectionUtils.setField(fieldLoueur, annonce.getLoueur(), vLoueur);
				});
			} else {

				Field field = ReflectionUtils.findField(Annonce.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, annonce, v);

			}
		});

		return annonceSrv.update(annonce);
	}

}
