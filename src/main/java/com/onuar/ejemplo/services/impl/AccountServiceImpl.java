package com.onuar.ejemplo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onuar.ejemplo.dto.AccountDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;
import com.onuar.ejemplo.model.Account;
import com.onuar.ejemplo.repository.AccountRepo;
import com.onuar.ejemplo.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public List<AccountDto> get() {
		
		List<Account> objAccount =accountRepo.findAll();
		
		return objAccount.stream().map(c -> c.ToDto()).collect(Collectors.toList());
				
	}

	public AccountDto save(AccountDto account) {

		return accountRepo.save(account.toEntity()).ToDto();
	}

	public AccountDto update(AccountDto account, int id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData = findCountry(id);
		if (tutorialData.isPresent()) {
			Account objAccount = tutorialData.get().toEntity();
			objAccount.setAccount_number(account.getAccount_number());
			objAccount.setType_account(account.getType_account());
			objAccount.setBalance(account.getBalance());
			return accountRepo.save(objAccount).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}

	public void delete(int id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData = findCountry(id);
		if (tutorialData.isPresent()) {
			accountRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

	public Optional<AccountDto> findCountry(Integer id) {
		
		Optional<Account>  objAccount = accountRepo.findById(id);
		Optional<AccountDto> objAccountDto;
		if(objAccount.isPresent()) {
			
			objAccountDto =  Optional.of(objAccount.get().ToDto());
		}
		else {
			objAccountDto = Optional.empty();
		}	
		return objAccountDto;
	}
}
