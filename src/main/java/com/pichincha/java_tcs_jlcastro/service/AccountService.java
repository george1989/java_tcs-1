package com.pichincha.java_tcs_jlcastro.service;

import java.util.List;
import java.util.Optional;

import com.pichincha.java_tcs_jlcastro.dto.AccountDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;

public interface AccountService {

	public List<AccountDto> getCountries();

	public AccountDto saveAccount(AccountDto Account);

	public AccountDto update(AccountDto Account, Long id) throws NoResourceException;

	public void deleteAccount(Long id) throws NoResourceException;

	public Optional<AccountDto> findAccount(Long id);
}