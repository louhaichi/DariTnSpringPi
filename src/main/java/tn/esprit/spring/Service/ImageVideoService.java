package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.ImageVideo;
import tn.esprit.spring.Repository.ImageVideoRepository;
import java.io.IOException;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageVideoService  implements IImageVideoService {
	@Autowired
	ImageVideoRepository imageVideoRepository;
	
	@Override
	public List<ImageVideo> retrieveAllImageVideo() {
		return imageVideoRepository.findAll();
	}

	@Override
	public ImageVideo addImageVideo(ImageVideo r) {
		//r.setDate(LocalDate.now());
		return imageVideoRepository.save(r);
	}

	@Override
	public ImageVideo updateImageVideo(ImageVideo r) {
		return imageVideoRepository.save(r);
	}

	@Override
	public ImageVideo retrieveImageVideo(Long id) {
		return imageVideoRepository.findById(id).orElse(null);
	}

	@Override
	public void removeImageVideo(Long id) {
		imageVideoRepository.deleteById(id);
		
	}
	
	
	//fatma
	
	
	  public ImageVideo store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    ImageVideo FileDB = new ImageVideo(fileName, file.getContentType(), file.getBytes());
	    return imageVideoRepository.save(FileDB);
	  }
	  public ImageVideo getFile(Long id) {
	    return imageVideoRepository.findById(id).get();
	  }
	  
	  public Stream<ImageVideo> getAllFiles() {
	    return imageVideoRepository.findAll().stream();
	  }
	
	
	
	


}