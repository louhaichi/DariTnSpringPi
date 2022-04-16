package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Annonce;

public interface AnnonceService  {
	Annonce saveAnnonce(Annonce a);
	Annonce updateAnnonce(Annonce a);
	void deleteAnnonce(Annonce a);
	 void deleteAnnonceById(Long id);
	Annonce getAnnonce(Long id);
	List<Annonce> getAllAnnonces();
}
