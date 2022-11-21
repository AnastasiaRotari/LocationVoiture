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

import ajc.sopra.locationVoiture.model.Admin;
import ajc.sopra.locationVoiture.model.Adresse;
import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.model.JsonViews;
import ajc.sopra.locationVoiture.service.AdminService;



@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = {"*"})
public class AdminRestController {



	@Autowired
	private AdminService adminsrvc;

	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Admin inscription(@Valid @RequestBody Admin admin, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminsrvc.save(admin);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Admin findById(@PathVariable Long id) {
		return adminsrvc.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Admin> findAll() {
		return adminsrvc.findAll();
	}
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Admin create(@Valid @RequestBody Admin admin, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminsrvc.save(admin);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin update(@Valid @RequestBody Admin admin, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors() && adminsrvc.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return adminsrvc.save(admin);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Admin patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Admin admin = adminsrvc.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				Map<String, Object> mapAdresse = (Map<String, Object>) v;
				mapAdresse.forEach((kAdresse, vAdresse) -> {
					Field fieldAdresse = ReflectionUtils.findField(Adresse.class, kAdresse);
					ReflectionUtils.makeAccessible(fieldAdresse);
					ReflectionUtils.setField(fieldAdresse, admin.getAdresse(), vAdresse);
				});
			} else {
				Field field = ReflectionUtils.findField(Client.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, admin, v);
			}
		});
		return adminsrvc.save(admin);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		adminsrvc.deleteId(id);
	}


}


