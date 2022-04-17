package tn.esprit.spring.interfaces;

import java.util.List;

import tn.esprit.spring.Entity.ImageVideo;



public interface IImageVideoService {
	
	List<ImageVideo> retrieveAllImageVideo();
	ImageVideo addImageVideo (ImageVideo r);
	ImageVideo updateImageVideo (ImageVideo r);
	ImageVideo retrieveImageVideo (Long id);
	void removeImageVideo (Long id);

}
