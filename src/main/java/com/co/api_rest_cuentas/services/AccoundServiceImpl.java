package com.co.api_rest_cuentas.services;

import com.co.api_rest_cuentas.models.Account;
import com.co.api_rest_cuentas.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccoundServiceImpl implements AccountService {

    @Autowired
    protected AccountRepository accountRepository;

    @Override
    @Transactional
    public List<Account> findAll() throws Exception {
        try {
            List<Account> entities = accountRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Account findByID(Long id) throws Exception {
        try {
            Optional<Account> entityOptional = accountRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Account save(Account entity) throws Exception {
        try {
            entity = accountRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Account update(Long id, Account entity) throws Exception {
        try {
            Optional<Account> entityOptional = accountRepository.findById(id);
            Account entityUpdate = entityOptional.get();
            entityUpdate = accountRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (accountRepository.existsById(id)) {
                accountRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
