package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import tn.esprit.spring.entity.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
	@Query(value = "Select Max(id)+1 from Annonce", nativeQuery = true)
	int LastID();
	
	@Query(value="select * from Annonce A where A.localisation= :localisation"
			+ " and A.prix Between :prix-100 And :prix+100 and A.nbchambre Between :NBchambre-1 and :NBchambre+1 and A.type_annonce= :Typeannonce and A.id!=:id",nativeQuery = true)
	List<Annonce> AnnonceSimilaires(String localisation,double prix,int NBchambre, String Typeannonce,long id);
	
	

	@Query(value="SELECT * FROM `annonce` WHERE  coupon_id IS NOT NULL",nativeQuery = true )
	List<Annonce> Annonces();	

	@Query(value="SELECT user_id FROM Annonce a WHERE a.id=:idannonce",nativeQuery = true )
	Long getUserFromAnnonce(Long idannonce);
}