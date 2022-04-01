package com.mjmolina.ejemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjmolina.ejemplo.model.Movimientos;
import com.mjmolina.ejemplo.repository.MovimientosRepository;

@Service
public class MovimientosService {
	@Autowired
	private MovimientosRepository movimientoRepository;

	public List<Movimientos> getMovimientos() {
		return movimientoRepository.findAll();
	}

	public Movimientos save(Movimientos movimientos) {

		return movimientoRepository.save(movimientos);
	}

	public void delete(int id) {
		movimientoRepository.deleteById(id);
	}

	public void update(Movimientos movimientos, int id) {

		movimientoRepository.save(movimientos);
	}

	public Optional<Movimientos> findById(Integer id) {

		return movimientoRepository.findById(id);
	}
}
