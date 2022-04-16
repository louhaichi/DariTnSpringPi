package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.RDV;
import tn.esprit.spring.Repository.RDVRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class RDVServiceIMPL implements RDVService {
	
	@Autowired
	RDVRepository RDVRepo;
	@Override
	public RDV saveRDV(RDV u) {

		return RDVRepo.save(u);
	}

	@Override
	public RDV updateRDV(RDV u) {
		// TODO Auto-generated method stub
		return RDVRepo.save(u);
	}

	@Override
	public void deleteRDV(RDV u) {
		// TODO Auto-generated method stub
		RDVRepo.delete(u);
	}

	@Override
	public void deleteRDVById(Long id) {
		// TODO Auto-generated method stub
		RDVRepo.deleteById(id);
	}

	@Override
	public RDV getRDV(Long id) {
		// TODO Auto-generated method stub
		return RDVRepo.findById(id).orElseThrow(null);
	}

	@Override
	public List<RDV> getAllRDVs() {
		// TODO Auto-generated method stub
		return RDVRepo.findAll();
	}
	

}
