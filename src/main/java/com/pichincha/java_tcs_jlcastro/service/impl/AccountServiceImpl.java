package com.pichincha.java_tcs_jlcastro.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.java_tcs_jlcastro.dto.AccountDto;
import com.pichincha.java_tcs_jlcastro.exception.NoResourceException;
import com.pichincha.java_tcs_jlcastro.model.Account;
import com.pichincha.java_tcs_jlcastro.repository.AccountRepo;
import com.pichincha.java_tcs_jlcastro.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo AccountRepo;

	public List<AccountDto> getCountries() {
		
		List<Account> objAccount =AccountRepo.findAll();
		
		return objAccount.stream().map(c -> c.toEntity()).collect(Collectors.toList());
				
	}

	public AccountDto saveAccount(AccountDto Account) {

		return AccountRepo.save(Account.toEntity()).toEntity();
	}

	public AccountDto update(AccountDto Account, Long id) throws NoResourceException {
		Optional<AccountDto> tutorialData = findAccount(id);
		if (tutorialData.isPresent()) {
			Account objAccount = tutorialData.get().toEntity();
			objAccount.setName(Account.getName());
			objAccount.setType(Account.getType());
			return AccountRepo.save(objAccount).toEntity();
		} else {
			throw new NoResourceException("Id not exists");
		}

	}

	public void deleteAccount(Long id) throws NoResourceException {
		Optional<AccountDto> tutorialData = findAccount(id);
		if (tutorialData.isPresent()) {
			AccountRepo.deleteById(id);
		} else {
			throw new NoResourceException("Id not exists");
		}
	}

	public Optional<AccountDto> findAccount(Long id) {
		
		Optional<Account>  objAccount = AccountRepo.findById(id);
		Optional<AccountDto> objAccountDto;
		if(objAccount.isPresent()) {
			
			objAccountDto =  Optional.of(objAccount.get().toEntity());
		}
		else {
			objAccountDto = Optional.empty();
		}	
		return objAccountDto;
	}
}