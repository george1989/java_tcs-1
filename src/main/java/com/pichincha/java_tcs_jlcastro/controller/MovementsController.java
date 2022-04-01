package com.pichincha.java_tcs_jlcastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.java_tcs_jlcastro.dto.MovementsDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;
import com.pichincha.java_tcs_jlcastro.model.Movements;
import com.pichincha.java_tcs_jlcastro.service.MovementsService;

@RestController
@RequestMapping("api/v1/movements")
public class MovementsController {
    @Autowired
    private MovementsService movementsService;

    @GetMapping
    public ResponseEntity<List<MovementsDto>> getAllCelula() {
        return new ResponseEntity<List<MovementsDto>>(movementsService.getAllMovementss(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody MovementsDto movementsDto) {
        return new ResponseEntity(movementsService.createMovements(movementsDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long personId, @RequestBody MovementsDto movementsDto) {
        try {
            return new ResponseEntity(movementsService.updateMovements(personId, movementsDto), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable(value = "orderId") Long orderId) {
        try {
            movementsService.deleteMovementse(orderId);
            return new ResponseEntity("Se elimino la entidad",HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
