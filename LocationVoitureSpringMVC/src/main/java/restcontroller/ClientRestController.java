package restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
import model.Client;
import model.JsonViews;
import service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private ClientService clientSrv;

	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public Client inscription(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientSrv.save(client);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Client findById(@PathVariable Integer id) {
		return clientSrv.findById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Client> findAll() {
		return clientSrv.findAll();
	}
	
	
	@PostMapping("")
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientSrv.save(client);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client update(@Valid @RequestBody Client client, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors() && clientSrv.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientSrv.save(client);
	}

	
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Client patch(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Client client = clientSrv.findById(id);
		fields.forEach((k, v) -> {
			if (k.equals("adresse")) {
				Map<String, Object> mapAdresse = (Map<String, Object>) v;
				mapAdresse.forEach((kAdresse, vAdresse) -> {
					Field fieldAdresse = ReflectionUtils.findField(Adresse.class, kAdresse);
					ReflectionUtils.makeAccessible(fieldAdresse);
					ReflectionUtils.setField(fieldAdresse, client.getAdresse(), vAdresse);
				});
			} else {
				Field field = ReflectionUtils.findField(Client.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, client, v);
			}
		});
		return clientSrv.save(client);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		clientSrv.deleteId(id);
	}

}
