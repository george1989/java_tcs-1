package com.hpsanche.java_tcs1.service;

import java.util.Optional;

import com.hpsanche.java_tcs1.entity.model.Movimiento;


public interface  IMovimientoService {

	public Iterable<Movimiento> FindAll();



	public Optional<Movimiento> FindById(Long Id);



	public Movimiento Save(Movimiento movimiento);



	public void DeleteById(Long Id);


	}