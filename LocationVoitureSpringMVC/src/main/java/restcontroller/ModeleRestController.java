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

import model.Adresse;
import model.Categorie;
import model.JsonViews;
import model.Modele;
import service.ModeleService;

@RestController
@RequestMapping("/api/modele")
public class ModeleRestController {

	@Autowired
	private ModeleService modeleSrv;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Modele> findAll() {
		return modeleSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Modele findById(@PathVariable Integer id) {
		return modeleSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/categorie/{categorie}")
	public List<Modele> findByCategorie(@PathVariable Categorie categorie) {
		return modeleSrv.findByCategorie(categorie);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/nom/{nom}")
	public List<Modele> findByNom(@PathVariable String nom) {
		return modeleSrv.findByNom(nom);
	}

	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modele create(@Valid @RequestBody Modele modele, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return modeleSrv.create(modele);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Modele update(@Valid @RequestBody Modele modele, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && modeleSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return modeleSrv.update(modele);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Modele update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Modele modele = modeleSrv.findById(id);

		fields.forEach((k, v) -> {
			if (k.equals("categorie")) {
				
				modele.setCategorie(Categorie.valueOf(v.toString()));
				
				}
			 else {
				Field field = ReflectionUtils.findField(Modele.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, modele, v);
			}

		});

		return modeleSrv.update(modele);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		modeleSrv.deleteById(id);
	}

}
