package com.hpsanche.java_tcs1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpsanche.java_tcs1.entity.model.Movimiento;
import com.hpsanche.java_tcs1.repository.IMovimientoRepository;

@Service
public class MovimientoService implements IMovimientoService {

@Autowired
private IMovimientoRepository iMovimientoRepository;

@Override
public Iterable<Movimiento> FindAll() {
return iMovimientoRepository.findAll();
}



@Override
public Optional<Movimiento> FindById(Long Id) {
return iMovimientoRepository.findById(Id);
}



@Override
public Movimiento Save(Movimiento movimiento) {
return iMovimientoRepository.save(movimiento);
}



@Override
public void DeleteById(Long Id) {
iMovimientoRepository.deleteById(Id);

}



}