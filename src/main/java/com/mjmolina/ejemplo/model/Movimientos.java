package com.mjmolina.ejemplo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mjmolina.ejemplo.dto.CuentaDto;
import com.mjmolina.ejemplo.dto.MovimientosDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movimientos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double monto;
	private String tipoMovimiento;

	@ManyToOne
	private Cuenta cuenta;

	public MovimientosDto ToDto() {
		CuentaDto obj = null;
		if (cuenta != null) {
			obj = cuenta.ToDto();
		}
		return new MovimientosDto(id, monto, tipoMovimiento, obj);
	}

}
