package tn.esprit.spring.Interface;

import java.util.List;

import tn.esprit.spring.Entity.ReactionCommentaire;



public interface ReactionCommentaireInterface {
	List<ReactionCommentaire> retrieveAllReactionCommentaires();

	ReactionCommentaire addReactionCommentaire(ReactionCommentaire rc);

	ReactionCommentaire updateReactionCommentaire(ReactionCommentaire rc);

	ReactionCommentaire retrieveReactionCommentaire(Long id);

	void removeReactionCommentaire(Long id);

}
