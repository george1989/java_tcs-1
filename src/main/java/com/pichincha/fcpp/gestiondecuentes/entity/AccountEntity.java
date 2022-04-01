package com.pichincha.fcpp.gestiondecuentes.entity;

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
import com.pichincha.fcpp.gestiondecuentes.dto.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TBL_ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_BANK")
	private String accountBank;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sourceAccountDetalles", orphanRemoval = true)
	private List<MovementsEntity> allMovementsWhereSource;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "destinationAccountDetalles", orphanRemoval = true)
	private List<MovementsEntity> allMovementsWhereDestination;
	
	public AccountEntity(Integer _accountId, String _accountNumber, String _accountType, String _accountBank,
			List<MovementsEntity> _allMovementsWhereSource, List<MovementsEntity> _allMovementsWhereDestination) {
	}

	@JsonIgnore
	public AccountDto getAsTo() {
		return new AccountDto(
				this.accountId,
				this.accountNumber, 
				this.accountType, 
				this.accountBank, 
				this.allMovementsWhereSource,
				this.allMovementsWhereDestination 
				);
	}

    public void setAllMovementsWhereSource(Object object) {
    }

    public void setAllMovementsWhereDestination(Object object) {
    }

    public Object getAccountNumber() {
        return null;
    }

    public void setAccountNumber(Object accountNumber2) {
    }

    public Object getAccountBank() {
        return null;
    }

    public Object getAccountType() {
        return null;
    }

    public void setAccountBank(Object accountBank2) {
    }

    public void setAccountType(Object accountType2) {
    }
}
