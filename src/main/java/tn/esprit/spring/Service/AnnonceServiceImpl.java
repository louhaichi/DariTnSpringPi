package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Agent;
import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Entity.Coupon;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.AgentRepository;
import tn.esprit.spring.Repository.AnnonceRepository;
import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class AnnonceServiceImpl  implements AnnonceService {
	
	@Autowired
	AnnonceRepository annonceRepository;
	@Autowired
	AgentRepository AgRepos;
	@Autowired
	UserRepository UserRepo;
	@Autowired
	CouponRepository couponRepo;
	
	@Override
	public Annonce saveAnnonce(Annonce a,Long idUser) {
		User user=UserRepo.findById(idUser).orElse(null);
		a.setUser(user);
		a.setDisponibilité(true);
		
		return annonceRepository.save(a);
	}

	@Override
	public Annonce updateAnnonce(Annonce a) {
		return annonceRepository.save(a);
	}

	@Override
	public void deleteAnnonce(Annonce a) {
		annonceRepository.delete(a);

		
	}

	@Override
	public void deleteAnnonceById(Long id) {
		annonceRepository.deleteById(id);

	}

	@Override
	public Annonce getAnnonce(Long id) {
		return annonceRepository.findById(id).orElseThrow(null);

	}

	@Override
	public List<Annonce> getAllAnnonces() {
		return annonceRepository.findAll();
	}

	// affecter un agent a une annonce
	@Override
	public void AffecterAgent(Long idAnn, Long idAgent) {
		Annonce annonce= annonceRepository.findById(idAnn).orElse(null);
		Agent agent=AgRepos.findById(idAgent).orElse(null);
		annonce.setAgent(agent);
		annonceRepository.save(annonce);
		
	}

	//Accheter annonce par un utilisateur 
	@Override
	public void AcheterAnnonce(Long idAnn, Long idAcheteur) {
		/*User Acheteur = UserRepo.findById(idAcheteur).orElse(null);
		Annonce annonce= annonceRepository.findById(idAnn).orElse(null);
		if (annonce.getDisponibilité()==true) {
		annonce.setAcheteur(Acheteur);
		annonce.setDisponibilité(false);
		if (annonce.getTypeAnnonce().toString()=="Achat") {
			annonce.getAgent().setVentes(annonce.getAgent().getVentes()+1);
			annonce.setUser(null);
		}
		else  annonce.getAgent().setLocations(annonce.getAgent().getLocations()+1);
		annonceRepository.save(annonce);
		}*/
		
	}

	@Override
	public void AffecterCoupons(Long idAnn, Long idCoupon) {
		
		Annonce annonce= annonceRepository.findById(idAnn).orElse(null);
		Coupon coupon=couponRepo.findById(idCoupon).orElse(null);
		
		annonce.setCoupon(coupon);
		coupon.setEtat(false);
		annonceRepository.save(annonce);
	}

}