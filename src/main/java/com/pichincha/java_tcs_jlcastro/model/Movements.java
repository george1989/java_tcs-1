package com.pichincha.java_tcs_jlcastro.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.java_tcs_jlcastro.dto.AccountDto;
import com.pichincha.java_tcs_jlcastro.dto.MovementsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String code;
	
	@ManyToOne
	private Account account;
	

	@JsonIgnore
	public MovementsDto toEntity() {
		AccountDto obj = null;
		if(account != null)
		{
			obj=account.toEntity();
		}
		return new MovementsDto(id,name,code,obj);
	}
	
}