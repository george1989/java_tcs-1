package com.onuar.ejemplo.dto;
import com.onuar.ejemplo.model.Account;
import com.onuar.ejemplo.model.Movement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

	private Integer id;
	private String destination_account;
	private String destination_type_account;
	private String destination_description_account;	
	private Float transaction_value;
	private AccountDto country;
	
	
	public Movement toEntity() {
		
		Account obj = null;
		if(country != null)
		{
			obj=country.toEntity();
		}
		
		return new Movement(id, destination_account, destination_type_account, destination_description_account,transaction_value,obj);
	}
	
	
	
	
}