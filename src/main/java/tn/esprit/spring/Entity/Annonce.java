package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Annonce")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titre;
	private String description;
	private String localisation;
	private int nbchambre;
	private double prix;
	private Boolean disponibilite;
	private double surface;
	@Enumerated(EnumType.STRING)
	private TypeAnnonce typeAnnonce;
	
	
	//@JsonIgnore
		@OneToMany(mappedBy="annonce",cascade =CascadeType.REMOVE)
		@JsonIgnoreProperties("annonce")
		private Set<ImageVideo> imageVideo ;
	
	
	
	@JsonIgnore
	@OneToOne
	private Coupon coupon;
	
	@JsonIgnore
	@OneToOne
	private DariRoom room;
	
	@JsonIgnore
	@ManyToOne
	User user;
	
	@JsonIgnore
	@ManyToOne
	User Acheteur;
	@JsonIgnore
	@ManyToOne 
	Agent agent;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	private Set<RDV> rdvs;
	
	
	
	
	
}




