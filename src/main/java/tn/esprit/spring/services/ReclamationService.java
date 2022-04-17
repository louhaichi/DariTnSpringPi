package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.interfaces.IReclamationService;
import tn.esprit.spring.repository.ReclamationRepository;



@Service
public class ReclamationService implements IReclamationService {
	@Autowired
	ReclamationRepository reclamationRepository;
	
	@Override
	public List<Reclamation> retrieveAllReclamation() {
		return reclamationRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		r.setDate(LocalDate.now());
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		return reclamationRepository.save(r);
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		return reclamationRepository.findById(id).orElse(null);
	}

	@Override
	public void removeReclamation(Long id) {
		reclamationRepository.deleteById(id);
		
	}

}
