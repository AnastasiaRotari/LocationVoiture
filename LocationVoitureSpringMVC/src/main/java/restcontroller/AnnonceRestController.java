package restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import model.Annonce;
import service.AnnonceService;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceRestController {
	
	@Autowired
	private AnnonceService annonceSrv;
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Annonce create(@RequestBody Annonce annonce) {
		return annonceSrv.save(annonce);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Annonce> findAll(){
		return annonceSrv.findAll();
	}
	

}
