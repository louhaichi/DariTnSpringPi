package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Commentaire;
import tn.esprit.spring.Entity.ReactionCommentaire;
import tn.esprit.spring.Interface.CommentaireInterface;
import tn.esprit.spring.Interface.ReactionCommentaireInterface;
import tn.esprit.spring.Repository.ReactionCommentaireRepository;

public class ReactionCommentaireService implements ReactionCommentaireInterface {
	
	ReactionCommentaireRepository reactionCommenairetRepository;
	@Override
	public List<ReactionCommentaire> retrieveAllReactionCommentaires() {
		List<ReactionCommentaire> commenataireList = reactionCommenairetRepository.findAll();
		for(ReactionCommentaire commentaire : commenataireList) {
		
		}
		return commenataireList;
	}

	@Override
	public ReactionCommentaire addReactionCommentaire(ReactionCommentaire rc) {
		
		return reactionCommenairetRepository.save(rc);
	}

	@Override
	public ReactionCommentaire updateReactionCommentaire(ReactionCommentaire rc) {
		return reactionCommenairetRepository.save(rc);
	}

	@Override
	public ReactionCommentaire retrieveReactionCommentaire(Long id) {
		return reactionCommenairetRepository.findById(id).orElse(null);
	}

	@Override
	public void removeReactionCommentaire(Long id) {
		reactionCommenairetRepository.deleteById(id);
		
	}
	
}
