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
import java.util.Optional;

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
	public MovementsDto createMovements(MovementsDto movementsDto) {
        return MovementsRepository.save(movementsDto.toEntity()).toEntity();
	}

	@Override
	public MovementsDto updateMovements(Integer id, MovementsDto movementsDto) throws NoResourceException {
        Optional<Movements> movements = MovementsRepository.findById(id);
        if (movements.isPresent()) {
        	movements.get().setId(movementsDto.getId());
        	movements.get().setName(movementsDto.getName());
        	movements.get().setAccount(movementsDto.getAccount().toEntity());
            return MovementsRepository.save(movements.get()).toEntity();
        }
        else {
            throw  new NoResourceException("No existe la persona con id : "+id);
        }
	}

	@Override
	public void deleteMovementse(Integer id) throws NoResourceException {
        Optional<Movements> Account = MovementsRepository.findById(id);
        if(Account.isPresent()){
        	MovementsRepository.delete(Account.get());
        }else{
            throw  new NoResourceException("No existe la persona con id : "+id);
        }
	}

}