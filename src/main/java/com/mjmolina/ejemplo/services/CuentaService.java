package com.mjmolina.ejemplo.services;

import java.util.List;
import java.util.Optional;

import com.mjmolina.ejemplo.dto.CuentaDto;
import com.mjmolina.ejemplo.exception.ResourceNotFoundException;

public interface CuentaService {
	
	public List<CuentaDto> getCuentas();

	public CuentaDto saveCuenta(CuentaDto cuenta);

	public CuentaDto update(CuentaDto cuenta, int id) throws ResourceNotFoundException;

	public void deleteCuenta(int id) throws ResourceNotFoundException;

	public Optional<CuentaDto> findCuenta(Integer id);
}
