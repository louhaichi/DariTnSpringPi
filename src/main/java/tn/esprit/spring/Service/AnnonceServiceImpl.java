package tn.esprit.spring.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Agent;
import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Entity.Coupon;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.AgentRepository;
import tn.esprit.spring.Repository.AnnonceRepository;
import tn.esprit.spring.Repository.CouponRepository;
import tn.esprit.spring.Repository.ImageVideoRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class AnnonceServiceImpl  implements AnnonceService {
	
	@Autowired
	AnnonceRepository annonceRepository;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AgentRepository agentRepo;
	
	@Autowired
	CouponRepository couponRepo;
	@Autowired
	ImageVideoRepository imageVideoRepository;

	@Override
	public Annonce saveAnnonce(Annonce a, Long idUser ) {
		User u = userRepo.findById(idUser).orElseThrow(null);
		a.setUser(u);
		a.setDisponibilite(true);
		
		Annonce annonce = annonceRepository.save(a);
		a.getImageVideo().forEach(i->i.setAnnonce(annonce));
		System.out.println(a.getTitre());
		
		annonce.setImageVideo(imageVideoRepository.saveAll(a.getImageVideo()).stream().collect(Collectors.toSet()));
		
		
		return annonce;
		
		
	}

	@Override
	public Annonce updateAnnonce(Annonce a) {
		Annonce annonce = annonceRepository.save(a);
		a.getImageVideo().forEach(i->i.setAnnonce(annonce));
		
		annonce.setImageVideo(imageVideoRepository.saveAll(a.getImageVideo()).stream().collect(Collectors.toSet()));
		
		
		return annonce;
		
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

	@Override
	public void acheterAnnonce(Long idAnnonce, Long idUser) {
		User u = userRepo.findById(idUser).orElseThrow(null);
		Annonce a = annonceRepository.findById(idAnnonce).orElseThrow(null);
		
		 
		a.setDisponibilite(false);
		a.setAcheteur(u);
		
		if(a.getTypeAnnonce().toString() =="Achat")
		{
		   a.setUser(null);
		   a.getAgent().setVentes(a.getAgent().getVentes()+1);
		   
		}
		else {
			a.getAgent().setLocations(a.getAgent().getLocations()+1);
		}
		annonceRepository.save(a);
		
	
	}

	@Override
	public void AffecterAnnonce(Long idAnnonce, Long idCoupon) {
		Coupon c = couponRepo.findById(idCoupon).orElseThrow(null);
		Annonce a = annonceRepository.findById(idAnnonce).orElseThrow(null);
		
		a.setCoupon(c);
		c.setEtat(false);
		annonceRepository.save(a);
		
		
	}

	@Override
	public void affecterAgent(Long idAnnonce, Long idAgent) {
		Agent ag= agentRepo.findById(idAgent).orElseThrow(null);
		Annonce a = annonceRepository.findById(idAnnonce).orElseThrow(null);
		a.setAgent(ag);
		annonceRepository.save(a);
		
	}
}
