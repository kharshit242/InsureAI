package com.insuranceAi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
	

	
		
		//class attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long agentNumber;
		private String agentName;
		private String agentService;
		private String agentAvailability;
		public String getAgentAvailability() {
			return agentAvailability;
		}
		public void setAgentAvailability(String agentAvailability) {
			this.agentAvailability = agentAvailability;
		}
		public String getAgentName() {
			return agentName;
		}
		public void setAgentName(String agentName) {
			this.agentName = agentName;
		}
		public String getAgentService() {
			return agentService;
		}
		public void setAgentService(String agentService) {
			this.agentService = agentService;
		}
		public Long getAgentNumber() {
			return agentNumber;
		}
		public void setAgentNumber(Long agentNumber) {
			this.agentNumber = agentNumber;
		}
		

	}


