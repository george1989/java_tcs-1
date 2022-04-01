package com.pichincha.stark.Crud_Cuentas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pichincha.stark.Crud_Cuentas.entity.Cuentas;
import com.pichincha.stark.Crud_Cuentas.servicio.CuentasServicio;

@Controller
@RequestMapping("/cuenta")
public class CuentasController {

	@Autowired
	private CuentasServicio accountService;
	
	@GetMapping(path = "/readAll")
	public ResponseEntity<?> readAllAccounts() {

		try {
			List<Cuentas> cuentas = accountService.getAllAccounts();
			return new ResponseEntity<>(cuentas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(path = "/read/{accountNumber}")
	public ResponseEntity<?> readAcountWithNumber(@PathVariable String accountNumber) {

		try {
			Cuentas cuenta = accountService.readAcountWithNumber(accountNumber);
			return new ResponseEntity<>(cuenta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> createAccount(@RequestBody Cuentas  cuenta) {

		try {
			Cuentas accountEntityAfter = accountService.createAccount(cuenta);
			return new ResponseEntity<>(accountEntityAfter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(path = "/update/{accountId}", consumes = "application/json")
	public ResponseEntity<?> updateAccount(@PathVariable Integer accountId, @RequestBody Cuentas  cuenta) {

		try {
			Cuentas accountEntityAfter = accountService.updateAccount(accountId, cuenta);
			return new ResponseEntity<>(accountEntityAfter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
}
