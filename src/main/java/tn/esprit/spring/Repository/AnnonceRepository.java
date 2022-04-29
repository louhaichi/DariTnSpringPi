package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Annonce;
import tn.esprit.spring.Entity.TypeAnnonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query(value = "Select Max(id) from Annonce", nativeQuery = true)
	int LastID();
	
	@Query(value="select * from Annonce A where A.localisation= :localisation"
			+ " and A.prix Between :prix-100 And :prix+100 and A.nbchambre Between :NBchambre and :NBchambre+1 and A.type_annonce= :Typeannonce and A.id!=:id",nativeQuery = true)
	List<Annonce> AnnonceSimilaires(String localisation,double prix,int NBchambre, String Typeannonce,long id);
	
}
