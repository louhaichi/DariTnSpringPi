package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query(value = "Select Max(id)+1 from Annonce", nativeQuery = true)
	int LastID();
}