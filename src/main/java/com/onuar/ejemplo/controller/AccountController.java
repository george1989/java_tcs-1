package com.onuar.ejemplo.controller;

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

import com.onuar.ejemplo.dto.AccountDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;
import com.onuar.ejemplo.services.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping()
	public List<AccountDto> getAccounts() {
		return accountService.get();
	}

	@PostMapping()
	public ResponseEntity<?> postAccount(@RequestBody AccountDto account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(account));

	}

	@DeleteMapping("/{countryid}")
	private ResponseEntity<?> deleteAccount(@PathVariable("countryid") int id) {

		try {
			accountService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") Integer id, @RequestBody AccountDto country) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(accountService.update(country, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}