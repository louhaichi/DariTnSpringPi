package tn.esprit.spring.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.ImageVideo;
import tn.esprit.spring.Repository.ImageVideoRepository;


@Service
public class ImageVideoService{
	@Autowired
	ImageVideoRepository imageVideoRepository;
	
	
	public List<ImageVideo> retrieveAllImageVideo() {
		return imageVideoRepository.findAll();
	}

	
	public ImageVideo addImageVideo(ImageVideo r) {
		//r.setDate(LocalDate.now());
		return imageVideoRepository.save(r);
	}

	
	public ImageVideo updateImageVideo(ImageVideo r) {
		return imageVideoRepository.save(r);
	}

	
	public ImageVideo retrieveImageVideo(Long id) {
		return imageVideoRepository.findById(id).orElse(null);
	}

	
	public void removeImageVideo(Long id) {
		imageVideoRepository.deleteById(id);
		
	}


}