package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Mobilier;
import tn.esprit.spring.interfaces.IMobilierService;
import tn.esprit.spring.repository.ImageVideoRepository;
import tn.esprit.spring.repository.MobilierRepository;



@Service
public class MobilierService implements IMobilierService {
	@Autowired
	MobilierRepository mobilierRepository;
	@Autowired
	ImageVideoRepository imageVideoRepository;
	
	@Override
	public List<Mobilier> retrieveAllMobilier() {
		return mobilierRepository.findAll();
	}

	
	//bech yorbet id mobilier bel image
	@Override
	public Mobilier addMobilier(Mobilier r) {
		Mobilier mobilier = mobilierRepository.save(r);
		r.getImageVideo().forEach(i -> i.setMobilier(mobilier));
		r.setDate(LocalDate.now());
		mobilier.setImageVideo(imageVideoRepository.saveAll(r.getImageVideo()).stream().collect(Collectors.toSet()));
		
		return mobilier;
	}

	@Override
	public Mobilier updateMobilier(Mobilier r) {
		Mobilier mobilier = mobilierRepository.save(r);
		r.getImageVideo().forEach(i -> i.setMobilier(mobilier));
		mobilier.setImageVideo(imageVideoRepository.saveAll(r.getImageVideo()).stream().collect(Collectors.toSet()));
		
		return mobilier;
		
	}

	@Override
	public Mobilier retrieveMobilier(Long id) {
		return mobilierRepository.findById(id).orElse(null);
	}

	@Override
	public void removeMobilier(Long id) {
		mobilierRepository.deleteById(id);
		
	}

	public  List<Object[]>  findMobilierVenduByDate(){
		return mobilierRepository.findAllByStatusFalseAndGroupByLocalDate();
	}
}
