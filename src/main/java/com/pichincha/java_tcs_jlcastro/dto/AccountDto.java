package com.pichincha.java_tcs_jlcastro.dto;

import com.pichincha.java_tcs_jlcastro.model.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private Long id;
	private String name;
	private String type;
	private Double balance;

	public Account toEntity() {
		return new Account(id,name,type,balance);
	}
}
