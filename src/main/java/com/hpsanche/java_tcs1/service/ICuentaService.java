package com.hpsanche.java_tcs1.service;

import java.util.Optional;

import com.hpsanche.java_tcs1.entity.model.Cuenta;

public interface  ICuentaService {
	public Iterable<Cuenta> FindAll();

	public Optional<Cuenta> FindById(Long Id);

	public Cuenta Save(Cuenta cuenta);

	public void DeleteById(Long Id);
	}
