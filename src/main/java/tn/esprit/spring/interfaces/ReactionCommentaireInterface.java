package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.entity.ReactionCommentaire;



public interface ReactionCommentaireInterface {
	List<ReactionCommentaire> retrieveAllReactionCommentaires();

	ReactionCommentaire addReactionCommentaire(ReactionCommentaire rc);

	ReactionCommentaire updateReactionCommentaire(ReactionCommentaire rc);

	ReactionCommentaire retrieveReactionCommentaire(Long id);

	void removeReactionCommentaire(Long id);

}
