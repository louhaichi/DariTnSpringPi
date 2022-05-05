package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
