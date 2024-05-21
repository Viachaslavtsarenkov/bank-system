package com.tsarankou.bankprocessor.data.repository;

import com.tsarankou.bankprocessor.data.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
