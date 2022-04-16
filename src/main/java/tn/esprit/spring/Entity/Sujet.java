package tn.esprit.spring.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.lang.String;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sujet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sujet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String titre;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateAjout;
	private String image;
	@ManyToOne
	User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="sujet")
	private Set<Commentaire> commentaires;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Tag> tags;
	
}
