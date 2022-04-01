package com.pichincha.java_tcs_jlcastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.java_tcs_jlcastro.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
