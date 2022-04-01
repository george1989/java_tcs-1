package com.onuar.ejemplo.services;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onuar.ejemplo.dto.MovementDto;



import com.onuar.ejemplo.exception.ResourceNotFoundException;




public interface MovementService {
	public List<MovementDto> get();

	

	
}
