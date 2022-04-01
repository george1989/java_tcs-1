package com.mjmolina.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mjmolina.ejemplo.model.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
