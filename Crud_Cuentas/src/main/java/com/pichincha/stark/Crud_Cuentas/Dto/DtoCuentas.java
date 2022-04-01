package com.pichincha.stark.Crud_Cuentas.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.stark.Crud_Cuentas.entity.Cuentas;
import com.pichincha.stark.Crud_Cuentas.entity.Movimientos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCuentas {
	
	private Integer _numeroCIF;

	private String _numeroCuenta;

	private String _tipo;
	
	private String _saldo;
	
	private List<Movimientos> _sourceMovimientos;

	private List<Movimientos> _destinacionMovimientos;
	
	@JsonIgnore
	public Cuentas getAsEntity() {
		return new Cuentas(
				this._numeroCIF,
				this._numeroCuenta, 
				this._tipo, 
				this._saldo, 
				this._sourceMovimientos,
				this._destinacionMovimientos 
				);
	}
}
