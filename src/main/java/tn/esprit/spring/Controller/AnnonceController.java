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

import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Service.AnnonceService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

@RequestMapping("/api/v1")
public class AnnonceController {

	@Autowired
	private AnnonceService annonceService;
	
	@GetMapping("/AfficheAnnonce")
	public List<Annonce> AfficheAnnonce (){
		return annonceService.getAllAnnonces();
		}
	
	@PostMapping("/AjoutAnnonce/{idUser}")
	public Annonce AjoutAnnonce(@RequestBody Annonce A,@PathVariable("idUser") Long idUser){
		return annonceService.saveAnnonce(A,idUser);
		}
	
	@GetMapping("/AfficheAnnonce/{id}")
	public ResponseEntity<Annonce> AfficheAnnonceById(@PathVariable Long id){
		Annonce A= annonceService.getAnnonce(id) ;
		return ResponseEntity.ok(A); //cast 
		}
	
	@PutMapping("/ModifierAnnonce/{id}")
	public ResponseEntity<Annonce>  ModifierAnnonce(@RequestBody Annonce A, @PathVariable Long id){
		Annonce Ax= annonceService.getAnnonce(id);
		Ax.setDescription(A.getDescription());
		Ax.setLocalisation(A.getLocalisation());
		Ax.setNbchambre(A.getNbchambre());
		Ax.setPrix(A.getPrix());
		Ax.setTitre(A.getTitre());
		Ax.setSurface(A.getSurface());
		Ax.setDisponibilité(A.getDisponibilité());
		Annonce updateAnnonce= annonceService.updateAnnonce(Ax);
		return ResponseEntity.ok(updateAnnonce);
		}
	
	
	// affecter un agent a une annonce
	@PutMapping("/AffecterAgent/{idAnnonce}/{idAgent}")
	public void AffecterAgent(@PathVariable("idAnnonce") Long idAnnonce,
			@PathVariable("idAgent") Long idAgent ) {
		annonceService.AffecterAgent(idAnnonce, idAgent);
		
	}
	
	// acheter une annonce 
	@PutMapping("/AcheterAnnonce/{idAnnonce}/{idAcheteur}")
	public void AcheterAnnonce(@PathVariable("idAnnonce") Long idAnnonce,
			@PathVariable("idAcheteur") Long idAcheteur ) {
		annonceService.AcheterAnnonce(idAnnonce, idAcheteur);
		
	}
	
	@PutMapping("/AffecterCoupon/{idAnnonce}/{idCoupon}")
	public void AffecterCoupon(@PathVariable("idAnnonce") Long idAnnonce,
			@PathVariable("idCoupon") Long idCoupon ) {
		annonceService.AffecterCoupons(idAnnonce, idCoupon);
		
	}
	
}
