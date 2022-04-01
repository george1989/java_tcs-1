package com.mjmolina.ejemplo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientosDto {
	private Integer id;
	private double valor;
	private String tipoMovimiento;
	private CuentaDto cuenta;
}
