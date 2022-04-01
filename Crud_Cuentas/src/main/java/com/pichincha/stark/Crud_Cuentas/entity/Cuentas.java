package com.pichincha.stark.Crud_Cuentas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.stark.Crud_Cuentas.Dto.DtoCuentas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TBL_CUENTAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuentas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMERO_CIF")
	private Integer numeroCIF;

	@Column(name = "NUMERO_CUENTA")
	private String numeroCuenta;

	@Column(name = "TIPO_CUENTA")
	private String tipo;

	@Column(name = "SALDO")
	private String saldo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sourceAccountDetalles", orphanRemoval = true)
	private List<Movimientos> sourceMovimientos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "destinationAccountDetalles", orphanRemoval = true)
	private List<Movimientos> destinacionMovimientos;
	
	@JsonIgnore
	public DtoCuentas getAsTo() {
		return new DtoCuentas(
				this.numeroCIF,
				this.numeroCuenta, 
				this.tipo, 
				this.saldo, 
				this.sourceMovimientos,
				this.destinacionMovimientos 
				);
	}
}
