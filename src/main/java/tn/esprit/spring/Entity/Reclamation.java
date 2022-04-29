package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reclamation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	Long id;
	String titre;
	String Sujet ;
	
	LocalDate date;
	
	String reponse;
	
	
	
	@ManyToOne
	@JsonIgnoreProperties({"reclamations", "reclamationsAdmin", "mobiliersVendeur", "mobiliersAchteur"})
	User user;
	
	@ManyToOne
	@JsonIgnoreProperties({"reclamations", "reclamationsAdmin", "mobiliersVendeur", "mobiliersAchteur"})
	User admin;

}
