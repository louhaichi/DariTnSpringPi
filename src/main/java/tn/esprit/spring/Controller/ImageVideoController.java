package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import tn.esprit.spring.Entity.ImageVideo;
import tn.esprit.spring.Message.ResponseFile;
import tn.esprit.spring.Message.ResponseMessage;
import tn.esprit.spring.Service.IImageVideoService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ImageVideoController {
	@Autowired 
	IImageVideoService  iImageVideoService ;
	
	
	// http://localhost:8089/SpringMVC/ImageVideo/retrieveAllImageVideo
		@GetMapping("/retrieveAllImageVideo") 
		@ResponseBody
		public List<ImageVideo> getImageVideo() {
			List<ImageVideo> listImageVideo = iImageVideoService.retrieveAllImageVideo();
			return listImageVideo;
			}
		
		// http://localhost:8085/SpringMVC/ImageVideo/Add-ImageVideo
		@PostMapping("/Add-ImageVideo")  
		public ImageVideo addImageVideo(@RequestBody  ImageVideo r)
		{
			return iImageVideoService.addImageVideo(r);
			
		}
		
		
		// http://localhost:8085/SpringMVC/ImageVideo/update-ImageVideo
		@PutMapping("/update-ImageVideo") 
		@ResponseBody
		public  ImageVideo updateImageVideo(@RequestBody ImageVideo r)
		{
			return iImageVideoService.updateImageVideo(r);
			 
		}
		
		// http://localhost:8085/SpringMVC/ImageVideo/retrieve-ImageVideo/{ImageVideo-id}
		@GetMapping("/retrieve-ImageVideo/{ImageVideo-id}") 
		@ResponseBody
		public ImageVideo getImageVideo(@PathVariable("ImageVideo-id") Long idImageVideo ) {
		return iImageVideoService.retrieveImageVideo(idImageVideo);
		
		}

		
		//http://localhost:8089/SpringMVC/ImageVideo/removeImageVideo/{ImageVideo-id}
		@DeleteMapping("/removeImageVideo/{ImageVideo-id}")
		@ResponseBody
		public void removeImageVideo(@PathVariable("ImageVideo-id") Long idImageVideo)
		{
			iImageVideoService.removeImageVideo(idImageVideo);
		}

		//fatma
		
		
		  
		  @PostMapping("/upload")
		  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		    String message = "";
		    try {
		    	iImageVideoService.store(file);
		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
		      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		    } catch (Exception e) {
		      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		    }
		  }
		  @GetMapping("/files")
		  public ResponseEntity<List<ResponseFile>> getListFiles() {
		    List<ResponseFile> files = iImageVideoService.getAllFiles().map(dbFile -> {
		      String fileDownloadUri = ServletUriComponentsBuilder
		          .fromCurrentContextPath()
		          .path("/files/")
		          .path("dbFile.getIdImage()")
		          .toUriString();
		      return new ResponseFile(
		          dbFile.getImage(),
		          fileDownloadUri,
		          dbFile.getType(),
		          dbFile.getData().length);
		    }).collect(Collectors.toList());
		    return ResponseEntity.status(HttpStatus.OK).body(files);
		  }
		  @GetMapping("/files/{id}")
		  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		    ImageVideo fileDB = iImageVideoService.getFile(id);
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getImage() + "\"")
		        .body(fileDB.getData());
		  }
		
		

}