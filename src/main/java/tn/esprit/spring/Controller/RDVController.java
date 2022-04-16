package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.RDV;
import tn.esprit.spring.Service.RDVService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RDVController {
	
	@Autowired
	private RDVService RDVservice;
	
	// get all RDVs 
	@GetMapping("/RDVs")
	public List<RDV> getAllRDVs(){
		return RDVservice.getAllRDVs();
		
	}
	
	// create RDV 
	@PostMapping("/RDVs")
	public RDV createRDV(@RequestBody RDV u) {
		return RDVservice.saveRDV(u);
	}
	
	@GetMapping("/RDVs/{id}")
	public ResponseEntity<RDV> getRDVById(@PathVariable Long id) {
		RDV u =RDVservice.getRDV(id);
		return ResponseEntity.ok(u);
	}
	
	@PutMapping("/RDVs/{id}")
	public ResponseEntity<RDV> updateRDV(@PathVariable Long id,@RequestBody RDV r){
		RDV rdv = RDVservice.getRDV(id);
		rdv.setIdAnnonce(r.getIdAnnonce());
		rdv.setDateRDV(r.getDateRDV());
		rdv.setUser(r.getUser());
		//UX.setPhotos(u.getPhotos());
		
		RDV updateRDV = RDVservice.updateRDV(rdv);
		return ResponseEntity.ok(updateRDV);
	}

}
