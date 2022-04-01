package com.pichincha.stark.Crud_Cuentas.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pichincha.stark.Crud_Cuentas.entity.Cuentas;
import com.pichincha.stark.Crud_Cuentas.respositorio.CuentasRepositorio;
import com.pichincha.stark.Crud_Cuentas.servicio.CuentasServicio;

public class CuentasServicioImpl implements CuentasServicio{
	@Autowired
	private CuentasRepositorio cuentaRepository;

	@Override
	public List<Cuentas> getAllAccounts() {
		List<Cuentas> accountEntities = (List<Cuentas>) cuentaRepository.findAll();

		/*
		 * List<AccountDto> accountDtos = new ArrayList<>();
		 * 
		 * accountEntities.stream().forEach((client) -> {
		 * accountDtos.add(client.getAsTo()); });
		 */

		return accountEntities;
	}

	@Override
	public Cuentas readAcountWithNumber(String accountNumber) throws Exception {

		List<Cuentas> accountEntities = cuentaRepository.findAllByAccountNumber(accountNumber);

		if (accountEntities == null) {
			throw new Exception("Account Not Found");
		}
		if (accountEntities.size() != 1) {
			throw new Exception("Account Not Found");
		}

		return accountEntities.get(0);
	}

	@Override
	public Cuentas createAccount(Cuentas accountEntity) {
		
		accountEntity.setSourceMovimientos(null);
		accountEntity.setDestinacionMovimientos(null);


		Cuentas accountEntityAfter = cuentaRepository.save(accountEntity);
		return accountEntityAfter;
	}

	@Override
	public Cuentas updateAccount(Integer accountId, Cuentas accountEntity) throws Exception {

		Cuentas accountEntityDb = cuentaRepository.findById(accountId).orElse(null);

		if (accountEntityDb == null) {
			throw new Exception("Account Not Found");
		}
		
		accountEntityDb.setNumeroCuenta(accountEntity.getNumeroCuenta());
		accountEntityDb.setSaldo(accountEntity.getSaldo());
		accountEntityDb.setTipo(accountEntity.getTipo());
		
		

		Cuentas accountEntityAfter = cuentaRepository.save(accountEntityDb);
		return accountEntityAfter;
	}
}
