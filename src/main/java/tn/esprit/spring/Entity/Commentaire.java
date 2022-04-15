package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Commentaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor	
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String comment;
	@Temporal(TemporalType.DATE)
	private Date dateAjout;
	@ManyToOne
	private Sujet sujet;
	private long iduser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="commentaire")
	private Set<ReactionCommentaire> reactions;
	
}
