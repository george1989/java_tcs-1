package com.hpsanche.java_tcs1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpsanche.java_tcs1.entity.model.Movimiento;
@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long>  {

}
