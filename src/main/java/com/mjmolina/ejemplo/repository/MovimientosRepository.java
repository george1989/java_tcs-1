package com.mjmolina.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjmolina.ejemplo.model.Movimientos;

public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {

}
