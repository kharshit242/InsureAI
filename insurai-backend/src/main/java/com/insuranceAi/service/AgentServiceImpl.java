package com.insuranceAi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insuranceAi.model.Agent;
import com.insuranceAi.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService{
	
	@Autowired 
	AgentRepository agentRepository;

	@Override
	public Agent addAgentDetails(Agent agent) {
		// TODO Auto-generated method stub
		Agent agentSaved =  agentRepository.save(agent);
		
		System.out.println("Agent details are saved");
		return agentSaved;
	}

	@Override
	public Agent updateAgentDetails(Long agentNumber, Agent agent) {
		// TODO Auto-generated method stub
		Agent agentUpdated = null;
		if(agentRepository.findById(agentNumber).get()!=null)
		{
			agentUpdated = agentRepository.save(agent);
		}
		else
		{
			agentUpdated = null;
		}
		return agentUpdated;
	}

	@Override
	public Agent getAgentDetails(Long agentNumber) {
		// TODO Auto-generated method stub
		
		return agentRepository.findById(agentNumber).orElseThrow(() -> new RuntimeException("Agent not found with number: " + agentNumber));
		
	}

	@Override
	public List<Agent> getAllAgentsDetails() {
		// TODO Auto-generated method stub
		
		return agentRepository.findAll();
		
	}

	@Override
	public String deleteAgentDetails(Long agentNumber) {
		// TODO Auto-generated method stub
		
		Agent agentDelete = agentRepository.findById(agentNumber).get();
		String message ;
		if(agentDelete!=null)
		{
			agentRepository.delete(agentDelete);
			message = " Agent details deleted successfully";
			
		}
		else
		{
			message = " Agent details could not be deleted";
		}
		return message;
	}

	@Override
	public Page<Agent> getAllAgents(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return agentRepository.findAll(pageable);
		
	}

}
