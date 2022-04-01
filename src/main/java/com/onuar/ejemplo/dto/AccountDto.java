package com.onuar.ejemplo.dto;

import com.onuar.ejemplo.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Integer id;
	private String account_number;
	private String type_account;
	private float balance;

	public Account toEntity() {
		return new Account(id, account_number, type_account, balance);
	}
}
