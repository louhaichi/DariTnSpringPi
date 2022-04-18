package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.Annonce;

public interface AnnonceService  {
	Annonce saveAnnonce(Annonce a,Long idUser);
	Annonce updateAnnonce(Annonce a);
	void deleteAnnonce(Annonce a);
	 void deleteAnnonceById(Long id);
	Annonce getAnnonce(Long id);
	List<Annonce> getAllAnnonces();
	void AffecterAgent(Long idAnn,Long IdAgent);
	void AcheterAnnonce(Long idAnn,Long idAcheteur);
	void AffecterCoupons(Long idAnn,Long idCoupon);
}