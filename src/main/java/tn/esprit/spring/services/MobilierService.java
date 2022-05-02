package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Mobilier;
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
		//r andou id maandouch image wel mobilier andou id ou maandouch image
		//sajalna mobilier bech ywali aandou id
		Mobilier mobilier = mobilierRepository.save(r);
		// nparkouriw les images bech norbtou bel mobilier ou l foreach khater barcha image bech tsetilhom id mtaa mobilier bel wahda bel wahda
		r.getImageVideo().forEach(i -> i.setMobilier(mobilier));
		//mobilier andou id andouch image donc set image bech naatiweh image
		//eli f west saveall r andouch image donc amalnelou getimage
		mobilier.setImageVideo(imageVideoRepository
				//save all bech tsajjel les images 
				.saveAll(r.getImageVideo())
				// stream nestaamlou bech nrodouha set 
				.stream()
				// w men stream nestaamlou collect bech nrodouha set khater fel moblier l image mdeclaria set 
				.collect(Collectors.toSet()));
		r.setDate(LocalDate.now());
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
