package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Agent;
import tn.esprit.spring.Repository.AgentRepository;
import tn.esprit.spring.Repository.AnnonceRepository;

@Service
public class AgentServiceIMPL implements AgentService {

	@Autowired
	AgentRepository AgentRepo;
	@Autowired
	AnnonceRepository annonceRepo;
	@Override
	public Agent saveAgent(Agent A) {

		return AgentRepo.save(A);
	}

	@Override
	public Agent updateAgent(Agent A) {
		// TODO Auto-generated method stub
		return AgentRepo.save(A);
	}

	@Override
	public void deleteAgent(Agent A) {
		// TODO Auto-generated method stub
		AgentRepo.delete(A);
	}

	@Override
	public void deleteAgentById(Long id) {
		// TODO Auto-generated method stub
		AgentRepo.deleteById(id);
	}

	@Override
	public Agent getAgent(Long id) {
		// TODO Auto-generated method stub
		return AgentRepo.findById(id).orElseThrow(null);
	}

	@Override
	public List<Agent> getAllAgents() {
		// TODO Auto-generated method stub
		return AgentRepo.findAll();
	}

	@Override
	public int Vente(Long idAgent) {
		Agent ag = AgentRepo.findById(idAgent).orElseThrow(null);
				
		return ag.getVentes();
		
	}

	@Override
	public int Location(Long idAgent) {
		Agent ag = AgentRepo.findById(idAgent).orElseThrow(null);
		
		return ag.getLocations();
	}

	
	
}
