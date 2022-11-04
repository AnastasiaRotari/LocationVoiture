package restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import model.Annonce;
import model.Client;
import model.JsonViews;
import model.Location;
import model.Loueur;
import model.Modele;
import service.AnnonceService;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceRestController {
	
	@Autowired
	private AnnonceService annonceSrv;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Annonce> findAll(){
		return annonceSrv.findAll();
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Annonce findById(@PathVariable Integer id) {
		return annonceSrv.findById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByLibelle(String libelle) {
		return annonceSrv.findByLibelle(libelle);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByLoueur(Loueur loueur) {
		return annonceSrv.findByLoueur(loueur);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByAgence(String agence) {
		return annonceSrv.findByAgence(agence);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByModelContaining(Modele modele) {
		return annonceSrv.findByModelContaining(modele);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByPrixJourContaining(double prix) {
		return annonceSrv.findByPrixJourContaining(prix);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Annonce> findByDisponibiliteContaining(Boolean disponible) {
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
	public void deleteById(@PathVariable Integer id) {
		try {
			annonceSrv.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Annonce update(@Valid @RequestBody Annonce annonce, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		annonce.setId(id);
		return annonceSrv.update(annonce);
	}
	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Annonce patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Annonce annonce = annonceSrv.findById(id);

		fields.forEach((k, v) -> {
			
				Field field = ReflectionUtils.findField(Location.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, annonce, v);
	
		});

		return annonceSrv.update(annonce);
	}
	

}
