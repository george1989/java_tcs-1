package com.onuar.ejemplo.services;

import java.util.List;
import java.util.Optional;

import com.onuar.ejemplo.dto.AccountDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;

public interface AccountService {

	public List<AccountDto> get();

	public AccountDto save(AccountDto country);

	public AccountDto update(AccountDto country, int id) throws ResourceNotFoundException;

	public void delete(int id) throws ResourceNotFoundException;

	public Optional<AccountDto> findCountry(Integer id);
}