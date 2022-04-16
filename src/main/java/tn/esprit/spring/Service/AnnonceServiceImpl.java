package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Repository.AnnonceRepository;

@Service
public class AnnonceServiceImpl  implements AnnonceService {
	
	@Autowired
	AnnonceRepository annonceRepository;

	@Override
	public Annonce saveAnnonce(Annonce a) {
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

}
