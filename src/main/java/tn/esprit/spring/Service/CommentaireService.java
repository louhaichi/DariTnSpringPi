package tn.esprit.spring.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Entity.Commentaire;
import tn.esprit.spring.Entity.ReactionCommentaire;
import tn.esprit.spring.Entity.Sujet;
import tn.esprit.spring.Interface.CommentaireInterface;
import tn.esprit.spring.Interface.SujetInterface;
import tn.esprit.spring.Repository.CommentaireRepository;
import tn.esprit.spring.Repository.ReactionCommentaireRepository;
import tn.esprit.spring.Repository.SujetRepository;

@Service
@Slf4j
public class CommentaireService implements CommentaireInterface{
	
	@Autowired
	CommentaireRepository commenairetRepository;
	@Autowired
	ReactionCommentaireRepository reactionCommenairetRepository;
	@Override
	public List<Commentaire> retrieveAllCommentaires() {
		List<Commentaire> commenataireList = commenairetRepository.findAll();
		for(Commentaire commentaire : commenataireList) {
		
		}
		return commenataireList;
	}

	@Override
	public Commentaire addCommentaire(Commentaire s) {
		return commenairetRepository.save(s);
	}

	@Override
	public Commentaire updateCommentaire(Commentaire s) {
		return commenairetRepository.save(s);
	}

	@Override
	public Commentaire retrieveCommentaire(Long id) {
		return commenairetRepository.findById(id).orElse(null);
	}

	@Override
	public void removeCommentaire(Long id) {
		commenairetRepository.deleteById(id);
		
	}
	
	@Transactional
	public void addAndAssignReactionCommentaireToCommentaire(Long sujetId , ReactionCommentaire reactionCommentaire) {
		Commentaire c =commenairetRepository.findById(sujetId).orElse(null);
		int reacted=0;
		for (ReactionCommentaire r : c.getReactions()) {
	        if (r.getIduser()==reactionCommentaire.getIduser()) {
	        	reacted=1;
	        	r.setReaction(reactionCommentaire.getReaction());
	        	commenairetRepository.save(c); 
	        }
	    }
		if(reacted==0) {
			reactionCommentaire.setCommentaire(c);
			reactionCommenairetRepository.save(reactionCommentaire);
			//Commentaire co= commentaireRepository.findById(commentaireId).orElse(null);
			c.getReactions().add(reactionCommentaire); //not working
			commenairetRepository.save(c); //not working
			//commentaireRepository.save(co);
		}
		
	}
}
