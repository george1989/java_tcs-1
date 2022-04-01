package com.onuar.ejemplo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.onuar.ejemplo.dto.AccountDto;
import com.onuar.ejemplo.dto.MovementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String destination_account;
	private String destination_type_account;
	private String destination_description_account;	
	private Float transaction_value;
	
	@ManyToOne
	private Account account;
	
	
	public MovementDto ToDto() {
		AccountDto obj = null;
		if(account != null)
		{
			obj=account.ToDto();
		}
		return new MovementDto(id,destination_account,destination_type_account,destination_description_account,transaction_value,obj);
	}
	
	
	

}