package tn.esprit.spring.Interface;
import java.util.List;

import tn.esprit.spring.Entity.Commentaire;
import tn.esprit.spring.Entity.Sujet;
public interface SujetInterface {
	
	List<Sujet> retrieveAllSujets();

	Sujet addSujet(Sujet s);

	Sujet updateSujet(Sujet s);

	Sujet retrieveSujet(Long id);

	void removeSujet(Long id);
	
	void assignCommentaireToSujet(Long sujetId , Commentaire commentaire) ;

}
