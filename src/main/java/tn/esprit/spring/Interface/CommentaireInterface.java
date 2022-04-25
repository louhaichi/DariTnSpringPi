package tn.esprit.spring.Interface;

import java.util.List;

import tn.esprit.spring.Entity.Commentaire;

public interface CommentaireInterface {
	List<Commentaire> retrieveAllCommentaires();

	Commentaire addCommentaire(Commentaire s);

	Commentaire updateCommentaire(Commentaire s);

	Commentaire retrieveCommentaire(Long id);

	void removeCommentaire(Long id);
	


}
