package com.hpsanche.java_tcs1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpsanche.java_tcs1.entity.model.Cuenta;
import com.hpsanche.java_tcs1.repository.ICuentaRepository;

@Service
public class CuentaService implements ICuentaService  {
	@Autowired
	private ICuentaRepository iCuentaRepository;

	@Override
	public Iterable<Cuenta> FindAll() {
	return iCuentaRepository.findAll();
	}



	@Override
	public Optional<Cuenta> FindById(Long Id) {
	return iCuentaRepository.findById(Id);
	}



	@Override
	public Cuenta Save(Cuenta cuenta) {
	return iCuentaRepository.save(cuenta);
	}



	@Override
	public void DeleteById(Long Id) {
	iCuentaRepository.deleteById(Id);



	}



	}
