package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Reclamation;


@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
