package com.pichincha.fcpp.gestiondecuentes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer>{
	
	List<AccountEntity> findAllByAccountNumber(String accountNumber);

}
