package com.co.api_rest_cuentas.services;

import com.co.api_rest_cuentas.models.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll() throws Exception;
    public Account findByID(Long id) throws Exception;
    public Account save(Account entity) throws Exception;
    public Account update(Long id, Account entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}