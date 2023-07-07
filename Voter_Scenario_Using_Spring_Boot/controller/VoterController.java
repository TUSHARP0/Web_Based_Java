package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Voter;
import com.app.service.VoterService;

@RestController
@RequestMapping("/voters")
public class VoterController {

	@Autowired
	private VoterService service;
	
	@PostMapping("/insert")
	public Voter insert(@RequestBody Voter v) {
		return service.addVoter(v);
	}
	
	@GetMapping("/details")
	public List<Voter> details(){
		return service.getDetails();
	}
	
	@PutMapping("/update")
	public Voter update(@RequestBody Voter v) {
		return service.updateVoter(v);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		return service.deleteVoter(id);
	}
	
	@PostMapping("/authenticate")
	public AuthResponseDto authenticate(@RequestBody AuthRequestDto req) {
		return service.authenticateUser(req);
	}
}
