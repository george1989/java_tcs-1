package com.onuar.ejemplo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onuar.ejemplo.dto.MovementDto;
import com.onuar.ejemplo.model.Movement;
import com.onuar.ejemplo.repository.MovementRepo;

@Service
public class MovementServiceImpl {
	
	@Autowired
	private MovementRepo movementRepo;

	public List<MovementDto> get() {
		
		List<Movement> objAccount =movementRepo.findAll();
		
		return objAccount.stream().map(c -> c.ToDto()).collect(Collectors.toList());
				
	}

}
