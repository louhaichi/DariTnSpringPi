package tn.esprit.spring.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Entity.ImageVideo;



public interface IImageVideoService {
	
	List<ImageVideo> retrieveAllImageVideo();
	ImageVideo addImageVideo (ImageVideo r);
	ImageVideo updateImageVideo (ImageVideo r);
	ImageVideo retrieveImageVideo (Long id);
	void removeImageVideo (Long id);
	ImageVideo store(MultipartFile file) throws IOException;
	Stream <ImageVideo>  getAllFiles();
	ImageVideo getFile(Long id);
}