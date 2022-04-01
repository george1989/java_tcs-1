package com.pichincha.stark.Crud_Cuentas.respositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pichincha.stark.Crud_Cuentas.entity.Cuentas;

public interface CuentasRepositorio extends CrudRepository<Cuentas, Integer>{
	
	List<Cuentas> findAllByAccountNumber(String numeroCuenta);

}
