package com.mjmolina.ejemplo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjmolina.ejemplo.dto.CuentaDto;
import com.mjmolina.ejemplo.exception.ResourceNotFoundException;
import com.mjmolina.ejemplo.model.Cuenta;
import com.mjmolina.ejemplo.repository.CuentaRepository;
import com.mjmolina.ejemplo.services.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepo;

	public List<CuentaDto> getCuentas() {

		List<Cuenta> objCuenta = cuentaRepo.findAll();

		return objCuenta.stream().map(c -> c.ToDto()).collect(Collectors.toList());

	}

	public CuentaDto saveCuenta(CuentaDto cuenta) {

		return cuentaRepo.save(cuenta.toEntity()).ToDto();
	}

	public CuentaDto update(CuentaDto cuenta, int id) throws ResourceNotFoundException {
		Optional<CuentaDto> tutorialData = findCuenta(id);
		if (tutorialData.isPresent()) {
			Cuenta objCuenta = tutorialData.get().toEntity();
			objCuenta.setNombreCliente(cuenta.getNombreCliente());
			objCuenta.setDireccionCliente(cuenta.getDireccionCliente());
			return cuentaRepo.save(objCuenta).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}

	public void deleteCuenta(int id) throws ResourceNotFoundException {
		Optional<CuentaDto> tutorialData = findCuenta(id);
		if (tutorialData.isPresent()) {
			cuentaRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

	public Optional<CuentaDto> findCuenta(Integer id) {

		Optional<Cuenta> objCuenta = cuentaRepo.findById(id);
		Optional<CuentaDto> objCuentaDto;
		if (objCuenta.isPresent()) {

			objCuentaDto = Optional.of(objCuenta.get().ToDto());
		} else {
			objCuentaDto = Optional.empty();
		}
		return objCuentaDto;
	}
}
