package com.co.api_rest_cuentas.repositories;

import com.co.api_rest_cuentas.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
