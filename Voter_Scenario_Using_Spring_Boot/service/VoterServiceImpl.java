package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AuthRequestDto;
import com.app.dto.AuthResponseDto;
import com.app.entities.Voter;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.VoterRepository;
@Service
@Transactional
public class VoterServiceImpl implements VoterService {
	@Autowired
	private VoterRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Voter addVoter(Voter v) {
		return repo.save(v);
	}
	@Override
	public List<Voter> getDetails() {
		return repo.findAll();
	}
	@Override
	public Voter updateVoter(Voter v) {
		return repo.save(v);
	}
	@Override
	public String deleteVoter(Integer id) {
		String msg="Can't Delete";
		if(repo.existsById(id)) {
			repo.deleteById(id);
			msg="Deleted Successfully";
		}
		return msg;
	}
	@Override
	public AuthResponseDto authenticateUser(AuthRequestDto req) {
		Voter voter = repo.findByEmailAndPassword(req.getEmail(), req.getPassword())
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Data"));
		AuthResponseDto resp = mapper.map(voter, AuthResponseDto.class);
		String msg="xxx";
		if(resp.isStatus()) {
			msg="Hello, "+resp.getVoterName()+" : You've voted successfully";
			resp.setMsg(msg);
		}else {
			msg="Hello, "+resp.getVoterName()+" : Please Vote";
			resp.setMsg(msg);
		}
		return resp;
	}

}
