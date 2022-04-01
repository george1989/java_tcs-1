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

import com.pichincha.java_tcs_jlcastro.dto.AccountDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;
import com.pichincha.java_tcs_jlcastro.service.AccountService;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
	@Autowired
	private AccountService AccountService;

	@GetMapping()
	public List<AccountDto> getCountries() {
		return AccountService.getCountries();
	}

	@PostMapping()
	public ResponseEntity<?> postCountrie(@RequestBody AccountDto Account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(AccountService.saveAccount(Account));

	}

	@DeleteMapping("/{Accountid}")
	private ResponseEntity<?> deleteAccount(@PathVariable("Accountid") Long id) {

		try {
			AccountService.deleteAccount(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoResourceException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateTutorial(@PathVariable("id") Long id, @RequestBody AccountDto Account) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(AccountService.update(Account, id));
		} catch (NoResourceException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}