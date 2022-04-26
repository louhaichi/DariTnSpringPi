package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Entity.FileDB;
import tn.esprit.spring.Repository.AnnonceRepository;
import tn.esprit.spring.Repository.FileDBRepository;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
	@Autowired
	  private FileDBRepository fileDBRepository;
	@Autowired
	  private AnnonceRepository annonceRepository;

	public FileDB store(MultipartFile file) throws IOException {
	    Annonce annoncefile=annonceRepository.findById((long) annonceRepository.LastID()).orElse(null);
	  System.out.println("annonceid"+annonceRepository.LastID());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), annoncefile);

	    return fileDBRepository.save(FileDB);
	  }
	  public FileDB getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
	  public Stream<FileDB> getAllFiles() {
	    return fileDBRepository.findAll().stream();
	  }
}
