package com.app.service;

import java.util.List;

import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Voter;

public interface VoterService {
	Voter addVoter(Voter v);
	
	List<Voter> getDetails();
	
	Voter updateVoter(Voter v);
	
	String deleteVoter(Integer id);
	
	AuthResponseDto authenticateUser(AuthRequestDto req);
}
