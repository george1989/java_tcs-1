package com.mjmolina.ejemplo.model;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mjmolina.ejemplo.dto.CuentaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity

	public class Cuenta {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer numeroCuenta;
		private String nombreCliente;
		private String direccionCliente; 
		
		public CuentaDto ToDto() {
			return new CuentaDto(numeroCuenta,nombreCliente,direccionCliente);
		}
	}



