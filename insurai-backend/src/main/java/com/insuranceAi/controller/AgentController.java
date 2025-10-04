package com.insuranceAi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceAi.model.Agent;
import com.insuranceAi.service.AgentService;

@RestController
@RequestMapping("/agent.com")
public class AgentController {
	
	
	@Autowired
	AgentService agentService;
	
	@PostMapping("/addagent")
	public Agent addagentDetails(@RequestBody Agent agent)
	{
		Agent agentSaved = agentService.addAgentDetails(agent);
		return agentSaved;
	}
	
	@PutMapping("/updateagent/{agentNumber}")
	public Agent updateAgentDetails(@PathVariable Long agentNumber ,@RequestBody Agent agent)
	{
		Agent agentUpdated = agentService.updateAgentDetails(agentNumber, agent);
		return agentUpdated;
	}
	
	@GetMapping("/allagents")
	public List<Agent> getAllAgents()
	{
		return agentService.getAllAgentsDetails();
	}
	
	
	@GetMapping("/allagents/{agentNumber}")
	public Agent getAgentDetailByAgentNumber(@PathVariable Long agentNumber)
	{
		return agentService.getAgentDetails(agentNumber);
	}
	
	@DeleteMapping("/deleteagent/{agentNumber}")
	public String deleteAgent(@PathVariable Long agentNumber)
	{
		String message;
	  message = 	agentService.deleteAgentDetails(agentNumber);
	  return message;
	}
	
	
//	@GetMapping("allagentPaged")
//	public ResponseEntity<Page<agent>> getAllPagedagents(	
//		@RequestParam(defaultValue ="0") int page,
//		@RequestParam(defaultValue = "5") int size,
//		//group by
//		@RequestParam(defaultValue = "agentNumber") String sortBy,
//		//order by
//		@RequestParam(defaultValue = "asc") String sortDirection)
//	{
//		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
//			System.out.println(pageable);
//			Page<agent> agents = agentService.getAllagents(pageable);
//			List<agent> agentsList = agents.getContent();
//	  return new ResponseEntity(agents, HttpStatus.OK);
//	}

}
