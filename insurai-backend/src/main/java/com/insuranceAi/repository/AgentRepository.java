package com.insuranceAi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insuranceAi.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent , Long>{
	
	Page<Agent> findAll(Pageable pageable);
	 

}
