package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name="Agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private int Telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Annonce> annonces;
	
}