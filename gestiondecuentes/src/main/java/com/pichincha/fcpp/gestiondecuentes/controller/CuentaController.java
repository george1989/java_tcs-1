package com.pichincha.fcpp.gestiondecuentes.controller;

import java.util.List;

import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;
import com.pichincha.fcpp.gestiondecuentes.service.AccountService;

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

@Controller
@RequestMapping("/account")
public class CuentaController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/readAll")
	public ResponseEntity<?> readAllAccounts() {

		try {
			List<AccountEntity> accountEntities = accountService.getAllAccounts();
			return new ResponseEntity<>(accountEntities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(path = "/read/{accountNumber}")
	public ResponseEntity<?> readAcountWithNumber(@PathVariable String accountNumber) {

		try {
			AccountEntity accountEntity = accountService.readAcountWithNumber(accountNumber);
			return new ResponseEntity<>(accountEntity, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<?> createAccount(@RequestBody AccountEntity  accountEntity) {

		try {
			AccountEntity accountEntityAfter = accountService.createAccount(accountEntity);
			return new ResponseEntity<>(accountEntityAfter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(path = "/update/{accountId}", consumes = "application/json")
	public ResponseEntity<?> updateAccount(@PathVariable Integer accountId, @RequestBody AccountEntity  accountEntity) {

		try {
			AccountEntity accountEntityAfter = accountService.updateAccount(accountId, accountEntity);
			return new ResponseEntity<>(accountEntityAfter, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	

}
