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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String titre;
	String Sujet ;
	
	LocalDate date;
	//@ManyToOne
	//User admin;
	String reponse;
	
	
	
	//@ManyToOne
	//User user;
	
}
