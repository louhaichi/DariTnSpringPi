package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.RDV;

@Repository
public interface RDVRepository extends JpaRepository<RDV, Long> {

}
