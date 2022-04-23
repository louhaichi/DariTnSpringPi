package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class ImageVideo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idImage;
    String Image ; 
    private String type;
    @Lob
    private byte[] data;
    
    
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
	Mobilier mobilier; 
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
   	Annonce annonce; 
    
	public ImageVideo(String image, String type, byte[] data) {
		
		Image = image;
		this.type = type;
		this.data = data;
	}
	
	
	
      public Long getIdImage() {
        return idImage;
      }
      public String getImage() {
        return Image;
      }
      public void setImage(String image) {
        this.Image = image;
      }
      public String getType() {
        return type;
      }
      public void setType(String type) {
        this.type = type;
      }
      public byte[] getData() {
        return data;
      }
      public void setData(byte[] data) {
        this.data = data;
      }

    
    

}


