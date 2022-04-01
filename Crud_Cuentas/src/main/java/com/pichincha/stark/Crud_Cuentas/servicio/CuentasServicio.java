package com.pichincha.stark.Crud_Cuentas.servicio;

import java.util.List;

import com.pichincha.stark.Crud_Cuentas.entity.Cuentas;

public interface CuentasServicio {

	public List<Cuentas> getAllAccounts();

	public Cuentas readAcountWithNumber(String numeroCuenta) throws Exception;

	public Cuentas createAccount(Cuentas cuenta);

	public Cuentas updateAccount(Integer numeroCIF, Cuentas cuenta)  throws Exception;
}
