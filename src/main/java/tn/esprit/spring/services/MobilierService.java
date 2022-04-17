package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Mobilier;
import tn.esprit.spring.interfaces.IMobilierService;

import tn.esprit.spring.repository.MobilierRepository;



@Service
public class MobilierService implements IMobilierService {
	@Autowired
	MobilierRepository mobilierRepository;
	
	@Override
	public List<Mobilier> retrieveAllMobilier() {
		return mobilierRepository.findAll();
	}

	@Override
	public Mobilier addMobilier(Mobilier r) {
		r.setDate(LocalDate.now());
		return mobilierRepository.save(r);
	}

	@Override
	public Mobilier updateMobilier(Mobilier r) {
		return mobilierRepository.save(r);
	}

	@Override
	public Mobilier retrieveMobilier(Long id) {
		return mobilierRepository.findById(id).orElse(null);
	}

	@Override
	public void removeMobilier(Long id) {
		mobilierRepository.deleteById(id);
		
	}
}
