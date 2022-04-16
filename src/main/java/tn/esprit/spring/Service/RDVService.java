package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.RDV;

public interface RDVService {
	RDV saveRDV(RDV u);
	RDV updateRDV(RDV u);
	void deleteRDV(RDV u);
	 void deleteRDVById(Long id);
	RDV getRDV(Long id);
	List<RDV> getAllRDVs();

}
