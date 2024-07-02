package com.example.banking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banking_app.entity.AccountDetails;

@Repository
public interface AccountsRepository extends JpaRepository<AccountDetails, Long> {
	AccountDetails findByAccountNumber(long accountNumber);
}
