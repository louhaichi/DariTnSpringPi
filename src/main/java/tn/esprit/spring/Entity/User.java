package tn.esprit.spring.Entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long cin;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private Boolean etat;
	
	@Enumerated(EnumType.STRING)
	private TypeUser type;
	
	@Column(nullable = true, length = 64)
	private String photos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<RDV> RDVS;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Annonce> annonces;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Mobilier> mobiliers;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Reclamation> reclamations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Sujet> sujets;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Amenagement> demenagments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Amenagement> amenagements;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Messagerie> messages;
}
