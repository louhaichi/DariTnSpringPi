package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.Entity.ReclamationStatus;

import java.util.List;


@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

	//queryDSL 
	//findAllByStatusEquals dsl yefhemha 
    List<Reclamation> findAllByStatusEquals(ReclamationStatus reclamationStatus);
}
