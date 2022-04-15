package tn.esprit.spring.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="RDV")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RDV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idAnnonce;
	private Date dateRDV;
	@ManyToOne
	User user;
	@ManyToOne
	Annonce annonce;
}
