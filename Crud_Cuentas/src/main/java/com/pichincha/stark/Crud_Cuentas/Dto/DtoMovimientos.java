package com.pichincha.stark.Crud_Cuentas.Dto;

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
public class DtoMovimientos {

	private Integer _numeroTransaccion;

	private Cuentas _deLaCuenta;

	private Cuentas _aLaCuenta;
	
	private Double _monto;
	
	@JsonIgnore
	public Movimientos getAsEntity() {
		return new Movimientos(
				this._numeroTransaccion,
				this._deLaCuenta, 
				this._aLaCuenta, 
				this._monto 
				);
	}

	
}
