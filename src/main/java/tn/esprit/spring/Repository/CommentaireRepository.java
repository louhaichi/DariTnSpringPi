package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Commentaire;
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
