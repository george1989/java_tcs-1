package com.pichincha.java_tcs_jlcastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.java_tcs_jlcastro.model.Movements;

@Repository
public interface MovementsRepo extends JpaRepository<Movements, Integer> {

}
