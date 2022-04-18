package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Entity.RDV;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.AnnonceRepository;
import tn.esprit.spring.Repository.RDVRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class RDVServiceIMPL implements RDVService {
	
	@Autowired
	RDVRepository RDVRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AnnonceRepository annonceRepo;
	
	@Override
	public RDV saveRDV(RDV r, Long idAnnonce, Long idUser) {
		
		User u= userRepo.findById(idUser).orElseThrow(null);
		Annonce a= annonceRepo.findById(idAnnonce).orElseThrow(null);
		
		r.setUser(u);
		r.setAnnonce(a);
		r.setDateRDV(new Date(System.currentTimeMillis()));
		return RDVRepo.save(r);
	}

	@Override
	public RDV updateRDV(RDV u) {
		// TODO Auto-generated method stub
		return RDVRepo.save(u);
	}

	@Override
	public void deleteRDV(RDV u) {
		// TODO Auto-generated method stub
		RDVRepo.delete(u);
	}

	@Override
	public void deleteRDVById(Long id) {
		// TODO Auto-generated method stub
		RDVRepo.deleteById(id);
	}

	@Override
	public RDV getRDV(Long id) {
		// TODO Auto-generated method stub
		return RDVRepo.findById(id).orElseThrow(null);
	}

	@Override
	public List<RDV> getAllRDVs() {
		// TODO Auto-generated method stub
		return RDVRepo.findAll();
	}
	

}
