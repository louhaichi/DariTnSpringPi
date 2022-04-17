package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Mobilier;


@Repository
public interface MobilierRepository extends JpaRepository<Mobilier, Long> {

}
