package com.pichincha.java_tcs_jlcastro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.java_tcs_jlcastro.dto.MovementsDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;
import com.pichincha.java_tcs_jlcastro.model.Movements;
import com.pichincha.java_tcs_jlcastro.repository.MovementsRepo;
import com.pichincha.java_tcs_jlcastro.service.MovementsService;

@Service
public class MovementsServiceImpl implements MovementsService {
    @Autowired
    MovementsRepo MovementsRepository;
    
    
	@Override
	public List<MovementsDto> getAllMovementss() {
        List<Movements> movements = MovementsRepository.findAll();
        List<MovementsDto> movementsDtos = new ArrayList<>();
        movements.stream().forEach((movement) -> {
        	movementsDtos.add(movement.toEntity());
        });
        return movementsDtos;
	}

	@Override
	public MovementsDto createMovements(MovementsDto MovementsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovementsDto updateMovements(Long id, MovementsDto MovementsDto) throws NoResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovementse(Long id) throws NoResourceException {
		// TODO Auto-generated method stub
		
	}

}