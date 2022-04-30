package tn.esprit.spring.Entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Annonce implements Serializable{
	private static final long serialVersionUID = 1L;
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
	
	@JsonIgnore
	@OneToOne
	private Coupon coupon;
	@JsonIgnore
	@OneToOne
	private DariRoom room;
	

	@ManyToOne
	User user;
	

	@ManyToOne
	User Acheteur;
	
	
	
	@ManyToOne 
	Agent agent;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="annonce")
	private Set<RDV> rdvs;
	
	@Enumerated(EnumType.STRING)
	private TypeAnnonce typeAnnonce;
	
	
	@JsonBackReference(value="annonce")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonBackReference(value="biens")
	public User getAcheteur() {
		return Acheteur;
	}

	public void setAcheteur(User acheteur) {
		Acheteur = acheteur;
	}
	
	
	
}




