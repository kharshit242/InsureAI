package com.insuranceAi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.insuranceAi.model.Agent;

public interface AgentService {
	
	Agent addAgentDetails(Agent agent);
	Agent updateAgentDetails(Long agentNumber , Agent agent);
	Agent getAgentDetails(Long agentNumber);
	List<Agent> getAllAgentsDetails();
	String deleteAgentDetails(Long agentNumber);
	
	public Page<Agent> getAllAgents(Pageable pageable);
	
	
	

}