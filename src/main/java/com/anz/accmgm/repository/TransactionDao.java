package com.anz.accmgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.accmgm.domain.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
