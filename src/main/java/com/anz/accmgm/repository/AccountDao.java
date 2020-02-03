package com.anz.accmgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.accmgm.domain.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

}
