package com.pichincha.java_tcs_jlcastro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.java_tcs_jlcastro.model.Account;
import com.pichincha.java_tcs_jlcastro.model.Movements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementsDto {
	private Integer id;
	private String name;
	private String code;
	private AccountDto account;
	
	public Movements toEntity() {
		Account obj = null;
		if(account != null)
		{
			obj=account.toEntity();
		}
		return new Movements(id,name,code,obj);
	}
}
