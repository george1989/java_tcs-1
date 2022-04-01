
package com.onuar.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onuar.ejemplo.model.Movement;

@Repository
public interface MovementRepo extends JpaRepository<Movement, Integer> {

}
