package tn.esprit.spring.interfaces;
import java.util.List;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Sujet;
public interface SujetInterface {
	
	List<Sujet> retrieveAllSujets();

	Sujet addSujet(Sujet s);

	Sujet updateSujet(Sujet s);

	Sujet retrieveSujet(Long id);

	void removeSujet(Long id);
	
	void assignCommentaireToSujet(Long sujetId , Commentaire commentaire) ;

}
