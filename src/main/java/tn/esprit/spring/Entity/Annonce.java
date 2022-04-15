package tn.esprit.spring.Entity;

import java.util.Date;
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
	private Boolean disponibilité;
	private double surface;
	@OneToOne
	private Coupon coupon;
	
	@OneToOne
	private DariRoom room;
	
	@ManyToOne
	User user;
	
	@ManyToOne 
	Agent agent;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	private Set<RDV> rdvs;
	
	@Enumerated(EnumType.STRING)
	private TypeAnnonce typeAnnonce;
	
	
}




