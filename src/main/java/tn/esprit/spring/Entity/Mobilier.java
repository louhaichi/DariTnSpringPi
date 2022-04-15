package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mobilier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idMobiler;
    String Titre ;
	float Prix;
	boolean status;
	String Description ;
	Long idAchteur;
	EtatMobilier etatMobilier;
	
	@ManyToOne
	User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="mobilier" ,cascade =CascadeType.ALL)
	private Set<ImageVideo> imageVideo ;
	
	
	@JsonIgnore
	@OneToOne 
	private Reglement reglement ;
	
	
}

