package com.pichincha.fcpp.gestiondecuentes.service;

import java.util.List;

import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;

public interface AccountService {

	public List<AccountEntity> getAllAccounts();

	public AccountEntity readAcountWithNumber(String accountNumber) throws Exception;

	public AccountEntity createAccount(AccountEntity accountEntity);

	public AccountEntity updateAccount(Integer accountId, AccountEntity accountEntity)  throws Exception;

}
