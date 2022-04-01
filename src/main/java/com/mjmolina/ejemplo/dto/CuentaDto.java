package com.mjmolina.ejemplo.dto;

import com.mjmolina.ejemplo.model.Cuenta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDto {

	private Integer numeroCuenta;
	private String nombreCliente;
	private String direccionCliente; 

	public Cuenta toEntity() {
		return new Cuenta(numeroCuenta, nombreCliente, direccionCliente);
	}

}
