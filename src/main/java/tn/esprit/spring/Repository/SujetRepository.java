package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Sujet;
@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long>{

}
