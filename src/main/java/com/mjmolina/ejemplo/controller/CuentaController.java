package com.mjmolina.ejemplo.controller;

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

import com.mjmolina.ejemplo.dto.CuentaDto;
import com.mjmolina.ejemplo.exception.ResourceNotFoundException;
import com.mjmolina.ejemplo.services.CuentaService;


@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@GetMapping()
	public List<CuentaDto> getCuentas() {
		return cuentaService.getCuentas();
	}

	@PostMapping()
	public ResponseEntity<?> postCuenta(@RequestBody CuentaDto cuenta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.saveCuenta(cuenta));

	}

	@DeleteMapping("/{cuentaid}")
	private ResponseEntity<?> deleteCuenta(@PathVariable("cuentaid") int id) {

		try {
			cuentaService.deleteCuenta(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CuentaDto> updateTutorial(@PathVariable("id") Integer id, @RequestBody CuentaDto cuenta) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(cuentaService.update(cuenta, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}