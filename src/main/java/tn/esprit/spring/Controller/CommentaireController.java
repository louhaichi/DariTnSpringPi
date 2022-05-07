package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.Interface.CommentaireInterface;
import tn.esprit.spring.Entity.Commentaire;
import tn.esprit.spring.Entity.ReactionCommentaire;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {
	
	@Autowired
	CommentaireInterface commentaireInterface;
	
	// http://localhost:8089/SpringMVC/sujet/retrieve-all-sujets
	@GetMapping("/commentaire")
	@ResponseBody
	public List<Commentaire> getCommentaire() {
	List<Commentaire> listStocks = commentaireInterface.retrieveAllCommentaires();
	return listStocks;
	}

	
	// http://localhost:8089/SpringMVC/sujet/retrieve-sujet/8
	@GetMapping("/retrieve-commentaire/{commentaire-id}")
	@ResponseBody
	public Commentaire retrieveCommentaire(@PathVariable("sujet-id") Long idCommentaire) {
	return commentaireInterface.retrieveCommentaire(idCommentaire);
	}
	
	// http://localhost:8089/SpringMVC/stock/add-sujet
	@PostMapping("/add-commentaire")
	@ResponseBody
	public Commentaire addCommentaire(@RequestBody Commentaire s)
	{
		return commentaireInterface.addCommentaire(s);
	}
	
	
	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-commentaire/{commentaire-id}")
	@ResponseBody
	public void removeCommentaire(@PathVariable("commentaire-id") Long idCommentaire) {
		commentaireInterface.removeCommentaire(idCommentaire);
	}
	
	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modify-commentaire")
	@ResponseBody
	public Commentaire modifyCommentaire(@RequestBody Commentaire s) {
		return commentaireInterface.updateCommentaire(s);
	}
	
	@PutMapping("/addAndAssignReactionCommentaireToCommentaire/{commentaire-id}")
	@ResponseBody
	public void addAndAssignReactionCommentaireToCommentaire(@PathVariable("commentaire-id") Long commentaireId,@RequestBody ReactionCommentaire reactionCommentaire) {
		
		
		commentaireInterface.addAndAssignReactionCommentaireToCommentaire(commentaireId, reactionCommentaire);
		
		
	}	
}
