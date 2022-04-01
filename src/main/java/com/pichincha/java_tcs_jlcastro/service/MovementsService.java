package com.pichincha.java_tcs_jlcastro.service;

import java.util.List;

import com.pichincha.java_tcs_jlcastro.dto.MovementsDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;

public interface MovementsService {
    public List<MovementsDto> getAllMovementss();
    public MovementsDto createMovements(MovementsDto MovementsDto);
    public MovementsDto updateMovements(Integer id, MovementsDto MovementsDto) throws NoResourceException;
    public void deleteMovementse(Integer id) throws NoResourceException;

}
