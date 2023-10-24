package com.co.api_rest_cuentas.services;

import com.co.api_rest_cuentas.models.Account;
import com.co.api_rest_cuentas.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccoundServiceImpl implements AccountService {

    @Autowired
    protected AccountRepository accountRepository;

    @Override
    @Transactional
    public List<Account> findAll() throws Exception {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Account findByID(Long id) throws Exception {
        return accountRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Account save(Account entity) throws Exception {
        return accountRepository.save(entity);
    }

    @Override
    @Transactional
    public Account update(Account entity) throws Exception {
        return accountRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        accountRepository.deleteById(id);
    }
}