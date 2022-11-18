package ajc.sopra.locationVoiture.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
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
import ajc.sopra.locationVoiture.model.Client;
import ajc.sopra.locationVoiture.model.JsonViews;
import ajc.sopra.locationVoiture.model.Location;
import ajc.sopra.locationVoiture.service.LocationService;



@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = {"*"})
public class LocationRestController {

	@Autowired
	private LocationService locationSrv;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Location> findAll() {
		return locationSrv.findAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Location findById(@PathVariable Integer id) {
		return locationSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/client/{id}")
	public List<Location> findByClientId(Integer id) {
		return locationSrv.findByClientId(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	public Location create(@Valid @RequestBody Location location, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}

		return locationSrv.create(location);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		try {
			locationSrv.deleteId(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id inconnu");
		}
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Location update(@Valid @RequestBody Location location, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "données incorrectes");
		}
		location.setId(id);
		return locationSrv.update(location);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Location patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Location location = locationSrv.findById(id);

		fields.forEach((k, v) -> {
			if (k.equals("client")) {
				Map<String, Object> mapClient = (Map<String, Object>) v;
				mapClient.forEach((kClient, vClient) -> {
					Field fieldClient = ReflectionUtils.findField(Client.class, kClient);
					ReflectionUtils.makeAccessible(fieldClient);
					ReflectionUtils.setField(fieldClient, location.getClient(), vClient);
				});
			} 
			else if(k.equals("annonce")) {
				Map<String, Object> mapAnnonce = (Map<String, Object>) v;
				mapAnnonce.forEach((kAnnonce, vAnnonce) -> {
					Field fieldAnnonce = ReflectionUtils.findField(Annonce.class, kAnnonce);
					ReflectionUtils.makeAccessible(fieldAnnonce);
					ReflectionUtils.setField(fieldAnnonce, location.getAnnonce(), vAnnonce);
				});
			} 
			else if(k.equals("dateDebut")) {
				location.setDateDebut(LocalDate.parse(v.toString()));
			}
			else {
				Field field = ReflectionUtils.findField(Location.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, location, v);
			}
		});

		return locationSrv.update(location);
	}

}
