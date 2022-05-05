package tn.esprit.spring.Interface;

import java.util.List;

import tn.esprit.spring.Entity.Commentaire;
import tn.esprit.spring.Entity.ReactionCommentaire;

public interface CommentaireInterface {
	List<Commentaire> retrieveAllCommentaires();

	Commentaire addCommentaire(Commentaire s);

	Commentaire updateCommentaire(Commentaire s);

	Commentaire retrieveCommentaire(Long id);

	void removeCommentaire(Long id);
	
	void addAndAssignReactionCommentaireToCommentaire(Long sujetId , ReactionCommentaire reactionCommentaire);
	


}
