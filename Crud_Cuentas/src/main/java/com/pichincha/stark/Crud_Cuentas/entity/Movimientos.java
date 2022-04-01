package com.pichincha.stark.Crud_Cuentas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.stark.Crud_Cuentas.Dto.DtoMovimientos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TABLE_MOVIMIENTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movimientos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMERO_TRANSACCION")
	private Integer numeroTransaccion;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DE_CUENTA", nullable = false)
	private Cuentas deLaCuenta;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "A_CUENTA", nullable = false)
	private Cuentas aLaCuenta;
	
	@Column(name = "MONTO")
	private Double monto;
	
	@JsonIgnore
	public DtoMovimientos getAsTo() {
		return new DtoMovimientos(
				this.numeroTransaccion,
				this.deLaCuenta, 
				this.aLaCuenta, 
				this.monto 
				);
	}
	
}
