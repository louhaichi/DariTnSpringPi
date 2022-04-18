package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Annonce;

public interface AnnonceService  {
	Annonce saveAnnonce(Annonce a, Long idUser );
	Annonce updateAnnonce(Annonce a);
	void acheterAnnonce (Long idAnnonce, Long idUser);
	void affecterAgent (Long idAnnonce, Long idAgent);
	void deleteAnnonce(Annonce a);
	void deleteAnnonceById(Long id);
	Annonce getAnnonce(Long id);
	void AffecterAnnonce(Long idAnnonce, Long idCoupon);
	List<Annonce> getAllAnnonces();
}
